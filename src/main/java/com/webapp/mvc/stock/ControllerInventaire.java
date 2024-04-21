package com.webapp.mvc.stock;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.webapp.mvc.Application;
import com.webapp.mvc.DAOManager;
import com.webapp.mvc.materiel.*;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import org.springframework.web.bind.annotation.PathVariable;

import com.webapp.mvc.materiel.MaterielMedical; 
import java.util.ArrayList;




import com.webapp.mvc.Application;


import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/inventaire")
public class ControllerInventaire {

    private static final Logger log = Logger.getLogger(ControllerInventaire.class);
    private final Application app = Application.getInstance();
    private ArrayList<Coli> coliList;

    @GetMapping
    public String showInventaire(Model model) {
        // Add the inventory list to the model
        model.addAttribute("inventaireList", app.getMaterielList());
        return "materiel/materielList";
    }

    @PostMapping
    public String handlePostRequest(@RequestParam(name = "action", required = false) String action,
            HttpServletRequest request) {
        if (action != null) {
            log.info("Action " + action);
            // Call the appropriate action method based on the value of 'action'
            action(request);
        }
        // Redirect to the inventory list after action processing
        return "redirect:/inventaire";
    }

    private void action(HttpServletRequest request) {
        // Implement action logic here
        if ("addMateriel".equals(request.getParameter("action"))) {
            addItemToInventory(request);
        } else {
            log.error("Unknown action");
        }
        // Add other actions here
    }

    private void addItemToInventory(HttpServletRequest request) {
        // Retrieve parameters from request
        String nom = request.getParameter("nom");
        int quantiteEnStock = Integer.parseInt(request.getParameter("quantiteEnStock"));
        String description = request.getParameter("description");
        String fournisseur = request.getParameter("fournisseur");
        String Coli = request.getParameter("Colis"); 

        String dateExpirationStr = request.getParameter("dateExpiration");
        String Types = request.getParameter("Types");
        // String Coli = "hello";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date dateExpiration;
        
        if (dateExpirationStr != null && !dateExpirationStr.isEmpty()) {
            try {
                dateExpiration = dateFormat.parse(dateExpirationStr);
            } catch (ParseException e) {
                e.printStackTrace(); // Handle parsing exception
                // Set a default value or handle the error as appropriate
                dateExpiration = new Date(); // Set a default date
            }
        } else {
            // Handle case where dateExpirationStr is null or empty
            dateExpiration = new Date();
        }

        if(Types.equals("equipement")){
            app.addEquipement(nom, quantiteEnStock, description, fournisseur, dateExpiration, Coli);
        }else if(Types.equals("medicament")){
            app.addMedicament(nom, quantiteEnStock, description, fournisseur, dateExpiration, Coli);
        }else{
            log.error("Types incconu lors de l'ajout de materiel");
        }

        log.debug("Adding medicament " + nom + " " + quantiteEnStock + " " + description + " " + fournisseur);

        // Add item to inventory using Application instance
        // app.addMateriel(medicament);

        // check the name of the coli 
        coliList = app.getColiList();


        for(Coli coli : coliList){
            if(coli.getNom().equals(Coli)){

                if(Types.equals("equipement")){
                    coli.addEquipement(nom, quantiteEnStock, description, fournisseur, dateExpiration, Coli);
                }else if(Types.equals("medicament")){
                    coli.addMedicament(nom, quantiteEnStock, description, fournisseur, dateExpiration, Coli);
                }else{
                    log.error("Types incconu lors de l'ajout de materiel");
                }
            }
        }
    }
    @GetMapping("/coli")
    public String showColi(Model model) {
        model.addAttribute("inventaireList", app.getColiList()); 

        return "stock/coliList"; 
    }

    @PostMapping("/coli")
    public String handleColiFormSubmission(@RequestParam(name = "nom") String nom) {
        app.addColi(nom); // Assuming app is an instance of your Application class
        return "redirect:/inventaire/coli"; // Redirect to the inventory page after adding the Coli
    }

    @GetMapping("/inventaire/coli/{id}")
    public String listeMateriel(@PathVariable("id") int id, Model model) {

        Coli coli = app.getColiById(id); 

        model.addAttribute("coli", coli);

        return "stock/listeMateriel";
    }

    // @GetMapping
    // public String showInventaire(Model model) {
    //     // Add the inventory list to the model
    //     model.addAttribute("inventaireList", app.getMaterielList());
    //     return "materiel/materielList";
    // }

    // @GetMapping("/coli/{id}")
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }

    // @GetMapping("/materiel")
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }
}

// public class ControllerInventaire extends HttpServlet {

//     private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("ControlerMain"); // Initialisation
//                                                                                                            // du Logger
 
//     /**
//      * Gère les requêtes HTTP GET.
//      *
//      * @param request  l'objet HttpServletRequest qui contient les informations de la requête
//      * @param response l'objet HttpServletResponse qui contient les informations de la réponse
//      * @throws ServletException si le servlet rencontre des difficultés
//      * @throws IOException      si une erreur d'E/S se produit
//      */
//     protected void doGet(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {

//         RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/inventaire.jsp");
//         dispatcher.forward(request, response);

//     }

//     /**
//      * Gère les requêtes HTTP POST.
//      *
//      * @param request  l'objet HttpServletRequest qui contient les informations de la requête
//      * @param response l'objet HttpServletResponse qui contient les informations de la réponse
//      * @throws ServletException si le servlet rencontre des difficultés
//      * @throws IOException      si une erreur d'E/S se produit
//      */
//     protected void doPost(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {
//         String actionString = request.getParameter("action");
//         log.info("Action " + actionString);
//         if (actionString != null) {
//             action(request, response, actionString);
//             doGet(request, response);
//         } else {
//             doGet(request, response);
//         }

//     }

//     /**
//      * Effectue une action en fonction de la chaîne d'action donnée.
//      *
//      * @param request       l'objet HttpServletRequest qui contient les informations de la requête
//      * @param response      l'objet HttpServletResponse qui contient les informations de la réponse
//      * @param actionString  la chaîne d'action spécifiée
//      */
//     private void action(HttpServletRequest request, HttpServletResponse response, String actionString) {
//         DAOManager dao = DAOManager.getInstance(); // dao setup mais pas utilisé
//         Application app = Application.getInstance();

//         if (actionString.equals("")) {

//         }
//         return ;

        
//     }
// }
 
