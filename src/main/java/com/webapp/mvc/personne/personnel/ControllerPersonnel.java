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
import com.webapp.mvc.DAOManager;
import java.util.List;
/**
 * Contrôleur pour la gestion du personnel.
 * Cette classe gère les requêtes liées au personnel et les redirige vers les méthodes appropriées.
 * Elle contient des méthodes pour afficher la liste du personnel, gérer les actions POST et afficher les détails d'un personnel spécifique.
 *
 * @author CS
 */
@Controller
@RequestMapping("/personnel")
public class ControllerPersonnel {

    private static final Logger log = Logger.getLogger(ControllerPersonnel.class);

    private final Application app = Application.getInstance();
    private DAOPersonnel daoPersonnel;

    public ControllerPersonnel() {
        this.daoPersonnel = DAOManager.getInstance().getDAOPersonnel();
    }
    /**
     * Affiche la liste du personnel.
     * Ajoute la liste du personnel au modèle et renvoie la vue "personne/personnelList".
     *
     * @param model Le modèle utilisé pour transmettre les données à la vue.
     * @return Le nom de la vue à afficher.
     */
    @GetMapping
    public String listPersonnel(Model model) {
        // Ajouter la liste du personnel au modèle
        List<Personnel> personnelList = daoPersonnel.findAllPersonnel();
        
        model.addAttribute("personnelList", personnelList);

        return "personne/personnelList";
    }

    /**
     * Gère les requêtes POST.
     * Appelle la méthode d'action appropriée en fonction de la valeur de 'action' et redirige vers la liste du personnel après traitement de l'action.
     *
     * @param action  La valeur de 'action' provenant de la requête.
     * @param request L'objet HttpServletRequest contenant les informations de la requête.
     * @return Le nom de la vue à afficher après redirection.
     */
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

    /**
     * Méthode d'action pour traiter les actions spécifiées dans la requête.
     * Implémente la logique d'action en fonction de la valeur de 'action'.
     *
     * @param request L'objet HttpServletRequest contenant les informations de la requête.
     */
    private void action(HttpServletRequest request) {
        // Implémentez la logique d'action ici
        if ("addPersonnel".equals(request.getParameter("action"))) {
            addPersonnel(request);
        } else {
            log.error("Action inconnue");
        }
        // Ajoutez d'autres actions ici
    }

    /**
     * Ajoute un nouveau personnel.
     * Récupère les informations du personnel à partir de la requête et les utilise pour ajouter le personnel à l'application.
     *
     * @param request L'objet HttpServletRequest contenant les informations de la requête.
     */
    private void addPersonnel(HttpServletRequest request) {
        String last_name = request.getParameter("last_name");
        String first_name = request.getParameter("first_name");
        String affectation = request.getParameter("affectation");
        String metier = request.getParameter("metier");
        Personnel personnel;

        // Déterminer le type de personnel et créer l'objet approprié
        if (metier.equals("medical")) {
            app.addMedecin(last_name, first_name, affectation);
            personnel = new PersonnelMedical(last_name, first_name, affectation);
            
        } else if (metier.equals("militaire")) {
            app.addMilitaire(last_name, first_name, affectation);
            personnel = new PersonnelMilitaire(last_name, first_name, affectation);
        } else {
            log.error("Métier inconnu lors de l'ajout de personnel");
            return;
        }

        boolean isSuccess = daoPersonnel.insertPersonnel(personnel);
        if (isSuccess) {
            log.info("Personnel added successfully");
            
        } else {
            log.error("Failed to add personnel");
        }
        
    }

    /**
     * Affiche les détails d'un personnel spécifique.
     * Récupère l'objet Personnel correspondant à l'ID spécifié et l'ajoute au modèle.
     * Renvoie la vue "personne/personnel".
     *
     * @param id     L'ID du personnel.
     * @param model  Le modèle utilisé pour transmettre les données à la vue.
     * @return Le nom de la vue à afficher.
     */
    @GetMapping("/{id}")
    public String showPersonnelDetails(@PathVariable("id") int id, Model model) {
        // Obtenez l'objet Personnel correspondant à l'ID spécifié
        Personnel personnel = daoPersonnel.findPersonnelById(id);
        // Ajoutez l'objet Personnel au modèle
        model.addAttribute("personnel", personnel);

        return "personne/personnel";
    }
}
