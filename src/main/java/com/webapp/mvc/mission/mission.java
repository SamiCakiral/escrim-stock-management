package com.webapp.mvc.mission;

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

    public void demarrerMission() {
        this.missionEnCours = true;
    }

    public void terminerMission() {
        this.missionEnCours = false;
    }

    public void attribuerEquipe(EquipeSauvetage equipe) {
        this.equipeSauvetageAtitre = equipe;
    }

    public EquipeSauvetage getEquipeSauvetageAtitre() {
        return equipeSauvetageAtitre;
    }

    public String getTypeMission() {
        return typeMission;
    }

    public String toString() {
        return "Mission: " + typeMission + " - " + description + " - " + lieu + " - " + dateDebut + " - " + dateFin + " - " + missionEnCours + " - " + id + " - " + equipeSauvetageAtitre;
    }

    public void setTypeMission(String typeMission) {
        this.typeMission = typeMission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public boolean isMissionEnCours() {
        return missionEnCours;
    }

    public void setMissionEnCours(boolean missionEnCours) {
        this.missionEnCours = missionEnCours;
    }

    public int getId() {
        return id;
    }
}
