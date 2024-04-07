package com.webapp.mvc.controler.personne;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControlerPersonnel {

    @RequestMapping(value = "/personnel/{id}", method = RequestMethod.GET)
    public String getPersonne(@PathVariable("id") int id, Model model) {
        // Ajoutez l'id de la personne comme un attribut du modèle
        model.addAttribute("id", id);

        // Le nom de la vue est "personne", Spring va chercher une page JSP nommée
        // "personne.jsp"
        return "personne/personnel";
    }

    // Ajoutez d'autres méthodes pour gérer d'autres requêtes HTTP si nécessaire
}