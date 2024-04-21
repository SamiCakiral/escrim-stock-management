<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.webapp.mvc.materiel.*" %>
            <%@ page import="com.webapp.mvc.Application" %>
                <%@ page import="java.text.SimpleDateFormat" %>
                    <%@ page import="java.text.ParseException" %>
                        <%@ page import="com.webapp.mvc.stock.Coli" %>

                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8">
                    <title>Liste du Matériel</title>
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
                            <a class="navbar-brand" href="#">Liste du Materiel</a>

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

                    <!-- Corps de la page pour Matériels -->
                    <div class="container mt-5">
                        <h1 class="mb-4">Voici la liste du matériel</h1>
                        <a class="nav-link"href="/escrimwebapp/inventaire/coli">Voir la liste du Coli</a>

                        <!-- Champ de recherche -->
                        <input class="form-control mb-3" id="searchInput" type="text" placeholder="Rechercher...">

                        <!-- Tableau Bootstrap pour la liste du materiel -->
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nom</th>
                                    <th>Quantité en Stock</th>
                                    <th>Description</th>
                                    <th>Fournisseur</th>
                                    <th>Date d'Expiration</th>
                                    <th>Types</th>
                                    <th>Colis</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            
                            <tbody id="tableBody">
                                <% 
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                List<MaterielMedical> materielList = Application.getInstance().getMaterielList();
                                for (MaterielMedical materiel : materielList) {
                                    %>
                                    <tr>
                                        <td><%= materiel.getId() %></td>
                                        <td><%= materiel.getNom() %></td>
                                        <td><%= materiel.getQuantiteEnStock() %></td>
                                        <td><%= materiel.getDescription() %></td>
                                        <td><%= materiel.getFournisseur() %></td>
                                        <td>
                                            <% 
                                            if (materiel.getDateExpiration() != null) {
                                                out.print(dateFormat.format(materiel.getDateExpiration()));
                                            } else {
                                                out.print("N/A"); 
                                            }
                                            %>
                                        </td>
                                        <td><%= materiel.getType() %></td>
                                        <td><%= materiel.getColi() %></td>

                                        <td>
                                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                                    data-target="#materielModal" data-id="<%=materiel.getId()%>">
                                                Voir la fiche
                                            </button>
                                        </td>
                                    </tr>
                                <% 
                                } 
                                %>
                            </tbody>
                        </table>

                        <!-- Bouton pour ajouter du materiel -->
                        <button id="btnAddMaterielShow" class="btn btn-primary mb-3">Ajouter un Membre du
                            materiel</button>


                        <!-- Formulaire d'ajout de materiel -->
                        <div id="addMateriel" style="display:none;">
                            <form action="addMateriel" method="post" class="mb-3">
                                <div class="form-group">
                                    <label for="nom">Nom</label>
                                    <input type="text" class="form-control" id="nom" name="nom" required>
                                </div>
                                <div class="form-group">
                                    <label for="quantiteEnStock">Quantité en stock</label>
                                    <input type="number" class="form-control" id="quantiteEnStock" name="quantiteEnStock" required>
                                </div>
                                <div class="form-group">
                                    <label for="description">Description</label>
                                    <textarea class="form-control" id="description" name="description" rows="3"></textarea>
                                </div>
                                <div class="form-group">
                                    <label for="fournisseur">Fournisseur</label>
                                    <input type="text" class="form-control" id="fournisseur" name="fournisseur">
                                </div>
                                <!-- Additional input fields for other properties of MaterielMedical -->
                                <div class="form-group">
                                    <label for="dateExpiration">Date d'expiration</label>
                                    <input type="date" class="form-control" id="dateExpiration" name="dateExpiration">
                                </div>
                                <div class="form-group">
                                    <label for="Types">Types</label>
                                    <select class="form-control" id="Types" name="Types" required>
                                        <option value="equipement">Equipement</option>
                                        <option value="medicament">Medicament</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="Colis">Coli</label>
                                    <select class="form-control" id="Colis" name="Colis" required>
                                        <% 
                                        List<Coli> coliList = Application.getInstance().getColiList();
                                        for (Coli coli : coliList) {
                                            %>
                                            <option value="<%= coli.getNom() %>"><%= coli.getNom() %></option>
                                            <% 
                                        } 
                                        %>
                                    </select>
                                </div>
                                
                                
                                <!-- Button to submit the form -->
                                <button type="submit" class="btn btn-success">Ajouter un Membre du materiel</button>
                            </form>
                        </div>
                        
                    </div>

                    <!-- Bouton pour ouvrir la boîte modale -->

                    <!-- Boîte modale -->
                    <div class="modal fade" id="materielModal" tabindex="-1" role="dialog"
                        aria-labelledby="materielModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="materielModalLabel">Fiche du materiel</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Fermer">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <!-- Le contenu de la fiche du materiel sera chargé ici -->
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <script>
                        function ouvrirFicheMateriel(id) {
                            window.location.href = 'materiel/' + id;
                        }


                        $(document).ready(function () {
                            $("#searchInput").on("keyup", function () {
                                var value = $(this).val().toLowerCase();
                                $("#tableBody tr").filter(function () {
                                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                                });
                            });
                            //$('.table').DataTable();
                            $('#btnAddMaterielShow').click(function () {
                                var addMaterielVisible = $('#addMateriel').is(':visible');
                                if (!addMaterielVisible) {
                                    $(this).text('Annuler');
                                } else {
                                    $(this).text('Ajouter un Membre du materiel');
                                }
                                $('#addMateriel').slideToggle();
                                //$('#addMateriel').Toggle();

                            });
                            // Script pour gérer l'affichage de la boîte modale
                            $('#materielModal').on('show.bs.modal', function (event) {
                                var button = $(event.relatedTarget); // Bouton qui a déclenché la boîte modale
                                var id = button.data('id'); // Récupère l'ID du materiel

                                // Charge la fiche du materiel dans la boîte modale
                                $.get('materiel/' + id, function (data) {
                                    var buttonHtml = '<button type="button" class="btn btn-primary" onclick="ouvrirFicheMateriel(' + id + ')">Ouvrir la fiche</button>';
                                    $('.modal-body').html(data + buttonHtml);
                                });
                            });
                        });
                    </script>

                    <script>
                        $("form").submit(function (event) {
                            event.preventDefault();
                            var formData = {
                                nom: $("#nom").val(),
                                quantiteEnStock: $("#quantiteEnStock").val(),
                                description: $("#description").val(),
                                fournisseur: $("#fournisseur").val(),
                                dateExpiration: $("#dateExpiration").val(),
                                Types: $("#Types").val(),
                                Colis: $("#Colis").val(),
                                action: "addMateriel"
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
                                    alert("An error occurred while adding the material, please try again.");
                                }
                            });
                        });


                    </script>
                </body>
                </html>