package com.webapp.mvc.model;

public class Application {
    private static Application instance;

    private Application() {
        
    }

    public static Application getInstance() {
        if (instance == null) {
            synchronized (Application.class) {
                if (instance == null) {
                    instance = new Application();
                }
            }
        }
        return instance;
    }
}
