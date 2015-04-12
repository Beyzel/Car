<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/libs/css/lineicons/style.css"/>">

    <title></title>
</head>
<body>
<div class="container">
    <h2 style="text-align: center">Добро пожаловать на сайт подготовки к экзамену ГИБДД</h2>
    <br>
    <h4 style="text-align: center">Выберите категорию</h4>

    <div class="row">
        <div class="col-lg-6 col-lg-offset-3 main-chart">

            <div class="row mtbox">

                <a href="/rule">
                    <div class="col-md-5 col-sm-5 col-md-offset-1 box0">
                        <div class="box1">
                            <span class="li_note"></span>

                            <h3>Правила</h3>
                        </div>
                        <p>Изучить правила.</p>
                    </div>
                </a>

                <security:authorize access="!hasRole('ROLE_ADMIN')">
                    <a href="/test">
                        <div class="col-md-5 col-sm-5 box0">
                            <div class="box1">
                                <span class="li_pen"></span>

                                <h3>Тесты</h3>
                            </div>
                            <p>Тренироватся на тестах.<br>(Войдите в систему, чтобы видеть статистику тестирований)</p>
                        </div>
                    </a>
                </security:authorize>

            </div>
        </div>
    </div>
</div>

</body>
</html>
