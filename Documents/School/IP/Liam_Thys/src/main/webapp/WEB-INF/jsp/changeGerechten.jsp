<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="nl-be">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../resources/css/reset.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <title>Overzicht | Gerechten App</title>
</head>
<body>
<main>
    <h1>dishes</h1>
    <c:choose>
        <c:when test="${errors != null}">
            <c:forEach items="${errors}" var="error">
                <p>${error}</p>
            </c:forEach>
        </c:when>

        <c:otherwise>
            <table>
                <th>Id</th>
                <th>Dishes</th>
                <th>Price</th>
                <th>Type</th>
                <th>Update</th>
                <th>Delete</th>
                <c:forEach items="${gerechten}" var="gerecht">
                    <tr>
                        <td>${gerecht.id}</td>
                        <td>${gerecht.description}</td>
                        <td>${gerecht.price}</td>
                        <td>${gerecht.type}</td>
                        <td><a href="/gerechten/update/${gerecht.id}">Update</a></td>
                        <td><a href="/gerechten/delete/${gerecht.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>

        </c:otherwise>
    </c:choose>
    <button><a href="/gerechten/add">Add dish</a></button>
</main>
</body>
</html>