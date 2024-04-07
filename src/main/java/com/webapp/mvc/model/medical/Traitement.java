package com.webapp.mvc.model.medical;

public class Traitement {
    private int id;
    private String description;
    private Medicament médicament;
    private String fréquence;
    private String dose;


    public Traitement(int id, String description, Medicament médicament, String fréquence, String dose) {
        this.id = id;
        this.description = description;
        this.médicament = médicament;
        this.fréquence = fréquence;
        this.dose = dose;
    }
    
    public void prescrireMédicament(Medicament médicament) {
        // TODO: Implement prescrireMédicament method
    }

    public void planifierTraitement() {
        // TODO: Implement planifierTraitement method
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Medicament getMedicament() {
        return médicament;
    }

    public void setMédicament(Medicament médicament) {
        this.médicament = médicament;
    }

    public String getFréquence() {
        return fréquence;
    }

    public void setFrequence(String fréquence) {
        this.fréquence = fréquence;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }
}
