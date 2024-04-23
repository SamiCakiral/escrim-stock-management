<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webapp.mvc.materiel.*" %>
<%@ page import="com.webapp.mvc.stock.Coli" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Coli Details</title>
</head>
<body>
    <h1>Coli Details</h1>
    <h2>Details of Coli</h2>
    <p>ID: ${coli.getId()}</p>
    <p>Nom: ${coli.getNom()}</p>
    <p>list: ${coli.getListMaterielMedical()}</p>
    
    <h3>List of Materiel:</h3>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Quantité en Stock</th>
                <th>Description</th>
                <th>Fournisseur</th>
                <th>Date d'Expiration</th>
            </tr>
        </thead>
       
    </table>
</body>
</html>
