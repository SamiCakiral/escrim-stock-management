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
        Patient : ${patient.nom} ${patient.prenom} <br>
        Date de naissance : ${patient.dob} <br>
        Medecin traitant : ${patient.getMedecinAttitre}<br>
    </p>
    
</body>
</html>