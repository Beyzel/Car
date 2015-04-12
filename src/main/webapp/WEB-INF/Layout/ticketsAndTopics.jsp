<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h3>Билеты:</h3>

<div class="list-group">
    <c:forEach var="ticket" items="${tickets}">
        <a href="/ticket/${ticket.ticket_id}" class="list-group-item">${ticket.ticket_id}</a>
    </c:forEach>
</div>

<br><br>

<h3>Темы:</h3>

<div class="list-group">

    <c:forEach var="topic" items="${topics}">
        <a href="/topic/${topic.topic_id}" class="list-group-item">${topic.topicName}</a>
    </c:forEach>

</div>

</body>
</html>
