<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="standartLibs.jsp" %>

    <title>Статистика по темам</title>
</head>
<body>
<div class="container">
    <%@include file="menu.jsp" %>
    <div class="container">
        <c:forEach var="test" items="${userTests}" varStatus="vs">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Topic</th>
                    <th>Date</th>
                    <c:forEach var="userAnswer" items="${test.userAnswers}" varStatus="answerNum">
                        <th style="text-align: center">${answerNum.index}</th>
                    </c:forEach>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td width="30%">${test.userAnswers.get(0).question.topic.topicName}</td>
                    <td width="20%">${test.date}</td>
                    <c:forEach var="userAnswer" items="${test.userAnswers}">
                        <td align="center">
                            <c:choose>
                                <c:when test="${userAnswer.answer.correct}">
                                    +
                                </c:when>

                                <c:when test="${!userAnswer.answer.correct}">
                                    -
                                </c:when>
                            </c:choose>
                        </td>
                    </c:forEach>
                </tr>
                </tbody>
            </table>
        </c:forEach>
    </div>
    <br><br>

    <div style="text-align: center;">
        <%@include file="footer.jsp" %>
    </div>
</div>
</body>
</html>
