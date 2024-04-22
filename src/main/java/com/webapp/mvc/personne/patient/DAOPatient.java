package com.webapp.mvc.personne.patient;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface DAOPatient {
    boolean insertPatient(Patient patient);
    boolean updatePatient(Patient patient);
    Patient findPatientById(int id);
    ArrayList<Patient> findAllPatients();
    boolean deletePatient(int id);
}

