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
    <title>Add Gerecht</title>
</head>
<body>

<c:if test="${errors != null}">
    <c:forEach items="${errors}" var="error">
        <p>${error}</p>
    </c:forEach>
</c:if>

<form action="/gerechten/add" method="post">

    <p>Voeg gerecht toe</p>

    <label for="description">Beschrijving</label>
    <input id="description" type="text" placeholder="Beschrijving" name="description">

    <label for="price">Prijs</label>
    <input id="price" type="text" placeholder="Prijs" name="price">

    <label for="type">Type</label>
    <select name="type" id="type">
        <option>SOEP</option>
        <option>DAGSCHOTEL</option>
        <option>VEGGIE</option>
    </select>

    <input type="submit" value="Voeg toe">

</form>
</body>
</html>