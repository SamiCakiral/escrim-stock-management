package com.webapp.mvc.accueil;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ControllerAccueil {
    private static final Logger log = Logger.getLogger(ControllerAccueil.class);

    @GetMapping
    public String home(Model model) {
        // Vous pouvez ajouter des attributs au modèle si nécessaire
        // model.addAttribute("message", "Bienvenue sur notre site !");
        return "accueil/home";  // Nom de la vue à renvoyer
    }
}
