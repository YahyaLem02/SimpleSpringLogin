<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Inscription</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
            width: 400px;
        }
        h2 {
            text-align: center;
            color: #273136;
        }
        input[type="text"], input[type="email"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 16px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #f49e38;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #e0892f;
        }
        .error {
            color: red;
            text-align: center;
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
    <h2>Créer un compte</h2>

    <!-- Afficher les messages d'erreur -->
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>

    <!-- Formulaire d'inscription -->
    <form action="/register" method="post">
        <label for="username">Nom complet</label>
        <input type="text" id="username" name="username" placeholder="Votre nom complet" required>

        <label for="email">Adresse e-mail</label>
        <input type="email" id="email" name="email" placeholder="Votre e-mail" required>

        <label for="password">Mot de passe</label>
        <input type="password" id="password" name="password" placeholder="Votre mot de passe" required>

        <label for="passwordConfirm">Confirmer le mot de passe</label>
        <input type="password" id="passwordConfirm" name="passwordConfirm" placeholder="Confirmer votre mot de passe" required>

        <input type="submit" value="S'inscrire">
    </form>

    <a href="/">Retour à l'accueil</a>
</div>

</body>
</html>
