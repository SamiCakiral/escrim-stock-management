package com.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // Active le support de MVC pour les applications web
@ComponentScan(basePackages = "com.webapp") // Spécifie où chercher les composants Spring (@Controller, @Service, etc.)
public class AppConfig implements WebMvcConfigurer {

    // Définit le résolveur de vues pour les JSP
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/"); // Dossier où se trouvent les JSP
        viewResolver.setSuffix(".jsp"); // Extension des fichiers à utiliser comme vues
        return viewResolver;
    }

    // Vous pouvez ajouter d'autres beans et configurations ici selon vos besoins
}
