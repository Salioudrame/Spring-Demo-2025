<%@ page import="sn.esmt.demo2025.domain.Vehicule" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Ajout de Tailwind CSS via CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-8">
<div class="max-w-7xl mx-auto">
    <h1 class="text-4xl font-bold text-gray-800 mb-6">Cars</h1>
    <a href="/" class="inline-block bg-blue-600 text-white font-semibold py-2 px-4 rounded-md shadow hover:bg-blue-700 transition duration-200">
        Ajouter une voiture
    </a>

    <h2 class="text-2xl font-semibold text-gray-700 mb-4">Voiture:</h2>

    <div class="overflow-x-auto bg-white rounded-lg shadow">
        <table class="min-w-full table-auto">
            <thead class="bg-gray-50">
            <tr>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Matricule</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Marque</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Modele</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Année</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Carburant</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Couleur</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Type</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Action</th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
            <%
                List<Vehicule> cars = (List<Vehicule>) request.getAttribute("cars");
                for (Vehicule car : cars) {
            %>
            <tr class="hover:bg-gray-50">
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900"><%= car.getMatricule() %></td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900"><%= car.getMarque() %></td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900"><%= car.getModele() %></td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900"><%= car.getAnnee() %></td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900"><%= car.getCarburant() %></td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900"><%= car.getCouleur() %></td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900"><%= car.getType() %></td>
                <td class="px-6 py-4 whitespace-nowrap text-sm font-medium">
                    <a href="/voitures/delete/<%= car.getId() %>" class="text-red-600 hover:text-red-900">Supprimer</a>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>