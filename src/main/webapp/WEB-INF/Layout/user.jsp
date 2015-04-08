<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="standartLibs.jsp" %>

    <title>Car School</title>
</head>
<body>
<div class="container">

    <%@include file="menu.jsp" %>
    <table class="table table-bordered table-hover table-striped">
        <tr>
            <th>Login</th>
            <th>Mail</th>
        </tr>

        <c:forEach var="users" items="${user}">
            <tr>
                <td><a href="/user/${users.user_id}">
                        ${users.login}
                </a>
                </td>
                <td>${users.mail}</td>
            </tr>
        </c:forEach>
    </table>

    <div style="text-align: center;">
        <%@include file="footer.jsp" %>
    </div>
</div>
<!-- /container -->
</body>
</html>
