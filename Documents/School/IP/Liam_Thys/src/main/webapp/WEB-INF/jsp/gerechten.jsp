<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
    <h1><spring:message code="label.title"/></h1>
    <c:choose>
        <c:when test="${errors != null}">
            <c:forEach items="${errors}" var="error">
                <p>${error}</p>
            </c:forEach>
        </c:when>

        <c:otherwise>
            <table>
                <th><spring:message code="label.title"/></th>
                <th><spring:message code="label.price"/></th>
                <th>Type</th>
                <c:forEach items="${gerechten}" var="gerecht">
                    <tr>
                        <td>${gerecht.description}</td>
                        <td>${gerecht.price}</td>
                        <td>${gerecht.type}</td>
                    </tr>
                </c:forEach>

            </table>
            <a href="/gerechten/change"><spring:message code="label.change"/></a>
        </c:otherwise>
    </c:choose>
</main>
</body>
</html>