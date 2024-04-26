package com.webapp.mvc.personne.personnel;
import java.sql.Connection;
import java.util.ArrayList;

import com.webapp.mvc.Application;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 * Cette classe implémente l'interface DAOPersonnel et fournit les méthodes pour interagir avec la base de données
 * pour la gestion du personnel.
 *
 * @author CS
 */
public class DAOPersonnelImpl implements DAOPersonnel {

    private Connection connection;
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("DAOPersonnelImpl");
    private static final Application app = Application.getInstance();

    /**
     * Constructeur de la classe DAOPersonnelImpl.
     *
     * @param connection L'objet Connection utilisé pour interagir avec la base de données.
     */
    public DAOPersonnelImpl(Connection connection) {
        this.connection = connection;
       
        
    }

    /**
     * Insère un objet Personnel dans la base de données.
     *
     * @param personnel L'objet Personnel à insérer.
     * @return true si l'insertion a réussi, false sinon.
     */
    @Override
    public boolean insertPersonnel(Personnel personnel) {
        String sql = "INSERT INTO personnel (last_name, first_name, affectation, metier, specialite, rang) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, personnel.getLastName());
            pstmt.setString(2, personnel.getFirstName());
            pstmt.setString(3, personnel.getAffectation());
            pstmt.setString(4, personnel.getMetier());
            pstmt.setString(5, (personnel instanceof PersonnelMedical) ? ((PersonnelMedical) personnel).getSpecialite() : null);
            pstmt.setString(6, (personnel instanceof PersonnelMilitaire) ? ((PersonnelMilitaire) personnel).getRang() : null);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            log.error("Error inserting personnel: " + e.getMessage());
            return false;
        }
    }

    /**
     * Met à jour un objet Personnel dans la base de données.
     *
     * @param personnel L'objet Personnel à mettre à jour.
     * @return true si la mise à jour a réussi, false sinon.
     */
    @Override
    public boolean updatePersonnel(Personnel personnel) {
        String sql = "UPDATE personnel SET last_name = ?, first_name = ?, affectation = ?, metier = ?, specialite = ?, rang = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, personnel.getLastName());
            pstmt.setString(2, personnel.getFirstName());
            pstmt.setString(3, personnel.getAffectation());
            pstmt.setString(4, personnel.getMetier());
            pstmt.setString(5, (personnel instanceof PersonnelMedical) ? ((PersonnelMedical) personnel).getSpecialite() : null);
            pstmt.setString(6, (personnel instanceof PersonnelMilitaire) ? ((PersonnelMilitaire) personnel).getRang() : null);
            pstmt.setInt(7, personnel.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            log.error("Error updating personnel: " + e.getMessage());
            return false;
        }
    }

    /**
     * Recherche un objet Personnel dans la base de données en utilisant son identifiant.
     *
     * @param id L'identifiant de l'objet Personnel à rechercher.
     * @return L'objet Personnel correspondant à l'identifiant, ou null si aucun objet n'est trouvé.
     */
    @Override
    public Personnel findPersonnelById(int id) {
        String sql = "SELECT * FROM personnel WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String metier = rs.getString("metier");
                    Personnel personnel;
                    if ("Médecin".equals(metier)) {
                        personnel = new PersonnelMedical(rs.getString("last_name"), rs.getString("first_name"), rs.getString("affectation"));
                    } else  { // cas où le métier est "Militaire" pour couvrir tous les cas et eviter un null pointer exception
                        personnel = new PersonnelMilitaire(rs.getString("last_name"), rs.getString("first_name"), rs.getString("affectation"));
                    } 
                    personnel.setId(rs.getInt("id"));
                    return personnel;
                }
            }
        } catch (SQLException e) {
            log.error("Error finding personnel by ID: " + e.getMessage());
        }
        return null;
    }

    /**
     * Récupère tous les objets Personnel de la base de données.
     *
     * @return Une liste d'objets Personnel.
     */
    @Override
    public ArrayList<Personnel> findAllPersonnel() {
        ArrayList<Personnel> personnelList = new ArrayList<>();
        String sql = "SELECT * FROM personnel";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String metier = rs.getString("metier");
                Personnel personnel;
                if ("Médecin".equals(metier)) {
                    personnel = new PersonnelMedical(rs.getString("last_name"), rs.getString("first_name"), rs.getString("affectation"));
                } else { // ("Militaire".equals(metier)) idem que pour le cas précédent
                    personnel = new PersonnelMilitaire(rs.getString("last_name"), rs.getString("first_name"), rs.getString("affectation"));
                } 
                personnel.setId(rs.getInt("id"));
                personnelList.add(personnel);
            }
        } catch (SQLException e) {
            log.error("Error finding all personnel: " + e.getMessage());
        }
        return personnelList;
    }

    /**
     * Récupère tous les objets PersonnelMedical de la base de données.
     *
     * @return Une liste d'objets PersonnelMedical.
     */
    @Override
    public PersonnelMedical[] findAllPersonnelMedical() {
        PersonnelMedical[] personnelList = null;
        String sql = "SELECT * FROM personnel WHERE metier = 'Médecin'";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ArrayList<PersonnelMedical> tempList = new ArrayList<>();
            while (rs.next()) {
            PersonnelMedical personnel = new PersonnelMedical(rs.getString("last_name"), rs.getString("first_name"), rs.getString("affectation"));
            personnel.setId(rs.getInt("id"));
            personnel.setSpecialite(rs.getString("specialite"));
            tempList.add(personnel);
            }
            personnelList = tempList.toArray(new PersonnelMedical[tempList.size()]);
        } catch (SQLException e) {
            log.error("Error finding all personnel: " + e.getMessage());
        }
        return personnelList;
    }

    /**
     * Supprime un objet Personnel de la base de données en utilisant son identifiant.
     *
     * @param id L'identifiant de l'objet Personnel à supprimer.
     * @return true si la suppression a réussi, false sinon.
     */
    @Override
    public boolean deletePersonnel(int id) {
        String sql = "DELETE FROM personnel WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            log.error("Error deleting personnel: " + e.getMessage());
            return false;
        }
    }
}
