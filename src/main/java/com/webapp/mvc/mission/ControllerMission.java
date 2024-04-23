package com.webapp.mvc.mission;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mission")
public class ControllerMission {
    private static final Logger log = Logger.getLogger(ControllerMission.class);

    @GetMapping
    public String mission(Model model) {
        // Vous pouvez ajouter des attributs au modèle si nécessaire
        // model.addAttribute("message", "Bienvenue sur notre site !");
        return "mission/mission";  // Nom de la vue à renvoyer
    }
}
