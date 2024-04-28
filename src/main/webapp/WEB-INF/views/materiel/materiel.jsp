<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Materiel</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- CSS Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- JS Popper.js (nécessaire pour Bootstrap) -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- JS Bootstrap -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Page type pour un materiel fiche produit</h1>
    
    <h2>Détails du Materiel</h2>
    <p>ID: ${materiel.getId()}</p>
    <p>Nom: ${materiel.getNom()}</p>
    <p>Date d'expiration ${materiel.getDateExpiration()}</p>
    

    <button type="button">Recommander</button>
    <button type="button" id = "delBtn">Supprimer</button>
    <p> Ceci est un exmeple de foncitonnalité que l'on peut ajouter (bouton n'étant pas fonctionnel)</p>
    <button type="button" id = "updateBtn">Partager</button>
    <input type="hidden" id="idMateriel" value="${materiel.getId()}">
    <script>
        $(document).ready(function () {
            
            $("#updateBtn").click(function () {
                alert("Cette fonctionnalité n'est pas implémentée mais pourra à terme sortir un formulaire pour modifier les informations du materiel, Foncionne exactement comme pour le personnel.");
            });

            $("#formUpdatePersonnel").submit(function (event) {
                event.preventDefault();
                var formData = {
                    id: $("#idMateriel").val(),
                    
                    action: "updateMateriel"
                };
                $.ajax({
                    url: "/escrimwebapp/inventaire",
                    type: "POST",
                    data: formData,
                    success: function (response) {
                        // Handle success response
                        location.reload();
                    },
                    error: function (xhr, status, error) {
                        alert("Une erreur est survenue lors de la maj du materiel, veuillez réessayer.")
                    }
                });

                
            });

            $("#delBtn").click(function () {
                    var formData = {
                        id: $("#idMateriel").val(),
                        action: "deleteMateriel"
                    };
                    if (confirm("Êtes-vous sûr de vouloir supprimer ce materiel ?")) {
                        // Continue with the AJAX request
                        $.ajax({
                            url: "/escrimwebapp/inventaire",
                            type: "POST",
                            data: formData,
                            success: function (response) {
                                // Handle success response
                                location.reload();
                            },
                            error: function (xhr, status, error) {
                                alert("Une erreur est survenue lors de la suppression du materiel, veuillez réessayer.")
                            }
                        });
                    }
                });

            $("#shareBtn").click(function () {
                alert("Cette fonctionnalité n'est pas implémentée mais pourra à terme sortir une fiche CSV ou sous un autre format pour un partage.");
            });
        });
    </script>
</body>
</html>