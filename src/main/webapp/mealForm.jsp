<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 11.02.2024
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Add meal</title>
</head>
<body>
<script>
    $(function() {
        $('input[name=dob]').datepicker();
    });
</script>
<form method="post" action="meals" name="mealForm">
    Date Time: <input type="text" name="dateTime"
    value="<jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.MealTo"/>
    <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${meal.dateTime}"/>" />
    <br />
    ID : <input type="text" readonly="readonly" name="id"
    value="<c:out value="${meal.id}" />" />
    <br />
    Description :
    <label>
    <input
    type="text" name="description"
    value="<c:out value="${meal.description}" />" />
    </label>
    <br />
    Calories : <input
    type="text" name="calories"
    value="<c:out value="${meal.calories}" />" />
    <br />
    <input type="submit" value="Submit"/>
    </form>
</body>
</html>
