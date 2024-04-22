package com.webapp.mvc.personne.personnel;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DAOPersonnelImpl implements DAOPersonnel {
    private Connection connection;
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("DAOPersonnelImpl");

    public DAOPersonnelImpl(Connection connection) {
        this.connection = connection;
    }

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
