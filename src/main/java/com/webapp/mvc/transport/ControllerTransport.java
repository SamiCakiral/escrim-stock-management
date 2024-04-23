package com.webapp.mvc.transport;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transport")
public class ControllerTransport {
    private static final Logger log = Logger.getLogger(ControllerTransport.class);

    @GetMapping
    public String transport(Model model) {
        // Vous pouvez ajouter des attributs au modèle si nécessaire
        // model.addAttribute("message", "Bienvenue sur notre site !");
        return "transport/transport";  // Nom de la vue à renvoyer
    }
}
