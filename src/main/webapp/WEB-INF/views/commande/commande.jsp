<!-- Fichier : src/main/webapp/WEB-INF/views/commande/commande.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.webapp.mvc.personne.personnel.*" %>
            <%@ page import="com.webapp.mvc.Application" %>

                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8">
                    <title>Commande</title>
                    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                    <!-- CSS Bootstrap -->
                    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
                        rel="stylesheet">

                    <!-- JS Popper.js (nécessaire pour Bootstrap) -->
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

                    <!-- JS Bootstrap -->
                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                    <link rel="stylesheet" type="text/css"
                        href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
                    <script type="text/javascript" charset="utf8"
                        src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>

                </head>

                <body>
                    <!-- Sticky Header : Menu avec Navbar Bootstrap -->
                    <nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
                        <div class="container">
                            <a class="navbar-brand" href="#">Commande</a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarNav">
                                <ul class="navbar-nav">
                                    <li class="nav-item"><a class="nav-link" href="/escrimwebapp/home">Accueil</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/escrimwebapp/personnel">Liste du
                                            Personnel</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/escrimwebapp/patient">Patient</a>
                                    </li>
                                    <li class="nav-item"><a class="nav-link"
                                            href="/escrimwebapp/inventaire">Inventaire</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/escrimwebapp/commande">Commande</a>
                                    </li>
                                    <li class="nav-item"><a class="nav-link"
                                            href="/escrimwebapp/transport">Transport</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/escrimwebapp/mission">Mission</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>

                        <!-- Corps de la page -->
                        <div class="container mt-5">
                            <h1 class="mb-4">Liste des commandes</h1>
    
                            <!-- Champ de recherche -->
                            <input class="form-control mb-3" id="searchInput" type="text" placeholder="Rechercher...">
    
                            <!-- Tableau Bootstrap pour la liste du personnel -->
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Date</th>
                                        <th>Colis</th>
                                        <th>Instructions</th>
                                        <th>Etat</th>
                                    </tr>
                                </thead>
                                <!--
                                <tbody id="tableBody">
                                    <% List<Personnel> personnelList = Application.getInstance().getPersonnelList();
                                        for (Personnel personnel : personnelList) {
                                        %>
                                        <tr>
                                            <%=personnel.toHtmlTableRow()%>
                                                <td>
                                                    <button type="button" class="btn btn-primary" data-toggle="modal"
                                                        data-target="#personnelModal" data-id="<%=personnel.getId()%>">
                                                        Voir la fiche
                                                    </button>
                                                </td>
    
                                        </tr>
                                        <% } %>
                                </tbody>
                                -->
                            </table>
    
                            <!-- Bouton pour ajouter du personnel -->
                            <button id="btnAddPersonnelShow" class="btn btn-primary mb-3">Ajouter une Commande</button>
    
                            <!-- Formulaire d'ajout de personnel -->
                            <div id="addPersonnel" style="display:none;">
                                <form action="addPersonnel" method="post" class="mb-3">
                                    <div class="form-group">
                                        <label for="last_name">Nom</label>
                                        <input type="text" class="form-control" id="last_name" name="last_name" required>
                                    </div>
    
                                    <div class="form-group">
                                        <label for="first_name">Prenom</label>
                                        <input type="text" class="form-control" id="first_name" name="first_name" required>
                                    </div>
    
                                    <div class="form-group">
                                        <label for="metier">Métier</label>
                                        <select class="form-control" id="metier" name="metier" required
                                            onchange="updateaffectationOptions()">
                                            <option value="medical">Personnel Medical</option>
                                            <option value="militaire">Militaire</option>
                                        </select>
                                    </div>
    
                                    <div class="form-group">
                                        <label for="affectation">Affectation</label>
                                        <select class="form-control" id="affectation" name="affectation" required>
                                            <option value="Chirugie">Chirurgie</option>
                                            <option value="Généraliste">Medecin Généraliste</option>
                                            <option value="Urgence">Urgentiste</option>
                                            <option value="Pédiatrie">Pédiatrie</option>
                                            <option value="Infirmier">Infirmier</option>
                                        </select>
    
                                    </div>
    
                                    <button type="submit" class="btn btn-success">Ajouter un Membre du
                                        personnel</button>
                                </form>
                            </div>
                        </div>
                        <!-- Bouton pour ouvrir la boîte modale -->
    
    
                        <!-- Boîte modale -->
                        <div class="modal fade" id="personnelModal" tabindex="-1" role="dialog"
                            aria-labelledby="personnelModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="personnelModalLabel">Fiche du personnel</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Fermer">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <!-- Le contenu de la fiche du personnel sera chargé ici -->
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
    
                                    </div>
                                </div>
                            </div>
                        </div>
                </body>
                </html>