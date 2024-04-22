package com.webapp.mvc.stock;
import java.util.List;

public interface DAOStock {
    boolean insertColi(Coli coli);
    boolean updateColi(Coli coli);
    Coli findColiById(int id);
    List<Coli> findAllColis();
    boolean deleteColi(int id);
}

