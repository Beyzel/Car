<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="standartLibs.jsp" %>

    <title>Тест по билету #${ticketId}</title>
</head>
<body>
<input type="hidden" class="testId" value="${ticketId}"/>

<div class="container">

    <%@include file="menu.jsp" %>
    <%@include file="testForm.jsp" %>
    <br><br>

    <div style="text-align: center;">
        <%@include file="footer.jsp" %>
    </div>
</div>

</body>
</html>
