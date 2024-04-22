package com.webapp.mvc.personne.patient;

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
import com.webapp.mvc.materiel.Traitement;
import com.webapp.mvc.materiel.Equipement;
import com.webapp.mvc.personne.personnel.PersonnelMedical;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

/**
 * Contrôleur pour la gestion des patients.
 * 
 * @author CS
 */
@Controller
@RequestMapping("/patient")
public class ControllerPatient {

    private static final Logger log = Logger.getLogger(ControllerPatient.class);

    private final Application app = Application.getInstance();

    /**
     * Affiche la liste des patients.
     * 
     * @param model le modèle utilisé pour transmettre les données à la vue
     * @return le nom de la vue à afficher
     */
    @GetMapping
    public String listPatients(Model model) {
        model.addAttribute("patientList", app.getPatientList());
        return "personne/patientList";
    }

    /**
     * Gère les requêtes POST.
     * 
     * @param action   l'action à effectuer
     * @param request  la requête HTTP
     * @return le nom de la vue à afficher après le traitement de la requête
     */
    @PostMapping
    public String handlePostRequest(@RequestParam(name = "action", required = false) String action,
                                    HttpServletRequest request) {
        if (action != null) {
            log.info("Action " + action);
            action(request);
        }
        return "redirect:/patient";
    }

    /**
     * Effectue une action spécifique aux patients.
     * 
     * @param request la requête HTTP
     */
    private void action(HttpServletRequest request) {
        if ("addPatient".equals(request.getParameter("action"))) {
            addPatient(request);
        } else {
            log.error("Unknown action");
        }
    }

    /**
     * Ajoute un patient.
     * 
     * @param request la requête HTTP
     */
    private void addPatient(HttpServletRequest request) {
        // Récupérer les paramètres de la requête
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String dobStr = request.getParameter("dob");
        String[] traitementsIds = request.getParameterValues("traitements");
        String[] equipementsIds = request.getParameterValues("equipements");
        String medecinAttitreId = request.getParameter("medecinAttitre");
        boolean etatUrgence = "on".equals(request.getParameter("etatUrgence"));

        // getTraitementById et getEquipementById pour récupérer les objets correspondants
        // getPersonnelMedicalById pour récupérer le médecin attitré
        // Unimplemented methods...
        // Traitement [] Traitement = app.getTraitementById(id);
        //  app.getEquipementById(id);
        Traitement[] traitements = new Traitement[traitementsIds.length];
        for (int i = 0; i < traitementsIds.length; i++) {
            traitements[i] = app.getTraitementById(Integer.parseInt(traitementsIds[i]));
        }

        Equipement[] equipements = new Equipement[equipementsIds.length];
        for (int i = 0; i < equipementsIds.length; i++) {
            equipements[i] = app.getEquipementById(Integer.parseInt(equipementsIds[i]));
        }

        PersonnelMedical medecinAttitre = app.getPersonnelMedicalById(Integer.parseInt(medecinAttitreId));
        // app.getPersonnelMedicalById(id);
        
        Date dob = new Date();
        try {
            dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobStr);
        } catch (ParseException e) {
            log.error("Error parsing date of birth", e);
        }
        app.addPatient( nom, traitements, equipements, medecinAttitre, etatUrgence, prenom, dob);
    }

    /**
     * Affiche les détails d'un patient.
     * 
     * @param id     l'identifiant du patient
     * @param model  le modèle utilisé pour transmettre les données à la vue
     * @return le nom de la vue à afficher
     */
    @GetMapping("/{id}")
    public String showPatientDetails(@PathVariable("id") int id, Model model) {
        Patient patient = app.getPatientById(id);
        model.addAttribute("patient", patient);
        return "personne/patient";
    }
}
