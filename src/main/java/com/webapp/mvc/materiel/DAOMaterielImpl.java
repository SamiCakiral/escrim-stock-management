package com.webapp.mvc.materiel;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.webapp.mvc.materiel.MaterielMedical;
import com.webapp.mvc.materiel.Medicament;
import com.webapp.mvc.materiel.Equipement;
import java.sql.Date;

public class DAOMaterielImpl implements DAOMateriel {

    private Connection connection;

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("DAOMateriel");
    public DAOMaterielImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertMateriel(MaterielMedical materiel) {
        String sql = "INSERT INTO materiel_medical (nom, quantite_en_stock, description, fournisseur, poids, date_expiration, type) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, materiel.getNom());
            pstmt.setInt(2, materiel.getQuantiteEnStock());
            pstmt.setString(3, materiel.getDescription());
            pstmt.setString(4, materiel.getFournisseur());
            pstmt.setDouble(5, materiel.getPoids());
            pstmt.setDate(6, new java.sql.Date(materiel.getDateExpiration().getTime()));
            pstmt.setString(7, materiel instanceof Medicament ? "medicament" : "equipement");
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateMateriel(MaterielMedical materiel) {
        String sql = "UPDATE materiel_medical SET nom = ?, quantite_en_stock = ?, description = ?, fournisseur = ?, poids = ?, date_expiration = ?, type = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, materiel.getNom());
            pstmt.setInt(2, materiel.getQuantiteEnStock());
            pstmt.setString(3, materiel.getDescription());
            pstmt.setString(4, materiel.getFournisseur());
            pstmt.setDouble(5, materiel.getPoids());
            pstmt.setDate(6, new java.sql.Date(materiel.getDateExpiration().getTime()));
            pstmt.setString(7, materiel instanceof Medicament ? "medicament" : "equipement");
            pstmt.setInt(8, materiel.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public MaterielMedical findMaterielById(int id) {
        String sql = "SELECT * FROM materiel_medical WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int materielId = rs.getInt("id");
                String nom = rs.getString("nom");
                int quantiteEnStock = rs.getInt("quantite_en_stock");
                String description = rs.getString("description");
                String fournisseur = rs.getString("fournisseur");
                double poids = rs.getDouble("poids");
                Date dateExpiration = rs.getDate("date_expiration");
                int coliId = rs.getInt("id");
                String type = rs.getString("type");

                if (type.equals("medicament")) {
                    String indications = rs.getString("indications");
                    String contreIndications = rs.getString("contre_indications");
                    return new Medicament(nom, quantiteEnStock, description, fournisseur, dateExpiration, indications,
                            contreIndications, coliId, poids);
                } else {
                    
                    return new Equipement(nom, quantiteEnStock, description, fournisseur, dateExpiration,
                             coliId, poids);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<MaterielMedical> findAllMateriel() {
        ArrayList<MaterielMedical> materiels = new ArrayList<>();
        String sql = "SELECT * FROM materiel_medical";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int materielId = rs.getInt("id");
                String nom = rs.getString("nom");
                int quantiteEnStock = rs.getInt("quantite_en_stock");
                String description = rs.getString("description");
                String fournisseur = rs.getString("fournisseur");
                double poids = rs.getDouble("poids");
                Date dateExpiration = rs.getDate("date_expiration");
                int coliId = rs.getInt("id");
                String type = rs.getString("type");

                if (type.equals("medicament")) {
                    String indications = rs.getString("indications");
                    String contreIndications = rs.getString("contre_indications");
                    materiels.add(new Medicament(nom, quantiteEnStock, description, fournisseur, dateExpiration,
                            indications, contreIndications, coliId, poids));
                } else {
                    
                    materiels.add(new Equipement(nom, quantiteEnStock, description, fournisseur, dateExpiration,
                             coliId, poids));
                }
            }
            log.info("All materiels found successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materiels;
    }

    @Override
    public boolean deleteMateriel(int id) {
        String sql = "DELETE FROM materiel_medical WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
