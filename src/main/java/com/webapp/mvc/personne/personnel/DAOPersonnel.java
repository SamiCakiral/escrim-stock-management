package com.webapp.mvc.personne.personnel;
import java.util.ArrayList;
import java.util.List;

public interface DAOPersonnel {
    boolean insertPersonnel(Personnel personnel);
    boolean updatePersonnel(Personnel personnel);
    Personnel findPersonnelById(int id);
    ArrayList<Personnel> findAllPersonnel();
    boolean deletePersonnel(int id);
    PersonnelMedical[] findAllPersonnelMedical();
}
