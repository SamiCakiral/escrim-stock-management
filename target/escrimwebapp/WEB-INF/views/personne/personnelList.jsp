<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.webapp.mvc.personne.personnel.*" %>
            <%@ page import="com.webapp.mvc.Application" %>

                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8">
                    <title>Liste Du Personnel</title>
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
                            <a class="navbar-brand" href="#">Liste du Personnel</a>
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
                        <h1 class="mb-4">Voici la liste du personnel</h1>

                        <!-- Champ de recherche -->
                        <input class="form-control mb-3" id="searchInput" type="text" placeholder="Rechercher...">

                        <!-- Tableau Bootstrap pour la liste du personnel -->
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nom</th>
                                    <th>Titre</th>
                                    <th>Métier</th>
                                    <th>Affectation</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody id="tableBody">
                                <% List<Personnel> personnelList = Application.getInstance().getPersonnelList();
                                    for (Personnel personnel : personnelList) {
                                    %>
                                    <tr>
                                        <%=personnel.toHtmlTableRow()%> <!-- Pour ne pas surcharger le jsp -->
                                            <td>
                                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                                    data-target="#personnelModal" data-id="<%=personnel.getId()%>">
                                                    Voir la fiche
                                                </button>
                                            </td>

                                    </tr>
                                    <% } %>
                            </tbody>
                        </table>

                        <!-- Bouton pour ajouter du personnel -->
                        <button id="btnAddPersonnelShow" class="btn btn-primary mb-3">Ajouter un Membre du
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
                <!-- Script pour gérer l'affichage du formulaire & l'affichage dans la boite modale -->
                <script>
                    function ouvrirFichePersonnel(id) {
                        window.location.href = 'personnel/' + id;
                    }


                    $(document).ready(function () {
                        $("#searchInput").on("keyup", function () {
                            var value = $(this).val().toLowerCase();
                            $("#tableBody tr").filter(function () {
                                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                            });
                        });
                        //$('.table').DataTable();
                        $('#btnAddPersonnelShow').click(function () {
                            var addPersonnelVisible = $('#addPersonnel').is(':visible');
                            if (!addPersonnelVisible) {
                                $(this).text('Annuler');
                            } else {
                                $(this).text('Ajouter un Membre du personnel');
                            }
                            $('#addPersonnel').slideToggle();
                            //$('#addPersonnel').Toggle();

                        });
                        // Script pour gérer l'affichage de la boîte modale
                        $('#personnelModal').on('show.bs.modal', function (event) {
                            var button = $(event.relatedTarget); // Bouton qui a déclenché la boîte modale
                            var id = button.data('id'); // Récupère l'ID du personnel

                            // Charge la fiche du personnel dans la boîte modale
                            $.get('personnel/' + id, function (data) {
                                var buttonHtml = '<button type="button" class="btn btn-primary" onclick="ouvrirFichePersonnel(' + id + ')">Ouvrir la fiche</button>';
                                $('.modal-body').html(data + buttonHtml);
                            });
                        });
                    });
                </script>


                <script>
                    function updateaffectationOptions() {
                        var metier = document.getElementById('metier').value;
                        var affectation = document.getElementById('affectation');

                        // Effacer les options existantes
                        affectation.innerHTML = '';

                        if (metier === 'medical') {
                            affectation.innerHTML = `
                        <option value="Chirurgie">Chirurgie</option>
                        <option value="GP">GP</option>
                        <option value="Urgence">Urgentiste</option>
                        <option value="Pédiatrie">Pédiatrie</option>
                        <option value="Infirmier">Infirmier</option>
                    `;
                        } else if (metier === 'militaire') {
                            affectation.innerHTML = `
                            <option value="Sdt">Soldat (Sdt)</option>
                            <option value="Cpl">Caporal (Cpl)</option>
                            <option value="Sgt">Sergent (Sgt)</option>
                            <option value="Adj">Adjudant (Adj)</option>
                            <option value="Lt">Lieutenant (Lt)</option>
                            <option value="Cpt">Capitaine (Cpt)</option>
                            <option value="Cmdt">Commandant (Cmdt)</option>
                            <option value="Col">Colonel (Col)</option>
                            <option value="Gén">Général (Gén)</option>
                    `;
                        }
                    }


                </script>
                <script>


                    $("form").submit(function (event) {
                        event.preventDefault();
                        var formData = {
                            nom: $("#nom").val(),
                            titre: $("#titre").val(),
                            metier: $("#metier").val(),
                            affectation: $("#affectation").val(),
                            action: "addPersonnel"
                        };
                        $.ajax({
                            url: "",
                            type: "POST",
                            data: formData,
                            success: function (response) {
                                // Handle success response
                                location.reload();
                            },
                            error: function (xhr, status, error) {
                                alert("Une erreur est survenue lors de l'ajout du personnel, veuillez réessayer.")
                            }
                        });
                    });

                </script>

                </html>