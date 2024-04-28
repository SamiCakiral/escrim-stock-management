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
                    <label for="last_name_">Nom</label>
                    <input type="text" class="form-control" id="last_name_" name="last_name_" value="${personnel.getLast_name()}" required>
                </div>

                <div class="form-group">
                    <label for="first_name_">Prenom</label>
                    <input type="text" class="form-control" id="first_name_" name="first_name_" value="${personnel.getFirst_name()}" required>
                </div>

                <div class="form-group">
                    <label for="metier">Métier</label>
                    <select class="form-control" id="metier_" name="metier_" value="${personnel.getMetier()}" disabled
                        onchange="updateaffectationOptions_()">
                        <option value="medical" ${personnel.getMetier() == 'Médecin' ? 'selected' : ''}>Personnel Medical</option>
                        <option value="militaire" ${personnel.getMetier() == 'Militaire' ? 'selected' : ''}>Militaire</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="affectation_">Affectation</label>
                    <select class="form-control" id="affectation_" name="affectation_" required>
                        <option value="Chirugie" ${personnel.getAffectation() == 'Chirugie' ? 'selected' : ''}>Chirurgie</option>
                        <option value="Généraliste" ${personnel.getAffectation() == 'Généraliste' ? 'selected' : ''}>Medecin Généraliste</option>
                        <option value="Urgence" ${personnel.getAffectation() == 'Urgence' ? 'selected' : ''}>Urgentiste</option>
                        <option value="Pédiatrie" ${personnel.getAffectation() == 'Pédiatrie' ? 'selected' : ''}>Pédiatrie</option>
                        <option value="Infirmier" ${personnel.getAffectation() == 'Infirmier' ? 'selected' : ''}>Infirmier</option>
                    </select>

                </div>

                <input type="hidden" id="id" name="id" value="${personnel.getId()}">

                <button type="submit" class="btn btn-success">Modifier ce Membre du
                    personnel</button>
            </form>
        </div>
    </body>
    <script>
        function updateaffectationOptions_() {
            var metier = document.getElementById('metier_').value;
            var affectation = document.getElementById('affectation_');

            // Effacer les options existantes
            affectation.innerHTML = '';

            if (metier === 'medical') {
                affectation.innerHTML = `
                <option value="Chirugie" ${personnel.getAffectation() == 'Chirugie' ? 'selected' : ''}>Chirurgie</option>
                        <option value="Généraliste" ${personnel.getAffectation() == 'Généraliste' ? 'selected' : ''}>Medecin Généraliste</option>
                        <option value="Urgence" ${personnel.getAffectation() == 'Urgence' ? 'selected' : ''}>Urgentiste</option>
                        <option value="Pédiatrie" ${personnel.getAffectation() == 'Pédiatrie' ? 'selected' : ''}>Pédiatrie</option>
                        <option value="Infirmier" ${personnel.getAffectation() == 'Infirmier' ? 'selected' : ''}>Infirmier</option>
        `;
            } else if (metier === 'militaire') {
                affectation.innerHTML = `
                <option value="Sdt"  ${personnel.getAffectation() == 'Sdt' ? 'selected' : ''}>Soldat (Sdt)</option>
                <option value="Cpl"  ${personnel.getAffectation() == 'Cpl' ? 'selected' : ''}>Caporal (Cpl)</option>
                <option value="Sgt"  ${personnel.getAffectation() == 'Sgt' ? 'selected' : ''}>Sergent (Sgt)</option>
                <option value="Adj"  ${personnel.getAffectation() == 'Adj' ? 'selected' : ''}>Adjudant (Adj)</option>
                <option value="Lt"   ${personnel.getAffectation() == 'Lt' ? 'selected' : ''}>Lieutenant (Lt)</option>
                <option value="Cpt"  ${personnel.getAffectation() == 'Cpt' ? 'selected' : ''}>Capitaine (Cpt)</option>
                <option value="Cmdt" ${personnel.getAffectation() == 'Cmdt' ? 'selected' : ''}>Commandant (Cmdt)</option>
                <option value="Col"  ${personnel.getAffectation() == 'Col' ? 'selected' : ''}>Colonel (Col)</option>
                <option value="Gén"  ${personnel.getAffectation() == 'Gén' ? 'selected' : ''}>Général (Gén)</option>
        `;
            }
        }


    </script>
    <script>

        $(document).ready(function () {
            updateaffectationOptions_();
            $("#updateBtn").click(function () {
                $("#updatePersonnel").toggle();
            });

            $("#formUpdatePersonnel").submit(function (event) {
                event.preventDefault();
                var formData = {
                    id: $("#id").val(),
                    last_name: $("#last_name_").val(),
                    first_name: $("#first_name_").val(),
                    affectation: $("#affectation_").val(),
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