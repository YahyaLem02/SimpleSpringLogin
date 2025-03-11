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
        tr:nth-child(even) {
            background-color: #f8f8f8;
        }
        .table-container {
            overflow-x: auto;
        }
        .logout-btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #f49e38;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-top: 20px;
        }
        .logout-btn:hover {
            background-color: #e48928;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Bienvenue</h2>
    <p class="welcome-message">Bonjour, ${username}! Bienvenue sur votre espace.</p>

    <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>Nom d'utilisateur</th>
                <th>Email</th>
                <th>Mot de passe</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.displayPassword}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div style="text-align: center;">
        <a href="/logout" class="logout-btn">Se déconnecter</a>
    </div>
</div>
</body>
</html>