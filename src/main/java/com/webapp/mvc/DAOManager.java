package com.webapp.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.webapp.mvc.materiel.DAOMateriel;
import com.webapp.mvc.mission.DAOMission;
import com.webapp.mvc.personne.patient.DAOPatient;
import com.webapp.mvc.personne.personnel.DAOPersonnel;
import com.webapp.mvc.stock.DAOStock;
import com.webapp.mvc.materiel.DAOMaterielImpl;
import com.webapp.mvc.mission.DAOMissionImpl;
import com.webapp.mvc.personne.patient.DAOPatientImpl;
import com.webapp.mvc.personne.personnel.DAOPersonnelImpl;

import com.webapp.mvc.stock.DAOStockImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.SQLException;

public class DAOManager {
    private Connection connection;
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("DBProject");

    // Instances de DAO
    private static DAOMateriel daoMateriel;
    private static DAOMission daoMission;
    private static DAOPersonnel daoPersonne;
    private static DAOStock daoStock;
    private static DAOPatient daoPatient;

    private static DAOManager instance;

    private DAOManager() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            log.error("SQLite JDBC driver not found: " + e.getMessage());
            return;
        }
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:/D:/Prive/Code/escrim-stock-management/database.db");
            createDatabase();
            log.info("Opened database successfully");
        } catch (Exception e) {
            log.error("Sqlite error: " + e.getMessage());
        }
    }

    /**
     * Récupère l'instance unique de DAOManager.
     * 
     * @return L'instance unique de DAOManager.
     */
    public static DAOManager getInstance() {
        if (instance == null) {
            instance = new DAOManager();
        }
        return instance;
    }

    /**
     * Fournit l'instance de DAOMateriel.
     * 
     * @return instance de DAOMateriel
     */
    public DAOMateriel getDAOMateriel() {
        if (daoMateriel == null) {
            daoMateriel = new DAOMaterielImpl(connection);
        }
        return daoMateriel;
    }

    /**
     * Fournit l'instance de DAOPatient.
     * @return instance de DAOPatient
     */
    public DAOPatient getDAOPatient() {
        if (daoPatient == null) {
            daoPatient = new DAOPatientImpl(connection);
        }
        return daoPatient;
    }

    /**
     * Fournit l'instance de DAOMission.
     * 
     * @return instance de DAOMission
     */
    public DAOMission getDAOMission() {
        if (daoMission == null) {
            daoMission = new DAOMissionImpl(connection);
        }
        return daoMission;
    }

    /**
     * Fournit l'instance de DAOPersonnel.
     * 
     * @return instance de DAOPersonnel
     */
    public DAOPersonnel getDAOPersonnel() {
        if (daoPersonne == null) {
            daoPersonne = new DAOPersonnelImpl(connection);
        }
        return daoPersonne;
    }

    /**
     * Fournit l'instance de DAOStock.
     * 
     * @return instance de DAOStock
     */
    public DAOStock getDAOStock() {
        if (daoStock == null) {
            daoStock = new DAOStockImpl(connection);
        }
        return daoStock;
    }

    /**
     * Crée les tables dans la base de données si elles n'existent pas déjà.
     */
    private void createDatabase() {
        try (Statement stmt = connection.createStatement()) {
            // Création de la table personnel
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS personnel (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "last_name TEXT, " +
                            "first_name TEXT, " +
                            "affectation TEXT, " +
                            "metier TEXT, " +
                            "specialite TEXT, " +
                            "rang TEXT)");

            // Création de la table patients
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS patients (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "nom TEXT, " +
                            "prenom TEXT, " +
                            "dob DATE, " +
                            "etat_urgence BOOLEAN, " +
                            "medecin_attitre_id INTEGER, " +
                            "FOREIGN KEY(medecin_attitre_id) REFERENCES personnel(id))");

            // Création de la table missions
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS missions (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "type_mission TEXT, " +
                            "description TEXT, " +
                            "lieu TEXT, " +
                            "date_debut DATE, " +
                            "date_fin DATE, " +
                            "mission_en_cours BOOLEAN)");

            // Création de la table materiel_medical
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS materiel_medical (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "nom TEXT, " +
                            "quantite_en_stock INTEGER, " +
                            "description TEXT, " +
                            "fournisseur TEXT, " +
                            "poids DOUBLE, " +
                            "date_expiration DATE, " +
                            "type TEXT, " + // 'medicament' or 'equipement'
                            "indications TEXT, " +
                            "contre_indications TEXT, " +
                            "maintenance_schedule TEXT, " +
                            "operational_status TEXT)");

            // Création de la table coli
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS coli (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "nom TEXT, " +
                            "type TEXT, " +
                            "poids DOUBLE, " +
                            "dimensions TEXT)");

            // Création de table matériel_coli pour gérer la relation de plusieurs à
            // plusieurs
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS materiel_coli (" +
                            "coli_id INTEGER, " +
                            "materiel_id INTEGER, " +
                            "FOREIGN KEY(coli_id) REFERENCES coli(id), " +
                            "FOREIGN KEY(materiel_id) REFERENCES materiel_medical(id))");

            log.info("Database tables created successfully");
        } catch (SQLException e) {
            log.error("Error creating database tables: " + e.getMessage());
        }
    }

}
