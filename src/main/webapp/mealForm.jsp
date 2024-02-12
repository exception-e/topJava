<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 11.02.2024
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Add meal</title>
</head>
<body>

<h3><a href="index.html">Home</a></h3>
<hr>
<h2>${param.action == 'insert' ? 'Create meal' : 'Edit meal'}</h2>
<jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo" scope="request"/>

<form method="post" action="meals" name="mealForm">
    Date Time:
    <input type="datetime-local" value="${meal.dateTime}" name="dateTime" required/>
    <br />
    ID :
    <input type="text" name="id" value="${meal.id}" />
    <br />
    Description :
    <input
    type="text" name="description" value="${meal.description}" />
    <br />
    Calories :
    <input
    type="text" name="calories" value="${meal.calories}" />
    <br />
    <button type="submit">Save</button>
    <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</body>
</html>
