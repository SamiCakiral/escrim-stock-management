package com.webapp.mvc.stock;

import java.sql.Connection;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.webapp.mvc.materiel.MaterielMedical;
import com.webapp.mvc.materiel.Medicament;
import com.webapp.mvc.materiel.Equipement;

/**
 * Cette classe implémente l'interface DAOStock et fournit les méthodes pour interagir avec la base de données
 * pour la gestion des colis.
 *
 * @author CS
 */
public class DAOStockImpl implements DAOStock {
    private Connection connection;

    /**
     * Constructeur de la classe DAOStockImpl.
     *
     * @param connection L'objet Connection utilisé pour interagir avec la base de données.
     */
    public DAOStockImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Insère un nouveau colis dans la base de données.
     *
     * @param coli Le colis à insérer.
     * @return true si l'insertion est réussie, false sinon.
     */
    @Override
    public boolean insertColi(Coli coli) {
        String sql = "INSERT INTO coli (nom, type, poids, dimensions) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, coli.getNom());
            pstmt.setString(2, coli.getType());
            pstmt.setDouble(3, coli.getPoids());
            pstmt.setString(4, Double.toString(coli.getDimensions()[0]) + "x" +
                    Double.toString(coli.getDimensions()[1]) + "x" +
                    Double.toString(coli.getDimensions()[2]));
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Met à jour un colis existant dans la base de données.
     *
     * @param coli Le colis à mettre à jour.
     * @return true si la mise à jour est réussie, false sinon.
     */
    @Override
    public boolean updateColi(Coli coli) {
        String sql = "UPDATE coli SET nom = ?, type = ?, poids = ?, dimensions = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, coli.getNom());
            pstmt.setString(2, coli.getType());
            pstmt.setDouble(3, coli.getPoids());
            pstmt.setString(4, Double.toString(coli.getDimensions()[0]) + "x" +
                    Double.toString(coli.getDimensions()[1]) + "x" +
                    Double.toString(coli.getDimensions()[2]));
            pstmt.setInt(5, coli.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Recherche un colis dans la base de données en utilisant son identifiant.
     *
     * @param id L'identifiant du colis à rechercher.
     * @return Le colis trouvé, ou null si aucun colis correspondant à l'identifiant n'est trouvé.
     */
    @Override
    public Coli findColiById(int id) {
        String sql = "SELECT * FROM coli WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Coli coli = new Coli(rs.getString("nom"), rs.getString("type"), null); // handle materielMedicalIds appropriately
                coli.setId(rs.getInt("id"));
                coli.setPoids(rs.getDouble("poids"));
                String dim = rs.getString("dimensions");
                coli.setDimensions(Arrays.stream(dim.split("x")).mapToDouble(Double::parseDouble).toArray());
                return coli;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Récupère tous les colis présents dans la base de données.
     *
     * @return Une liste contenant tous les colis présents dans la base de données.
     */
    @Override
    public ArrayList<Coli> findAllColis() {
        ArrayList<Coli> colis = new ArrayList<>();
        String sql = "SELECT * FROM coli";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Coli coli = new Coli(rs.getString("nom"), rs.getString("type"), null); // handle materielMedicalIds appropriately
                coli.setId(rs.getInt("id"));
                coli.setPoids(rs.getDouble("poids"));
                String dim = rs.getString("dimensions");
                coli.setDimensions(Arrays.stream(dim.split("x")).mapToDouble(Double::parseDouble).toArray());
                colis.add(coli);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colis;
    }

    /**
     * Supprime un colis de la base de données en utilisant son identifiant.
     *
     * @param id L'identifiant du colis à supprimer.
     * @return true si la suppression est réussie, false sinon.
     */
    @Override
    public boolean deleteColi(int id) {
        String sql = "DELETE FROM coli WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public ArrayList<MaterielMedical> getAllElementFromColiId(int idDuColis) {
        ArrayList<MaterielMedical> materiels = new ArrayList<MaterielMedical>();
        String sql = "SELECT mm.* FROM materiel_medical mm " +
                     "JOIN materiel_coli mc ON mm.id = mc.materiel_id " +
                     "WHERE mc.id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idDuColis);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MaterielMedical materiel = createMaterielFromResultSet(rs);
                materiels.add(materiel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materiels;
    }

    private MaterielMedical createMaterielFromResultSet(ResultSet rs) throws SQLException {
        String type = rs.getString("type");
        MaterielMedical materiel = type.equals("medicament") ?
            new Medicament(
                rs.getString("nom"),
                rs.getInt("quantite_en_stock"),
                rs.getString("description"),
                rs.getString("fournisseur"),
                rs.getDate("date_expiration"),
                rs.getString("indications"),
                rs.getString("contre_indications"),
                rs.getInt("id"),
                rs.getDouble("poids")
            ) :
            new Equipement(
                rs.getString("nom"),
                rs.getInt("quantite_en_stock"),
                rs.getString("description"),
                rs.getString("fournisseur"),
                rs.getDate("date_expiration"),
                rs.getInt("id"),
                rs.getDouble("poids")
            );
        materiel.setId(rs.getInt("id"));
        return materiel;
    }
}

