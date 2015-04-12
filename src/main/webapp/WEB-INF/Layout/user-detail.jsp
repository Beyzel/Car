<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@include file="standartLibs.jsp" %>

    <title>Car School</title>
</head>
<body>
<div class="container">

    <%@include file="menu.jsp" %>

    <c:forEach var="users" items="${user}">
        <h1> ${users.login}</h1>
    </c:forEach>

    <div style="text-align: center;">
        <%@include file="footer.jsp" %>
    </div>
</div>
<!-- /container -->
</body>
</html>
