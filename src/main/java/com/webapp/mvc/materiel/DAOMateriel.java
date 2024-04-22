package com.webapp.mvc.materiel;

import java.util.ArrayList;
import java.util.List;

public interface DAOMateriel {
    boolean insertMateriel(MaterielMedical materiel);
    boolean updateMateriel(MaterielMedical materiel);
    MaterielMedical findMaterielById(int id);
    ArrayList<MaterielMedical> findAllMateriel();
    boolean deleteMateriel(int id);
}

