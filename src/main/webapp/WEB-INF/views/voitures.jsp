<%@ page import="sn.esmt.demo2025.domain.Vehicule" %>
<%@ page import="java.util.List" %>
<html>
<body>
    <h1>Liste des voitures</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Matricule</th>
                <th>Marque</th>
                <th>Modèle</th>
                <th>Année</th>
                <th>Carburant</th>
                <th>Couleur</th>
                <th>Type</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Vehicule> cars = (List<Vehicule>) request.getAttribute("cars");
                for (Vehicule car : cars) {
            %>
            <tr>
                <td><%= car.getMatricule() %></td>
                <td><%= car.getMarque() %></td>
                <td><%= car.getModele() %></td>
                <td><%= car.getAnnee() %></td>
                <td><%= car.getCarburant() %></td>
                <td><%= car.getCouleur() %></td>
                <td><%= car.getType() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
