<%@ page import="java.sql.Blob" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="standartLibs.jsp" %>

    <link rel="stylesheet" href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">

    <title></title>
</head>
<body>

    <div class="container">
        <input type="hidden" class="question-length" value="${questionLength}"/>
        <input type="hidden" class="testType" value="${testType}"/>
        <h4 id="question-number"></h4>
        <br><br>
        <c:forEach var="question" items="${questions}" varStatus="vs">
            <div class="col-md-8 col-md-offset-2 question<c:out value="${vs.index}"/> hidden">

                <c:if test="${not empty question.image}">
                    <img src="/image/${question.question_id}">
                </c:if>

                <h4 class="question-text">${question.question}</h4>

                <c:forEach var="answer" items="${question.answers}">
                    <div class="radio">
                        <label>
                            <input type="radio" name="radio-question" value="<c:out value="${answer.answer_id}"/>">
                            <div class="alert alert-info first-ans" role="alert">${answer.answerText}</div>
                            <input type="hidden" class="answerCorrect" value="${answer.correct}"/>
                        </label>
                    </div>
                </c:forEach>

                <input type="button" disabled class="btn btn-primary ans-button" value="Ответить"/>
                <input type="button" class="btn btn-danger wrong-ans-button hidden" value="Следующий вопрос"/>

                <br><br>

                <div class="wrong-ans-text hidden">
                    <h4>Ошибка!</h4>
                    ${question.help}
                </div>
            </div>
        </c:forEach>

        <div class="col-lg-6 col-lg-offset-3 donut-panel hidden">
            <div class="content-panel">
                <h3 align="center" class="finish-text"></h3>
                <p align="center"><a href="/test">Перейти к другим вопросам</a></p>
                <div class="panel-body">
                    <div id="hero-donut" class="graph"></div>
                </div>
            </div>
        </div>
    </div>

    <script src="<c:url value="/resources/js/testForm.js"/>"></script>

    <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
</body>
</html>
