<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.webapp.mvc.personne.patient.Patient" %>
<%@ page import="com.webapp.mvc.personne.personnel.PersonnelMedical" %>
<%@ page import="com.webapp.mvc.DAOManager" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Liste des Patients</title>
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
            <a class="navbar-brand" href="#">Liste des Patient</a>
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

    <!-- Corps de la page pour Patients -->
    <div class="container mt-5">
        <h1 class="mb-4">Voici la liste des patients</h1>
        
        <!-- Champ de recherche -->
        <input class="form-control mb-3" id="searchInput" type="text" placeholder="Rechercher...">

        <!-- Tableau Bootstrap pour la liste du patient -->
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Date de Naissance</th>
                    <th>Medecin Attitré</th>
                    <th>Etat d'urgence</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody id="tableBody">
                <% List<Patient> patientList = DAOManager.getInstance().getDAOPatient().findAllPatients();
                    for (Patient patient : patientList) {
                    %>
                    <tr>
                        <!-- patient.toHtmlTableRow() -->
                        <td><%=patient.getId()%></td>
                        <td><%=patient.getNom()%></td>
                        <td><%=patient.getPrenom()%></td>
                        <td><%=patient.getDob()%></td>
                        <td><%=patient.getMedecinAttitre().getNom()%></td>
                        <td><%=patient.isEtatUrgence()%></td>
                            <td>
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#patientModal" data-id="<%=patient.getId()%>">
                                    Voir la fiche
                                </button>
                            </td>

                    </tr>
                    <% } %>
            </tbody>
        </table>

        <!-- Bouton pour ajouter du patient -->
        <button id="btnAddPatientShow" class="btn btn-primary mb-3">Ajouter un 
            patient</button>

        <!-- Formulaire d'ajout de patient -->
        <div id="addPatient" style="display:none;">
            <form action="addPatient" method="post" class="mb-3">
                <div class="form-group">
                    <label for="nom">Nom</label>
                    <input type="text" class="form-control" id="nom" name="nom" required>
                </div>
                <div class="form-group">
                    <label for="prenom">Prénom</label>
                    <input type="text" class="form-control" id="prenom" name="prenom" required>
                </div>
                <div class="form-group">
                    <label for="dob">Date de Naissance</label>
                    <input type="date" class="form-control" id="dob" name="dob" required>
                </div>
                <div class="form-group">
                    <label for="medecinAttitre">Médecin Attitré</label>
                    <select class="form-control" id="medecinAttitre" name="medecinAttitre" required>
                        <option value="">Sélectionnez un médecin</option>
                        <% PersonnelMedical[] medecinList = DAOManager.getInstance().getDAOPersonnel().findAllPersonnelMedical();
                            for (PersonnelMedical medecin : medecinList) {
                            %>
                            <option value="<%=medecin.getId()%>"><%=medecin.getNom()%></option>
                            <% } %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="etatUrgence">Etat d'urgence</label>
                    <select class="form-control" id="etatUrgence" name="etatUrgence" required>
                        <option value="">Sélectionnez l'état d'urgence</option>
                        <option value="true">Oui</option>
                        <option value="false">Non</option>
                    </select>
                </div>
                

                <button type="submit" class="btn btn-success">Ajouter un 
                    patient</button>
            </form>
        </div>
    </div>
    <!-- Bouton pour ouvrir la boîte modale -->


    <!-- Boîte modale -->
    <div class="modal fade" id="patientModal" tabindex="-1" role="dialog"
        aria-labelledby="patientModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="patientModalLabel">Fiche du patient</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fermer">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Le contenu de la fiche du patient sera chargé ici -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>

                </div>
            </div>
        </div>
    </div>

    <script>
        function ouvrirFichePatient(id) {
            window.location.href = 'patient/' + id;
        }


        $(document).ready(function () {
            $("#searchInput").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#tableBody tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
            //$('.table').DataTable();
            $('#btnAddPatientShow').click(function () {
                var addPatientVisible = $('#addPatient').is(':visible');
                if (!addPatientVisible) {
                    $(this).text('Annuler');
                } else {
                    $(this).text('Ajouter un Membre du patient');
                }
                $('#addPatient').slideToggle();
                //$('#addPatient').Toggle();

            });
            // Script pour gérer l'affichage de la boîte modale
            $('#patientModal').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget); // Bouton qui a déclenché la boîte modale
                var id = button.data('id'); // Récupère l'ID du patient

                // Charge la fiche du patient dans la boîte modale
                $.get('patient/' + id, function (data) {
                    var buttonHtml = '<button type="button" class="btn btn-primary" onclick="ouvrirFichePatient(' + id + ')">Ouvrir la fiche</button>';
                    $('.modal-body').html(data + buttonHtml);
                });
            });
        });
    </script>


    
    <script>


        $("form").submit(function (event) {
            event.preventDefault();
            var formData = {
                dob: $("#dob").val(),
                medecinAttitreId: $("#medecinAttitre").val(),
                etatUrgence: $("#etatUrgence").val(),
                nom: $("#nom").val(),
                prenom: $("#prenom").val(),
                action:"addPatient"
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
                    alert("Une erreur est survenue lors de l'ajout du patient, veuillez réessayer.")
                }
            });
        });

    </script>
</body>
</html>
