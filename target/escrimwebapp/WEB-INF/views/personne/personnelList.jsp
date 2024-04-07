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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <!-- Sticky Header : Menu -->
    <div class="sticky">
        <ul>
            <li><a href="index.jsp">Accueil</a></li>
            <li><a href="personnel.jsp">Personnel</a></li>
            <li><a href="departement.jsp">Département</a></li>
            <li><a href="metier.jsp">Métier</a></li>
        </ul>
    </div>




    <h1>Voici la liste du personnel</h1>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Titre</th>
            <th>Métier</th>
            <th>Département</th>
            
        </tr>
        <% 
        List<Personnel> personnelList = Application.getInstance().getPersonnelList();
        for (Personnel personnel : personnelList) {
        %>
        <tr>
            <%=personnel.toHtmlTableRow()%>
        </tr>
        <% } %>
    </table>
    
    <button id="btnAddPersonnel">Ajouter un Membre du personnel</button>
    <div id="addPersonnel" style="display=none;">
    <form action="addPersonnel" method="post">

        <label for="nom">Nom</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="titre">Titre</label>
        <input type="text" id="titre" name="titre" required><br> <!-- Pvt, Sgt, Ltn, Dr, etc -->

        
        <label for="metier">Métier</label>
        <select id="metier" name="metier" required>
            <option value="medical">Personnel Medical</option>
            <option value="militaire">Militaire</option>
        </select><br>

        <label for="departement">Département</label>
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


        <input type="submit" value="Ajouter un Membre du personnel">
    </form>
    </div>


    <a href="/escrimwebapp/">Retour à l'accueil</a>

</body>

<script>
    $(document).ready(function(){
        $("#btnAddPersonnel").click(function(){
            $("#addPersonnel").toggle();
        });
    });

    $("form").submit(function(event) {
        event.preventDefault();
        var formData = $(this).serialize();
        $.ajax({
            url: "addPersonnel",
            type: "POST",
            data: formData,
            success: function(response) {
                // Handle success response
            },
            error: function(xhr, status, error) {
                // Handle error response
            }
        });
    });

</script>
</html>