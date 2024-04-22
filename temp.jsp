<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webapp.mvc.stock.Coli" %>
<%@ page import="com.webapp.mvc.Application" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="com.webapp.mvc.stock.*" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Liste du Coli</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- CSS Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- JS Popper.js (needed for Bootstrap) -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- JS Bootstrap -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8"
        src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
</head>

<body>
    <!-- Sticky Header: Menu with Bootstrap Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
        <div class="container">
            <a class="navbar-brand" href="#">Liste du Coli</a>

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
                    <li class="nav-item"><a class="nav-link" href="/escrimwebapp/inventaire">Inventaire</a></li>
                    <li class="nav-item"><a class="nav-link" href="/escrimwebapp/commande">Commande</a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="/escrimwebapp/transport">Transport</a></li>
                    <li class="nav-item"><a class="nav-link" href="/escrimwebapp/mission">Mission</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Body of the page for Coli -->
    <div class="container mt-5">
        <h1 class="mb-4">Voici la liste du Coli</h1>
        <a class="nav-link" href="/escrimwebapp/inventaire">Liste du Materiel</a>

        <!-- Search field -->
        <input class="form-control mb-3" id="searchInput" type="text" placeholder="Rechercher...">

        <!-- Bootstrap table for the list of Coli -->
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Actions</th>
                </tr>
            </thead>

            <tbody id="tableBody">
                <% 
                List<Coli> coliList = Application.getInstance().getColiList();
                for (Coli coli : coliList) {
                %>
                <tr>
                    <td><%= coli.getId() %></td>
                    <td><%= coli.getNom() %></td>

                    <td>
                        <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#materielModal" data-id="<%=coli.getId()%>">
                            Voir la fiche
                        </button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick="viewColiDetails('<%= coli.getId() %>')">
                            Liste du materiel
                        </button>
                        
                        
                    </td>
                </tr>
                <% 
                }
                %>
            </tbody>
        </table>

        <!-- Button to add Coli -->
        <button id="btnAddColiShow" class="btn btn-primary mb-3">Ajouter un Coli</button>

        <!-- Form for adding Coli -->
        <div id="addColi" style="display:none;">
            <form action="/escrimwebapp/inventaire/coli" method="post" class="mb-3">
                <div class="form-group">
                    <label for="nom">Nom</label>
                    <input type="text" class="form-control" id="nom" name="nom" required>
                </div>
                <div class="form-group">
                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea class="form-control" id="description" name="description" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="options">Options</label>
                        <select class="form-control" id="options" name="options">
                            <option value="PAL">PAL</option>
                            <option value="MAL">MAL</option>
                            <option value="FAR">FAR</option>
                            <option value="BAC">BAC</option>
                        </select>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#materielModal">Ajouter Et Selectionner du Materiel</button>

                    </div>
                    <p> Materiaux dans le colis ajoutés </p>
                    <table id="materialsTable" class="table" >
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nom</th>
                                <th>Quantité</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Les lignes seront ajoutées par le script JavaScript -->
                        </tbody>
                    </table>
                    
                <!-- Button to submit the form -->
                <button type="submit" class="btn btn-success">Ajouter un Coli</button>
            </form>
        </div>
    </div>

    <!-- Modal box -->
    <div class="modal fade" id="materielModal" tabindex="-1" role="dialog" aria-labelledby="materielModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="materielModalLabel">Ajouter et Selectionner le materiel pour le Colis</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- The content of the Coli details will be loaded here -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modale Bootstrap pour afficher la liste des matériel -->
    <div class="modal fade" id="materielModal" tabindex="-1" role="dialog" aria-labelledby="materielModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-xl" role="document" style="width: 80% !important; "> <!-- modal-lg pour une modale plus grande si nécessaire -->
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="materielModalLabel">Ajouter et Selectionner le materiel pour le Colis</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Le contenu de materielList.jsp sera chargé ici -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="addToColisButton">Ajouter Sélection au Colis</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                    
                </div>
            </div>
        </div>
    </div>

    <!-- JavaScript -->
    <script>
        function viewColiDetails(id) {
                var url = "inventaire/coli/" + id;
            
                window.location.href = url;
        }

        $(document).ready(function () {
            $('#materielModal').on('show.bs.modal', function() {
                var modalBody = $(this).find('.modal-body');
                modalBody.load('/escrimwebapp/inventaire', function(response, status, xhr) {
                    if (status == "error") {
                        var msg = "Désolé mais il y a eu une erreur : ";
                        modalBody.html(msg + xhr.status + " " + xhr.statusText);
                    }
                });
            });
            // Filter table rows based on search input
            $("#searchInput").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#tableBody tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });

            // Show/hide add Coli form
            $('#btnAddColiShow').click(function () {
                var addColiVisible = $('#addColi').is(':visible');
                if (!addColiVisible) {
                    $(this).text('Annuler');
                } else {x
                    $(this).text('Ajouter un Coli');
                }
                $('#addColi').slideToggle();
            });

            // Handle showing Coli details in modal
            $('#materielModal').on('show.bs.modal', function (event) {
                
                var button = $(event.relatedTarget); // Button that triggered the modal
                var id = button.data('id'); // Get the ID from data-id attribute

                // Load Coli details into the modal body
                $.get('inventaire/coli/' + id, function (data) {
                    var buttonHtml = '<button type="button" class="btn btn-primary" onclick="ouvrirFicheMateriel(' + id + ')">Ouvrir la fiche</button>';
                    $('.modal-body').html(data + buttonHtml);
                    
                    // Update the modal body content pour retiré le sticky header
                    var modalBody = $(this).find('.modal-body');
                    modalBody.html(data + buttonHtml);

                    // Remove the navbar within the modal body if it exists
                    modalBody.find('.navbar').remove();
                    
                });
            });

            // Fonction pour ajouter au colis et fermer la modale
            function addToColis() {
                var selectedMaterials = [];
                // Parcourir chaque checkbox sélectionnée
                $('input[type="checkbox"]:checked').each(function() {
                    var id = $(this).attr('id');
                    var name = $(this).data('name'); // Assurez-vous que le nom est stocké comme attribut data-name
                    var qty = $(this).data('qty');  // Assurez-vous que la quantité est stockée comme attribut data-qty
                    selectedMaterials.push({id: id, name: name, quantity: qty});
                });

                // Fermer la modale
                $('#materielModal').modal('hide');


                // Stocker les IDs en JS pour utilisation ultérieure
                window.selectedMaterials = selectedMaterials;

                // Afficher les matériaux sélectionnés dans un tableau sur la page principale
                updateMaterialsTable(selectedMaterials);
            }

            // Fonction pour mettre à jour le tableau des matériaux sur la page principale
            function updateMaterialsTable(materials) {
                var tableBody = $('#materialsTable tbody');
                tableBody.empty(); // Vider les entrées existantes
                materials.forEach(function(material) {
                    var row = '<tr>' +
                                '<td>' + material.id + '</td>' +
                                '<td>' + material.name + '</td>' +
                                '<td>' + material.quantity + '</td>' +
                            '</tr>';
                    tableBody.append(row);
                });
            }

            // Attacher la fonction addToColis au bouton ou à l'événement approprié
            $('#addToColisButton').click(addToColis);
            
        });
    </script>
</body>

</html>
