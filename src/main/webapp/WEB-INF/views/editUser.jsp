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
<form:form method="post" modelAttribute="User">
    Id:<form:input path="id"/> <br>
    Email<form:input path="email" /> <br>
    Leader Name:<form:input path="leaderName"/> <br>
    Password:<form:input path="password"/> <br>
    <input type="submit" value="Change User">
    <form:errors path="*"/>
</form:form>


</body>
</html>
