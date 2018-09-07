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
    Choose id of hero u want to delete<form:input path="id"/> <br>
    <input type="submit" value="Create user">
    <form:errors path="*"/>
</form:form>


</body>
</html>
