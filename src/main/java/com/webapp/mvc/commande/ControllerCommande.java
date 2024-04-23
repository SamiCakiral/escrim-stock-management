package com.webapp.mvc.commande;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commande")
public class ControllerCommande {
    private static final Logger log = Logger.getLogger(ControllerCommande.class);

    @GetMapping
    public String commande(Model model) {
        // Vous pouvez ajouter des attributs au modèle si nécessaire
        // model.addAttribute("message", "Bienvenue sur notre site !");
        return "commande/commande";  // Nom de la vue à renvoyer
    }
}
