package com.webapp.mvc.personne.personnel;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.mvc.Application;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/personnel")
public class ControllerPersonnel {

    private static final Logger log = Logger.getLogger(ControllerPersonnel.class);

    private final Application app = Application.getInstance();

    @GetMapping
    public String listPersonnel(Model model) {
        // Ajouter la liste du personnel au modèle
        model.addAttribute("personnelList", app.getPersonnelList());

        return "personne/personnelList";
    }

    @PostMapping
    public String handlePostRequest(@RequestParam(name = "action", required = false) String action,
            HttpServletRequest request) {
        if (action != null) {
            log.info("Action " + action);
            // Appeler la méthode action appropriée basée sur la valeur de 'action'
            action(request);
        }
        // Rediriger vers la liste du personnel après traitement de l'action
        return "redirect:/personnel";
    }

    private void action(HttpServletRequest request) {
        // Implémentez la logique d'action ici
        if ("addPersonnel".equals(request.getParameter("action"))) {
            addPersonnel(request);
        } else {
            log.error("Action inconnue");
        }
        // Ajoutez d'autres actions ici
    }

    private void addPersonnel(HttpServletRequest request) {
        String last_name = request.getParameter("last_name");
        String first_name = request.getParameter("first_name");
        String metier = request.getParameter("metier");
        String affectation = request.getParameter("affectation");
        

        log.debug("Adding personnel " + last_name + " " + first_name + " " + metier + " " + affectation);
        if (metier.equals("medical")) {
            app.addMedecin(last_name, first_name, affectation);
        } else if (metier.equals("militaire")) {
            app.addMilitaire(last_name, first_name,affectation); // Pour militiare Rang = departement
        } else {
            log.error("Metier inconnu lors de l'ajout de personnel");
        }
    }

    @GetMapping("/{id}")
    public String showPersonnelDetails(@PathVariable("id") int id, Model model) {
        // Obtenez l'objet Personnel correspondant à l'ID spécifié
        Personnel personnel = app.getPersonnelById(id);

        // Ajoutez l'objet Personnel au modèle
        model.addAttribute("personnel", personnel);

        return "personne/personnel";
    }
}
