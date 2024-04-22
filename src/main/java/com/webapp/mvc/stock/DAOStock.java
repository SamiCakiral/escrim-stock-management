package com.webapp.mvc.stock;
import java.util.ArrayList;
import java.util.List;

public interface DAOStock {
    boolean insertColi(Coli coli);
    boolean updateColi(Coli coli);
    Coli findColiById(int id);
    ArrayList<Coli> findAllColis();
    boolean deleteColi(int id);
}

