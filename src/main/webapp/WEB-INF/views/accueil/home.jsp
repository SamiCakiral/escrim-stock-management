<!-- Fichier : src/main/webapp/WEB-INF/views/accueil/home.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.webapp.mvc.personne.personnel.*" %>
            <%@ page import="com.webapp.mvc.Application" %>

                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8">
                    <title>Accueil</title>
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
                            <a class="navbar-brand" href="#">Accueil</a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarNav">
                                <ul class="navbar-nav">
                                    <li class="nav-item"><a class="nav-link" href="/escrimwebapp/accueil">Accueil</a></li>
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
                        <p>
                            Bienvenue sur notre site permettant la gestion de stocks dans l'hopital ESCRIM! Ici, vous pouvez gérer les informations relatives au personnel, aux patients, à l'inventaire, aux commandes, au transport et aux missions. Utilisez la barre de navigation pour accéder aux différentes sections du site.
                        </p>
                        <p>
                            <ul>
                                <li>Accueil - Page d'accueil du site, qui présente notre travail</li>
                                <li>Liste du Personnel - Liste des membres du personnel, militaires comme médecins</li>
                                <li>Patient - Gestion des informations des patients, les traitements</li>
                                <li>Inventaire - Gestion de l'inventaire avec les différents colis, médicaments</li>
                                <li>Commande - Gestion des commandes et des différents colis</li>
                                <li>Transport - Gestion du transport avec les différents avions</li>
                                <li>Mission - Gestion des missions</li>
                            </ul>
                        </p>
                    </div>
                </body>
                </html>