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

@Controller
@RequestMapping("/patient")
public class ControllerPatient {

    private static final Logger log = Logger.getLogger(ControllerPatient.class);

    private final Application app = Application.getInstance();

    @GetMapping
    public String listPatients(Model model) {
        model.addAttribute("patientList", app.getPatientList());
        return "personne/patientList";
    }

    @PostMapping
    public String handlePostRequest(@RequestParam(name = "action", required = false) String action,
                                    HttpServletRequest request) {
        if (action != null) {
            log.info("Action " + action);
            action(request);
        }
        return "redirect:/patient";
    }

    private void action(HttpServletRequest request) {
        // La logique d'action spécifique aux patients, par exemple, ajouter un patient
    }

    @GetMapping("/{id}")
    public String showPatientDetails(@PathVariable("id") int id, Model model) {
        Patient patient = app.getPatientById(id);
        model.addAttribute("patient", patient);
        return "personne/patient";
    }
}
