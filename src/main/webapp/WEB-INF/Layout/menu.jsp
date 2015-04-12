<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<head>
    <title></title>
</head>
<body>
<!-- Static navbar -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index">Car School</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/index">Главная</a></li>

                <security:authorize access="!hasRole('ROLE_ADMIN')">
                    <li><a href="/test">Тесты</a></li>
                </security:authorize>

                <li><a href="/rule">Правила</a></li>

                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/user">Пользователи</a></li>
                </security:authorize>

                <security:authorize access="!hasRole('ROLE_ADMIN') && isAuthenticated()">
                    <li><a href="/ticketStatistic">Статистика по билетам</a></li>
                    <li><a href="/topicStatistic">Статистика по темам</a></li>
                </security:authorize>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <security:authorize access="!isAuthenticated()">
                    <li><a href="/register">Регистрация</a></li>
                    <li><a href="/login">Вход</a></li>
                </security:authorize>

                <security:authorize access="isAuthenticated()">
                    <li><a href="/logout">Выход</a></li>
                </security:authorize>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
    <!--/.container-fluid -->
</nav>
</body>
</html>
