package com.webapp.mvc.personne.patient;

import java.sql.Connection;
import java.util.ArrayList;

import com.webapp.mvc.Application;
import com.webapp.mvc.DAOManager;
import com.webapp.mvc.materiel.Equipement;
import com.webapp.mvc.materiel.Traitement;
import com.webapp.mvc.personne.personnel.PersonnelMedical;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * Implémentation du DAO pour les patients.
 * 
 * @see DAOPatient
 * @author CS
 */
public class DAOPatientImpl implements DAOPatient {
    private Connection connection;
    private final Application app = Application.getInstance();

    public DAOPatientImpl(Connection connection) {
        this.connection = connection;
        
    }

    @Override
    public boolean insertPatient(Patient patient) {
        String sql = "INSERT INTO patients (nom, prenom, dob, etat_urgence, medecin_attitre_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, patient.getNom());
            pstmt.setString(2, patient.getPrenom());
            pstmt.setDate(3, new java.sql.Date(patient.getDob().getTime()));
            pstmt.setBoolean(4, patient.isEtatUrgence());
            pstmt.setInt(5, patient.getMedecinAttitre().getId());  // Assuming medecinAttitre is never null

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePatient(Patient patient) {
        String sql = "UPDATE patients SET nom = ?, prenom = ?, dob = ?, etat_urgence = ?, medecin_attitre_id = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, patient.getNom());
            pstmt.setString(2, patient.getPrenom());
            pstmt.setDate(3, new java.sql.Date(patient.getDob().getTime()));
            pstmt.setBoolean(4, patient.isEtatUrgence());
            pstmt.setInt(5, patient.getMedecinAttitre().getId());
            pstmt.setInt(6, patient.getId());

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Patient findPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Patient(
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getDate("dob"),
                    null, // Traitement et équipements ne sont pas gérés ici
                    null,
                    app.getPersonnelMedicalById(rs.getInt("medecin_attitre_id")), // "app" is not defined here
                    rs.getBoolean("etat_urgence")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Patient> findAllPatients() {
        ArrayList<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                patients.add(new Patient(
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getDate("dob"),
                    null, // Traitement et équipements ne sont pas gérés ici
                    null,
                    (PersonnelMedical) DAOManager.getInstance().getDAOPersonnel().findPersonnelById(rs.getInt("medecin_attitre_id")), // "app" is not defined here
                    rs.getBoolean("etat_urgence")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public boolean deletePatient(int id) {
        String sql = "DELETE FROM patients WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
