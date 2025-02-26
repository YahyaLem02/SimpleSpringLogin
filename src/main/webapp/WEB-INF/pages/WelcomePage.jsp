<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bienvenue</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
            width: 80%;
            margin: 30px auto;
        }
        h2 {
            text-align: center;
            color: #273136;
        }
        .welcome-message {
            font-size: 20px;
            color: #273136;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f49e38;
            color: white;
        }
        .table-container {
            overflow-x: auto;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 15px;
            color: #273136;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="container">
    <!-- Message de bienvenue -->
    <h2>Bienvenue</h2>
    <p class="welcome-message">Bonjour, ${username}! Bienvenue sur votre espace.</p>

    <!-- Table des utilisateurs -->
    <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>Nom</th>
                <th>Email</th>
                <th>Mot de Passe</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Lien de déconnexion -->
    <a href="/logout">Se déconnecter</a>
</div>

</body>
</html>
