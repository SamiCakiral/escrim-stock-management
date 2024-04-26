<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Personnel</title>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <!-- CSS Bootstrap -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

        <!-- JS Popper.js (nécessaire pour Bootstrap) -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

        <!-- JS Bootstrap -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>

    <body>
        <h1>Page type pour une personne</h1>
        <img src="${personnel.getPhoto()}" alt="Image du personnel">
        <h2>Détails du Personnel</h2>
        <p>ID: ${personnel.getId()}</p>
        <p>Nom: ${personnel.getNom()}</p>
        <p>Métier: ${personnel.getMetier()}</p>
        <p>Département: ${personnel.getAffectation()}</p>

        <button type="button" class="button" id="updateBtn">Modifier</button>
        <button type="button" class="button" id="delBtn">Supprimer</button>
        <button type="button" class="button" id="shareBtn">Partager</button>

        <div id="updatePersonnel" style="display:none;">
            <form id="formUpdatePersonnel" action="updatePersonnel" method="post" class="mb-3">
                <div class="form-group">
                    <label for="last_name">Nom</label>
                    <input type="text" class="form-control" id="last_name" name="last_name" value="${personnel.getLast_name()}" required>
                </div>

                <div class="form-group">
                    <label for="first_name">Prenom</label>
                    <input type="text" class="form-control" id="first_name" name="first_name" value="${personnel.getFirst_name()}" required>
                </div>

                <div class="form-group">
                    <label for="metier">Métier</label>
                    <select class="form-control" id="metier" name="metier" value="${personnel.getMetier()}" disabled
                        onchange="updateaffectationOptions()">
                        <option value="medical">Personnel Medical</option>
                        <option value="militaire">Militaire</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="affectation">Affectation</label>
                    <select class="form-control" id="affectation" name="affectation" value="${personnel.getAffectation()}" required>
                        <option value="Chirugie">Chirurgie</option>
                        <option value="Généraliste">Medecin Généraliste</option>
                        <option value="Urgence">Urgentiste</option>
                        <option value="Pédiatrie">Pédiatrie</option>
                        <option value="Infirmier">Infirmier</option>
                    </select>

                </div>

                <input type="hidden" id="id" name="id" value="${personnel.getId()}">

                <button type="submit" class="btn btn-success">Modifier ce Membre du
                    personnel</button>
            </form>
        </div>
    </body>
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

        $(document).ready(function () {
            $("#updateBtn").click(function () {
                $("#updatePersonnel").toggle();
            });

            $("#formUpdatePersonnel").submit(function (event) {
                event.preventDefault();
                var formData = {
                    id: $("#id").val(),
                    last_name: $("#last_name").val(),
                    first_name: $("#first_name").val(),
                    affectation: $("#affectation").val(),
                    action: "updatePersonnel"
                };
                $.ajax({
                    url: "/escrimwebapp/personnel",
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

            $("#delBtn").click(function () {
                    var formData = {
                        id: $("#id").val(),
                        action: "deletePersonnel"
                    };
                    if (confirm("Êtes-vous sûr de vouloir supprimer ce membre du personnel ?")) {
                        // Continue with the AJAX request
                        $.ajax({
                            url: "/escrimwebapp/personnel",
                            type: "POST",
                            data: formData,
                            success: function (response) {
                                // Handle success response
                                location.reload();
                            },
                            error: function (xhr, status, error) {
                                alert("Une erreur est survenue lors de la suppression du personnel, veuillez réessayer.")
                            }
                        });
                    }
                });

            $("#shareBtn").click(function () {
                alert("Cette fonctionnalité n'est pas implémentée mais pourra à terme sortir une fiche CSV ou sous un autre format pour un partage.");
            });


        });



    </script>

    </html>