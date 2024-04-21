<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Materiel</title>
</head>
<body>
    <h1>Page type pour un materiel fiche produit</h1>
    
    <h2>Détails du Materiel</h2>
    <p>ID: ${materiel.getId()}</p>
    <p>Nom: ${materiel.getNom()}</p>
    <p>Marque: ${materiel.getMarque()}</p>
    <p>Model: ${materiel.getModel()}</p>
    <p>Quantite: ${materiel.getQuantite()}</p>
    

    <button type="button">Recommander</button>
    <p> Ceci est un exmeple de foncitonnalité que l'on peut ajouter (bouton n'étant pas fonctionnel)</p>
    
    
</body>
</html>