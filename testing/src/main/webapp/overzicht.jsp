<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Overzicht</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <p>Terug naar <a href="index.html">Home</a></p>
    <c:choose>
        <c:when test="${not empty meals}">
            <table>
                <tr>
                    <th>Titel</th>
                    <th>Categorie</th>
                    <th>Vegan</th>
                    <th>Allergieen</th>
                    <th>prijs</th>
                </tr>
                <c:forEach items="${meals}" var="meal">
                    <tr>
                        <td>${meal.titel}</td>
                        <td>${meal.categorie}</td>
                        <td>${meal.vegan}</td>
                        <td>${meal.allergie}</td>
                        <td>${meal.prijs}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p><em>Nog geen maaltijden</em></p>
        </c:otherwise>
    </c:choose>


</div>

</body>
</html>
