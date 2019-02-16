<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Add feedback</title>
    <jsp:include page="csslinks.jsp"/>
</head>
<body>
<h1>Add gerecht</h1>
<c:if test="${errors!=null}">
    <div>
        <c:forEach items="${errors}" var="error">
            <p>${error.field}: ${error.defaultMessage}</p>
        </c:forEach>
    </div>
</c:if>

<form method="post" action="/updateGerecht/">
    <p>
        <label>Title</label>
        <input type="text" name="title" value="${gerecht.title}" readonly="readonly"/>
    </p>
    <p>
        <label>Price</label>
        <input type="text" name="price" value="${gerecht.price}"/>
    </p>
    <p>
        <input type="submit" value="Update" />
        <input type="reset" value="Reset" />
    </p>
</form>
</body>
</html>