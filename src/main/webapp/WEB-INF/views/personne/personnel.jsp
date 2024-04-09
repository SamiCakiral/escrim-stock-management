<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Personnel</title>
</head>
<body>
    <h1>Page type pour une personne </h1>
    <img src="${personnel.getPhoto()}" alt="Personnel Image"> <!-- Si un membre du personnel possède une photo -->
    <h2>Détails du Personnel</h2>
    <p>ID: ${personnel.getId()}</p>
    <p>Nom: ${personnel.getName()}</p>
    <p>Titre: ${personnel.getTitre()}</p>
    <p>Métier: ${personnel.getMetier()}</p>
    <p>Département: ${personnel.getAffectation()}</p>
    
</body>
</html>