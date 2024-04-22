package com.webapp.mvc.mission;

/**
 * Cette classe représente une mission.
 * 
 * @author CS
 */
public class mission {
    private String typeMission;
    private String description;
    private String lieu;
    private String dateDebut;
    private String dateFin;
    private boolean missionEnCours;
    private static int idCounter = 0;
    private int id;
    private EquipeSauvetage equipeSauvetageAtitre;

    /**
     * Constructeur de la classe mission.
     * 
     * @param typeMission              Le type de la mission.
     * @param description              La description de la mission.
     * @param lieu                     Le lieu de la mission.
     * @param dateDebut                La date de début de la mission.
     * @param dateFin                  La date de fin de la mission.
     * @param missionEnCours           Indique si la mission est en cours.
     * @param equipeSauvetageAtitre    L'équipe de sauvetage attribuée à la mission.
     */
    public mission(String typeMission, String description, String lieu, String dateDebut, String dateFin,
            boolean missionEnCours, EquipeSauvetage equipeSauvetageAtitre) {
        this.id = idCounter++;
        this.typeMission = typeMission;
        this.description = description;
        this.lieu = lieu;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.missionEnCours = missionEnCours;
        this.equipeSauvetageAtitre = equipeSauvetageAtitre;
    }

    /**
     * Démarre la mission en mettant la variable missionEnCours à true.
     */
    public void demarrerMission() {
        this.missionEnCours = true;
    }

    /**
     * Termine la mission en mettant la variable missionEnCours à false.
     */
    public void terminerMission() {
        this.missionEnCours = false;
    }

    /**
     * Attribue une équipe de sauvetage à la mission.
     * 
     * @param equipe    L'équipe de sauvetage à attribuer.
     */
    public void attribuerEquipe(EquipeSauvetage equipe) {
        this.equipeSauvetageAtitre = equipe;
    }

    /**
     * Retourne l'équipe de sauvetage attribuée à la mission.
     * 
     * @return L'équipe de sauvetage attribuée à la mission.
     */
    public EquipeSauvetage getEquipeSauvetageAtitre() {
        return equipeSauvetageAtitre;
    }

    /**
     * Retourne le type de la mission.
     * 
     * @return Le type de la mission.
     */
    public String getTypeMission() {
        return typeMission;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de la mission.
     * 
     * @return Une représentation de la mission.
     */
    public String toString() {
        return "Mission: " + typeMission + " - " + description + " - " + lieu + " - " + dateDebut + " - " + dateFin + " - " + missionEnCours + " - " + id + " - " + equipeSauvetageAtitre;
    }

    /**
     * Modifie le type de la mission.
     * 
     * @param typeMission    Le nouveau type de la mission.
     */
    public void setTypeMission(String typeMission) {
        this.typeMission = typeMission;
    }

    /**
     * Retourne la description de la mission.
     * 
     * @return La description de la mission.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifie la description de la mission.
     * 
     * @param description    La nouvelle description de la mission.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne le lieu de la mission.
     * 
     * @return Le lieu de la mission.
     */
    public String getLieu() {
        return lieu;
    }

    /**
     * Modifie le lieu de la mission.
     * 
     * @param lieu    Le nouveau lieu de la mission.
     */
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    /**
     * Retourne la date de début de la mission.
     * 
     * @return La date de début de la mission.
     */
    public String getDateDebut() {
        return dateDebut;
    }

    /**
     * Modifie la date de début de la mission.
     * 
     * @param dateDebut    La nouvelle date de début de la mission.
     */
    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Retourne la date de fin de la mission.
     * 
     * @return La date de fin de la mission.
     */
    public String getDateFin() {
        return dateFin;
    }

    /**
     * Modifie la date de fin de la mission.
     * 
     * @param dateFin    La nouvelle date de fin de la mission.
     */
    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Indique si la mission est en cours.
     * 
     * @return true si la mission est en cours, false sinon.
     */
    public boolean isMissionEnCours() {
        return missionEnCours;
    }

    /**
     * Modifie l'état de la mission (en cours ou non).
     * 
     * @param missionEnCours    true si la mission est en cours, false sinon.
     */
    public void setMissionEnCours(boolean missionEnCours) {
        this.missionEnCours = missionEnCours;
    }

    /**
     * Retourne l'identifiant de la mission.
     * 
     * @return L'identifiant de la mission.
     */
    public int getId() {
        return id;
    }
}
