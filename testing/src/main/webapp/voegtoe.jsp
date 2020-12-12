<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add meal</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <p>Terug naar <a href="index.html">Home</a></p>
    <form novalidate="novalidate" action="Servlet?command=AddMeal" method="post"></p>
        <p><label for="titel">Titel van het gerecht:</label><input type="text" id="titel" name="titel"></p>
        <p><label for="categorie">Categorie van het gerecht:</label><input type="text" id="categorie" name="categorie"></p>
        <p><label for="vegan">Is het gerecht vegan?</label><input type="checkbox" id="vegan" name="vegan"></p>
        <p><label for="allergie">Bevat het gerecht mogelijke allergieen?</label><input type="text" id="allergie" name="allergie"></p>
        <p><label for="prijs">Prijs van het gerecht:</label><input type="text" id="prijs" name="prijs"></p>
        <p>
            <button type="submit" id="submit">Add meal</button>
        </p>
    </form>
</div>
</body>
</html>
