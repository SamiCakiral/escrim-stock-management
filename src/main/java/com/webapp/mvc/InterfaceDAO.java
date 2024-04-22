package com.webapp.mvc;

public interface InterfaceDAO {
    void create(Object object);
    Object read(int id);
    void update(Object object);
    void delete(int id);
    Object getAll();
    Object getElementById(int id);
    Object getElementByName(String name); 
    Object getInstance();
}
