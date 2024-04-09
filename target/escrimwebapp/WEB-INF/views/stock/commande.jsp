<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Commandes</title>
</head>
<body>
    <h1>Liste des commandes</h1>
    
    <%-- Insérez ici votre logique pour récupérer les commandes depuis la base de données ou un autre service --%>
    
    <%-- Parcourez les commandes et affichez-les --%>
    <table>
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Client</th>
            <th>Total</th>
        </tr>
        <%-- Exemple de boucle pour afficher les commandes --%>
        <% for (Commande commande : listeCommandes) { %>
            <tr>
                <td><%= commande.getId() %></td>
                <td><%= commande.getDate() %></td>
                <td><%= commande.getClient() %></td>
                <td><%= commande.getTotal() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>