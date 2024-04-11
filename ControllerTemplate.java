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
€ Changer le lien €
@RequestMapping("/personnel")
public class ControllerPersonnel {

    private static final Logger log = Logger.getLogger(ControllerPersonnel.class);

    private final Application app = Application.getInstance();

    € Pour faire le mapping de la méthode GET, modifier listPersonnel pour faire ce que vous voulez avec l'instance de la classe que vous voulez €
    @GetMapping
    public String listPersonnel(Model model) {
        // Ajouter la liste du personnel au modèle
        model.addAttribute("personnelList", app.getPersonnelList());
        € Changer le lien pour la view dans le dossier view. Ici c'est la page JSP personnelList.jsp dans le package personne €
        return "personne/personnelList";
    }

    € Pour faire le mapping de la méthode POST, modifier handlePostRequest pour faire ce que vous voulez avec l'instance de la classe que vous voulez €
    @PostMapping
    public String handlePostRequest(@RequestParam(name = "action", required = false) String action,
            HttpServletRequest request) {
        if (action != null) {
            log.info("Action " + action);
            // Appeler la méthode action appropriée basée sur la valeur de 'action'
            action(request);
        }
        // Rediriger vers la liste du personnel après traitement de l'action
        €Changer la redirection pour le personnel /!\ ici on redirige pour le lien et pas le jsp /!\ €
        return "redirect:/personnel";
    }

    private void action(HttpServletRequest request) {
        € Modifier la logique de l'action ici €
        // Implémentez la logique d'action ici
        if ("addPersonnel".equals(request.getParameter("action"))) {
            addPersonnel(request);
        } else {
            log.error("Action inconnue");
        }
        // Ajoutez d'autres actions ici
    }

    € Modifier la logique de l'action ici €
    private void addPersonnel(HttpServletRequest request) {
        String name = request.getParameter("nom");
        String titre = request.getParameter("titre");
        String metier = request.getParameter("metier");
        String affectation = request.getParameter("affectation");
        

        log.debug("Adding personnel " + name + " " + titre + " " + metier + " " + affectation);
        if (metier.equals("medical")) {
            app.addMedecin(name, titre, affectation);
        } else if (metier.equals("militaire")) {
            app.addMilitaire(name, titre,affectation); // Pour militiare Rang = departement
        } else {
            log.error("Metier inconnu lors de l'ajout de personnel");
        }
    }

    € On peut faire le mapping de la méthode GET pour afficher les détails d'une instance pour l'id  €
    @GetMapping("/{id}")
    public String showPersonnelDetails(@PathVariable("id") int id, Model model) {
        // Obtenez l'objet Personnel correspondant à l'ID spécifié
        Personnel personnel = app.getPersonnelById(id);

        // Ajoutez l'objet Personnel au modèle
        model.addAttribute("personnel", personnel);

        return "personne/personnel";
    }
}
