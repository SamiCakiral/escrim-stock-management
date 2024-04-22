package com.webapp.mvc.personne.patient;
import java.util.List;

public interface DAOPatient {
    boolean insertPatient(Patient patient);
    boolean updatePatient(Patient patient);
    Patient findPatientById(int id);
    List<Patient> findAllPatients();
    boolean deletePatient(int id);
}

