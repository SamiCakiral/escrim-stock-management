<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Personnel</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #eef1f5;
            margin: 40px;
            color: #35424a;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        h2 {
            color: #333;
            margin-top: 20px;
        }

        img {
            display: block;
            width: 120px;
            height: auto;
            border-radius: 60px;
            margin: 20px auto; /* Centrer l'image */
        }

        p {
            background-color: #ffffff;
            padding: 12px 20px;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            margin: 8px 0;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px 5px;
            border-radius: 5px;
            background-color: #5c85d6;
            color: white;
            text-align: center;
            text-decoration: none;
            font-weight: bold;
            box-shadow: 0 2px 4px rgba(0,0,0,0.2);
            transition: background-color 0.3s;
        }

        .button:hover {
            background-color: #4169e1;
        }

        .button:active {
            background-color: #35424a;
        }
    </style>
</head>
<body>
    <h1>Page type pour une personne</h1>
    <img src="${personnel.getPhoto()}" alt="Image du personnel">
    <h2>Détails du Personnel</h2>
    <p>ID: ${personnel.getId()}</p>
    <p>Nom: ${personnel.getNom()}</p>
    <p>Métier: ${personnel.getMetier()}</p>
    <p>Département: ${personnel.getAffectation()}</p>

    <button type="button" class="button">Modifier</button>
    <button type="button" class="button">Supprimer</button>
    <button type="button" class="button">Partager</button>
</body>
</html>
