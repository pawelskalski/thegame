<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 06.09.18
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>Choose hero for this adventure</p>
<p>Your foe is ${urFoe}, so choose wisely</p>
<form:form method="post" modelAttribute="UserHeroes">
    <form:select path="name" items="${allHeroesNames}"/> <br>
    <form:errors path="*"/>
    <input type="submit" value="Create user">
</form:form>




</body>
</html>
