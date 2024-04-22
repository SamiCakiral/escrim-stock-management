package com.webapp;

import com.webapp.mvc.DAOManager;

public class ApplicationTest {
    public static void main(String[] args) {
        DAOManager dao = DAOManager.getInstance();
        System.out.println(dao.getPersonnelMedical()); 
    }
}
