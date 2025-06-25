<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Supprimer une voiture</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Supprimer une voiture</h2>

    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Êtes-vous sûr de vouloir supprimer cette voiture ?</h5>

            <div class="mb-3">
                <strong>Marque:</strong> ${voiture.marque}<br>
                <strong>Modèle:</strong> ${voiture.modele}<br>
                <strong>Année:</strong> ${voiture.annee}<br>
            </div>

            <form action="/voitures/delete/${voiture.id}" method="POST">
                <button type="submit" class="btn btn-danger">Confirmer la suppression</button>
                <a href="/cars" class="btn btn-secondary">Annuler</a>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>