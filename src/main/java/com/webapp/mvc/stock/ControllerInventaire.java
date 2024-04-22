package com.webapp.mvc.stock;

import com.webapp.mvc.Application;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;



import jakarta.servlet.http.HttpServletRequest;

/**
 * Cette classe est le contrôleur pour la gestion de l'inventaire.
 * Elle gère les requêtes liées à l'inventaire et effectue les actions correspondantes.
 * 
 * @author CS
 */
@Controller
@RequestMapping("/inventaire")
public class ControllerInventaire {

    /**
     * Logger pour le contrôleur de l'inventaire.
     */
    private static final Logger log = Logger.getLogger(ControllerInventaire.class);

    /**
     * Instance de l'application.
     */
    private final Application app = Application.getInstance();

    /**
     * Liste des colis.
     */
    private ArrayList<Coli> coliList;

    /**
     * Affiche l'inventaire.
     * 
     * @param model Le modèle pour la vue.
     * @return Le nom de la vue pour afficher l'inventaire.
     */
    @GetMapping
    public String showInventaire(Model model) {
        // Ajoute la liste de l'inventaire au modèle
        model.addAttribute("inventaireList", app.getMaterielList());
        return "materiel/materielList";
    }

    /**
     * Gère la requête POST.
     * 
     * @param action  L'action à effectuer.
     * @param request La requête HTTP.
     * @return Le nom de la vue pour rediriger vers l'inventaire.
     */
    @PostMapping
    public String handlePostRequest(@RequestParam(name = "action", required = false) String action,
            HttpServletRequest request) {
        if (action != null) {
            log.info("Action " + action);
            // Appelle la méthode d'action appropriée en fonction de la valeur de 'action'
            action(request);
        }
        // Redirige vers la liste de l'inventaire après le traitement de l'action
        return "redirect:/inventaire";
    }

    /**
     * Effectue l'action correspondante à la requête.
     * 
     * @param request La requête HTTP.
     */
    private void action(HttpServletRequest request) {
        // Implémente la logique de l'action ici
        if ("addMateriel".equals(request.getParameter("action"))) {
            addItemToInventory(request);
        } else {
            log.error("Action inconnue");
        }
        // Ajoutez d'autres actions ici
    }

    /**
     * Obtient l'ID du coli à partir de son nom.
     * 
     * @param ColisName Le nom du coli.
     * @return L'ID du coli, -1 si le coli n'est pas trouvé.
     */
    private int getColiIdFromName(String ColisName) {
        coliList = app.getColiList();
        for (Coli coli : coliList) {
            if (coli.getNom().equals(ColisName)) {
                return coli.getId();
            }
        }
        return -1;
    }

    /**
     * Ajoute un élément à l'inventaire.
     * 
     * @param request La requête HTTP.
     */
    private void addItemToInventory(HttpServletRequest request) {
        // Récupère les paramètres de la requête
        String nom = request.getParameter("nom");
        int quantiteEnStock = Integer.parseInt(request.getParameter("quantiteEnStock"));
        String description = request.getParameter("description");
        String fournisseur = request.getParameter("fournisseur");
        String ColisName = request.getParameter("Colis");

        int ColiId = getColiIdFromName(ColisName); // Obtient l'ID du coli à partir du nom du coli
        double poids = Double.parseDouble(request.getParameter("poids"));

        String dateExpirationStr = request.getParameter("dateExpiration");
        String Types = request.getParameter("Types");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date dateExpiration;

        if (dateExpirationStr != null && !dateExpirationStr.isEmpty()) {
            try {
                dateExpiration = dateFormat.parse(dateExpirationStr);
            } catch (ParseException e) {
                e.printStackTrace(); // Gère l'exception de parsing
                // Définir une valeur par défaut ou gérer l'erreur de manière appropriée
                dateExpiration = new Date(); // Définir une date par défaut
            }
        } else {
            // Gère le cas où dateExpirationStr est null ou vide
            dateExpiration = new Date();
        }

        if (Types.equals("equipement")) {
            app.addEquipement(nom, quantiteEnStock, description, fournisseur, dateExpiration, ColiId, poids);
        } else if (Types.equals("medicament")) {
            app.addMedicament(nom, quantiteEnStock, description, fournisseur, dateExpiration, ColiId, poids);
        } else {
            log.error("Type inconnu lors de l'ajout de matériel");
        }

        log.debug("Ajout du médicament " + nom + " " + quantiteEnStock + " " + description + " " + fournisseur);

        // Ajoute l'élément à l'inventaire en utilisant l'instance de l'application
        // app.addMateriel(medicament);

        // Vérifie le nom du coli
        coliList = app.getColiList();

        for (Coli coli : coliList) {
            if (coli.getId() == (ColiId)) {

                if (Types.equals("equipement")) {
                    coli.addEquipement(nom, quantiteEnStock, description, fournisseur, dateExpiration, ColiId, poids);
                } else if (Types.equals("medicament")) {
                    coli.addMedicament(nom, quantiteEnStock, description, fournisseur, dateExpiration, ColiId, poids);
                } else {
                    log.error("Type inconnu lors de l'ajout de matériel");
                }
            }
        }
    }

    /**
     * Affiche la liste des colis.
     * 
     * @param model Le modèle pour la vue.
     * @return Le nom de la vue pour afficher la liste des colis.
     */
    @GetMapping("/coli")
    public String showColi(Model model) {
        model.addAttribute("inventaireList", app.getColiList());

        return "stock/coliList";
    }

    /**
     * Gère la soumission du formulaire de colis.
     * 
     * @param action  L'action à effectuer.
     * @param request La requête HTTP.
     * @return Le nom de la vue pour rediriger vers la liste des colis.
     */
    @PostMapping("/coli")
    public String handleColiFormSubmission(@RequestParam(name = "action", required = false) String action,
            HttpServletRequest request) {
        if (action != null) {
            log.info("Action " + action);
            // Appelle la méthode d'action appropriée en fonction de la valeur de 'action'
            actionColi(request);
        }
        // Redirige vers la liste des colis après le traitement de l'action
        return "redirect:/inventaire/coli";
    }

    /**
     * Effectue l'action correspondante à la requête de colis.
     * 
     * @param request La requête HTTP.
     */
    private void actionColi(HttpServletRequest request) {
        // Implémente la logique de l'action ici
        if ("addColi".equals(request.getParameter("action"))) {
            addColi(request);
        } else if ("addMateriel".equals(request.getParameter("action"))) {
            addItemToInventory(request);
        } else {
            log.error("Action inconnue");
        }
        // Ajoutez d'autres actions ici
    }

    /**
     * Ajoute un colis.
     * 
     * @param request La requête HTTP.
     */
    private void addColi(HttpServletRequest request) {
        // Récupère les paramètres de la requête
        String nom = request.getParameter("nom");
        String type = request.getParameter("type");

        Integer[] materielIDs = Arrays.stream(request.getParameterValues("materielIDs"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        Coli coli = new Coli(nom, type, materielIDs);
        app.addColi(coli);
    }

    /**
     * Affiche la liste du matériel d'un coli.
     * 
     * @param id     L'ID du coli.
     * @param model  Le modèle pour la vue.
     * @return Le nom de la vue pour afficher la liste du matériel d'un coli.
     */
    @GetMapping("/inventaire/coli/{id}")
    public String listeMateriel(@PathVariable("id") int id, Model model) {

        Coli coli = app.getColiById(id);

        model.addAttribute("coli", coli);

        return "stock/coli";
    }
}
