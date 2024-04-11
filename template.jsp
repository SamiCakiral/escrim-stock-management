<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.webapp.mvc.<€ Modifier Ici pour le model Exemple personne.* pour avoir les personnes <€ " %>
            <%@ page import="com.webapp.mvc.Application" %>

                <!DOCTYPE html>
                <html>

                <head>
                    <!-- Ne pas toucher -->
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
                    <!-- Ne pas Changer (Sauf les liens a corriger ou a ajouté si y'en a des nouveaxu)-->
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
                                    <li class="nav-item"><a class="nav-link" href="/escrimwebapp/">Accueil</a></li>
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
                        <h1 class="mb-4">Voici la liste du <€A modifier pour une autre class <€</h1>

                        <!-- Champ de recherche -->
                        <input class="form-control mb-3" id="searchInput" type="text" placeholder="Rechercher...">

                        <!-- Tableau Bootstrap pour la liste du personnel -->
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nom</th>
                                    <€ Changer les colonnes pour les attributs de la classe, garder ID Et Actions au minimum <€
                                        
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody id="tableBody">
                                <<€ changer le nom de la classe je laisse le template pour l'appel du personnel pour l'exemple mais faite comme vous le voulez ici <€
                                <% List<Personnel> personnelList = Application.getInstance().getPersonnelList();
                                    for (Personnel personnel : personnelList) {
                                    %>
                                    <tr>
                                        <%=personnel.toHtmlTableRow()%> <!-- Pour ne pas surcharger le jsp, regardez la fonciton poru comprendre, elle permet juste d'afficher l'entiereté de la ligne d'un coup -->
                                            <td>
                                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                                    data-target="#personnelModal" data-id="<%=personnel.getId()%>"> 
                                                    Voir la fiche
                                                </button>
                                            </td>

                                    </tr>
                                    <% } %>
                                    <<€ Jusqu'a ici Vous pouvez modifier pensez bien a modifier tout les appels de personnel et verifiez les méthodes<€
                            </tbody>
                        </table>

                        <!-- Bouton pour ajouter une personne -->
                        <button id="btnAddPersonnelShow" class="btn btn-primary mb-3">Ajouter un Membre du <€A modifier pour une autre class <€
                            </button>

                            <€ Changer le formulaire pour les attributs de la classe, j'en laisse deux pour que vous voyez comment ca marche <€
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

                                

                                <button type="submit" class="btn btn-success">Ajouter un Membre du
                                    personnel</button>
                                    <€ Jusqu'ici pour le formulaire<€
                            </form>
                        </div>
                    </div>
                    <!-- Bouton pour ouvrir la boîte modale -->

                    <€ Ici c'est pour la boite modale, la boite qui s'affique quand vous appuyez sur le bouton voir fiche, changez juste les mots personnel par la class que vous voulez afficher (C'est uniquement de l'affichage, le code actif est en JS plus bas) <€
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
                <€ Vous devez modifier le lien pour la redirection vers la fiche de la classe que vous voulez afficher <€
                <script>
                    function ouvrirFichePersonnel(id) {
                        window.location.href = 'personnel/' + id; // Redirige vers la fiche du personnel
                    }


                    $(document).ready(function () {
                        $("#searchInput").on("keyup", function () {
                            var value = $(this).val().toLowerCase();
                            $("#tableBody tr").filter(function () {
                                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                            });
                        });
                        //$('.table').DataTable();

                         <€Modifier ici pour le bouton pour la classe que vous voulez ajouter <€
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
                        // <€ Changer le lien pour la classe que vous voulez afficher <€
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

                    <€ Changer le formulaire en fonciton de la classe que vous voulez ajouter et des attributs que vous avez mis dans le form <€
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