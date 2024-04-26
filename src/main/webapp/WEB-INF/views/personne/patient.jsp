<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient</title>
</head>
<body>
    <h1>Page type pour un Patient </h1>
    <p>
        Patient : ${patient.nom} ${patient.getPrenom()} <br>
        Date de naissance : ${patient.getDob()} <br>
        Medecin traitant : ${patient.getMedecinAttitre().getNom()}<br>
    </p>
    
</body>
</html>