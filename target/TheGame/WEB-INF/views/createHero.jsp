<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 05.09.18
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminAddProject</title>
</head>
<body>
<form:form method="post" modelAttribute="UserHeroes">
    Name your hero: <form:input path="name"/> <br>
    Pick class
    <form:select path="heroClass">
        <form:option value="knight" label="Knight"/>
        <form:option value="rogue" label="Rogue"/>
        <form:option value="wizard" label="Wizard"/>
    </form:select><br>
    <form:input path="ownerId"/>
    <input type="submit" value="Create user">
    <form:errors path="*"/>
</form:form>


</body>
</html>
