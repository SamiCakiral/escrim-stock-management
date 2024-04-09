package com.webapp.mvc.materiel;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.webapp.mvc.materiel.MaterielMedical;

import com.webapp.mvc.Application;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/materiel")
public class ControllerMateriel {

    private static final Logger log = Logger.getLogger(ControllerMateriel.class);

    private final Application app = Application.getInstance();

    @GetMapping
    public String listMateriel(Model model) {
        model.addAttribute("materielList", app.getMaterielList());
        return "materiel/materielList";
    }

    @PostMapping
    public String handlePostRequest(@RequestParam(name = "action", required = false) String action,
                                    HttpServletRequest request) {
        if (action != null) {
            log.info("Action " + action);
            action(request);
        }
        return "redirect:/materiel";
    }

    private void action(HttpServletRequest request) {
        // La logique d'action spécifique au matériel, par exemple, ajouter un matériel
    }

    @GetMapping("/{id}")
    public String showMaterielDetails(@PathVariable("id") int id, Model model) {
        MaterielMedical materiel = app.getMaterielById(id);
        model.addAttribute("materiel", materiel);
        return "materiel/materiel";
    }
}
