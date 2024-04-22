package com.webapp.mvc;

import com.webapp.mvc.*;
// Personnel Imports
import com.webapp.mvc.personne.personnel.Personnel;
import com.webapp.mvc.personne.personnel.PersonnelMedical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DAOManager {
    protected static DAOManager instance;
    protected static final String URL = "jdbc:sqlite:src/main/java/com/webapp/mvc/sql/escrim_database.db"; 
    protected Connection connection;

    protected DAOManager(){
		connect();    		
    }
    
    protected void connect(){
        try {
			connection = DriverManager.getConnection(URL);
			if (connection == null) {
			    // Connection failed
			    System.err.println("Failed to connect to the database.");
			} else {
			    // Connection successful
			    System.out.println("Connected to the database successfully.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // All SQL methods for Personnel List
    public List<PersonnelMedical> getPersonnelMedical() {
        String sql = "SELECT * FROM PERSONNEL";
        List<PersonnelMedical> personnelsMedical = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                PersonnelMedical personnelMedical = new PersonnelMedical(
                    rs.getString("last_name"),
                    rs.getString("first_name"),
                    rs.getString("affectation")
                );
                // Vous pouvez également ajouter des setters pour les autres attributs si nécessaire
                personnelMedical.setMetier(rs.getString("metier")); // Si vous voulez le métier spécifique
                personnelMedical.setPhoto(rs.getString("photo"));   // Pour ajouter une photo
                personnelsMedical.add(personnelMedical);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnelsMedical;
    }

    // On met pas idCounter car ce n'est pas un attribut de Personnel
    public void addPersonnelMedical(PersonnelMedical personnel) {
        String sql = "INSERT INTO PERSONNEL (id, last_name, first_name, affectation, metier, photo, specialite) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, personnel.getId());
            pstmt.setString(2, personnel.getLast_name());
            pstmt.setString(3, personnel.getFirst_name());
            pstmt.setString(4, personnel.getAffectation());
            pstmt.setString(5, personnel.getMetier()); // Assurez-vous que 'metier' est toujours 'Médecin' dans le constructeur ou la logique d'application
            pstmt.setString(6, personnel.getPhoto()); // Assurez-vous que la photo est bien gérée dans l'objet
            pstmt.setString(7, personnel.getSpecialite()); // Assurez-vous que la spécialité est bien gérée dans l'objet
    
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating personnel failed, no rows affected.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }    

    // SQL method to exit connection
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static DAOManager getInstance() {
    	if(instance==null) {
    		instance =new DAOManager();
    	}
    	return instance;
    }
}