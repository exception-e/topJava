<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<a href="meals?action=insert">Add Meal</a>
<table border="1">
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>
    </tr>
<jsp:useBean id="meals" scope="request" type="java.util.List"/>
<c:forEach var="meal" items="${meals}">
    <tr  style = "color:${meal.excess ? 'red':'green'}">
        <td><fmt:parseDate value="${meal.dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
            <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTime }" /></td>
        <td>${meal.description}</td>
        <td>${meal.calories}</td>
        <td><a href="meals?action=edit">Add Meal</a></td>
        <td><a href="meals?action=delete">Delete Meal</a></td>
    </tr>
        </c:forEach>
</table>
</body>
</html>