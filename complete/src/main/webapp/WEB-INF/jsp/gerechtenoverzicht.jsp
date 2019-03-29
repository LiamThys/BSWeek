<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Umami</title>
    <jsp:include page="csslinks.jsp"/>
</head>
<body>
    <jsp:include page="nav.jsp"/>
<table>
    <tr>
        <th>Naam</th>
        <th>Prijs</th>
    </tr>
    <c:forEach var="gerecht" items="${gerechten}">
        <tr>
            <td>${gerecht.title}</td>
            <td>${gerecht.price}</td>
            <td><a href="/updateForm/${gerecht.title}">update</a></td>
            <td><a href="/deleteGerecht/${gerecht.title}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>