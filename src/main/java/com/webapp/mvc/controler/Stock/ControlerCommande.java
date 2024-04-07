package com.webapp.mvc.controler.Stock;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.webapp.mvc.model.Application;
import com.webapp.repo.DAOManager;

public class ControlerCommande extends HttpServlet {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("ControlerMain"); // Initialisation
                                                                                                           // du Logger
 
    /**
     * Gère les requêtes HTTP GET.
     *
     * @param request  l'objet HttpServletRequest qui contient les informations de la requête
     * @param response l'objet HttpServletResponse qui contient les informations de la réponse
     * @throws ServletException si le servlet rencontre des difficultés
     * @throws IOException      si une erreur d'E/S se produit
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/commande.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * Gère les requêtes HTTP POST.
     *
     * @param request  l'objet HttpServletRequest qui contient les informations de la requête
     * @param response l'objet HttpServletResponse qui contient les informations de la réponse
     * @throws ServletException si le servlet rencontre des difficultés
     * @throws IOException      si une erreur d'E/S se produit
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String actionString = request.getParameter("action");
        log.info("Action " + actionString);
        if (actionString != null) {
            action(request, response, actionString);
            doGet(request, response);
        } else {
            doGet(request, response);
        }

    }

    /**
     * Effectue une action en fonction de la chaîne d'action donnée.
     *
     * @param request       l'objet HttpServletRequest qui contient les informations de la requête
     * @param response      l'objet HttpServletResponse qui contient les informations de la réponse
     * @param actionString  la chaîne d'action spécifiée
     */
    private void action(HttpServletRequest request, HttpServletResponse response, String actionString) {
        DAOManager dao = DAOManager.getInstance(); // dao setup mais pas utilisé
        Application app = Application.getInstance();

        if (actionString.equals("")) {

        }
        return ;

        
    }
}
 
