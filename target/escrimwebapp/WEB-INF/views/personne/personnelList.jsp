<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="java.util.List" %>
            <%@ page import="com.webapp.mvc.model.personne.personnel.*" %>
                <%@ page import="com.webapp.mvc.model.Application" %>

                    <!DOCTYPE html>
                    <html>

                    <head>
                        <meta charset="UTF-8">
                        <title>Liste Du Personnel</title>
                        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
                            rel="stylesheet">
                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                    </head>

                    <body>
                        <!-- Sticky Header : Menu avec Navbar Bootstrap -->
                        <nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
                            <div class="container">
                                <a class="navbar-brand" href="#">Liste du Personnel</a>
                                <button class="navbar-toggler" type="button" data-toggle="collapse"
                                    data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                                    aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse" id="navbarNav">
                                    <ul class="navbar-nav">
                                        <li class="nav-item"><a class="nav-link" href="index.jsp">Accueil</a></li>
                                        <li class="nav-item"><a class="nav-link" href="personnel.jsp">Personnel</a></li>
                                        <li class="nav-item"><a class="nav-link" href="departement.jsp">Département</a>
                                        </li>
                                        <li class="nav-item"><a class="nav-link" href="metier.jsp">Métier</a></li>
                                    </ul>
                                </div>
                            </div>
                        </nav>

                        <!-- Corps de la page -->
                        <div class="container mt-5">
                            <h1 class="mb-4">Voici la liste du personnel</h1>

                            <!-- Tableau Bootstrap pour la liste du personnel -->
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nom</th>
                                        <th>Titre</th>
                                        <th>Métier</th>
                                        <th>Département</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% List<Personnel> personnelList = Application.getInstance().getPersonnelList();
                                        for (Personnel personnel : personnelList) {
                                        %>
                                        <tr>
                                            <%=personnel.toHtmlTableRow()%>
                                        </tr>
                                        <% } %>
                                </tbody>
                            </table>

                            <!-- Bouton pour ajouter du personnel -->
                            <button id="btnAddPersonnel" class="btn btn-primary mb-3">Ajouter un Membre du
                                personnel</button>

                            <!-- Formulaire d'ajout de personnel -->
                            <div id="addPersonnel" style="display:none;">
                                <form action="addPersonnel" method="post" class="mb-3">
                                    <div class="form-group">
                                        <label for="nom">Nom</label>
                                        <input type="text" class="form-control" id="nom" name="nom" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="titre">Titre</label>
                                        <input type="text" class="form-control" id="titre" name="titre" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="metier">Métier</label>
                                        <select class="form-control" id="metier" name="metier" required
                                            onchange="updateDepartementOptions()">
                                            <option value="medical">Personnel Medical</option>
                                            <option value="militaire">Militaire</option>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label for="departement">Département</label>
                                        <select class="form-control" id="departement" name="departement"
                                            required></select>
                                    </div>

                                    <button type="submit" class="btn btn-success">Ajouter un Membre du
                                        personnel</button>
                                </form>
                            </div>
                        </div>
                    </body>
                    <!-- Script pour gérer l'affichage du formulaire -->
                    <script>
                        $(document).ready(function () {
                            $('#btnAddPersonnel').click(function () {
                                $('#addPersonnel').slideToggle();
                            });
                        });
                    </script>


                    <script>
                        function updateDepartementOptions() {
                            var metier = document.getElementById('metier').value;
                            var departement = document.getElementById('departement');

                            // Effacer les options existantes
                            departement.innerHTML = '';

                            if (metier === 'medical') {
                                departement.innerHTML = `
                        <option value="chirugie">Chirurgie</option>
                        <option value="GP">GP</option>
                        <option value="Urgence">Urgentiste</option>
                        <option value="Pédiatrie">Pédiatrie</option>
                        <option value="Infirmier">Infirmier</option>
                    `;
                            } else if (metier === 'militaire') {
                                departement.innerHTML = `
                        <option value="Soldat">Soldat</option>
                        <option value="Leader">Chef d'escouade</option>
                        <option value="Commandant">Commandant</option>
                    `;
                            }
                        }
                    </script>
                    <script>


                        $("form").submit(function (event) {
                            event.preventDefault();
                            var formData = $(this).serialize();
                            $.ajax({
                                url: "addPersonnel",
                                type: "POST",
                                data: formData,
                                success: function (response) {
                                    // Handle success response
                                },
                                error: function (xhr, status, error) {
                                    // Handle error response
                                }
                            });
                        });

                    </script>

                    </html>