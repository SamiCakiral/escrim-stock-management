<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.webapp.mvc.stock.Coli" %>
            <%@ page import="com.webapp.mvc.DAOManager" %>
                <%@ page import="com.webapp.mvc.stock.*" %>
                    <%@ page import="com.webapp.mvc.materiel.*" %>
                        <%@ page import="com.webapp.mvc.materiel.DAOMaterielImpl" %>
                            <%@ page import="com.webapp.mvc.materiel.DAOMateriel" %>

                                <!DOCTYPE html>
                                <html>

                                <head>
                                    <meta charset="UTF-8">
                                    <title>Inventory Page</title>
                                </head>

                                <body>
                                    <h1>Inventory Page pour le Colis</h1>

                                    <h2>Details du Colis</h2>
                                    <p>ID: ${coli.getId()}</p>
                                    <p>Materiels a l'interieur (A remplir): </p>
                                    <table>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nom</th>
                                            <th>Description</th>
                                        </tr>
                                        

                                    </table>


                                </body>

                                </html>