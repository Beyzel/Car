<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="standartLibs.jsp" %>

    <title>Тесты</title>
</head>
<body>
<div class="container">

    <%@include file="menu.jsp" %>
    <div class="container">
        <h3>Правила:</h3>

        <div class="list-group">
            <a href="/rule/general" class="list-group-item">1. Загальні положення</a>
            <a href="/rule/driverRights" class="list-group-item">2. Обов'язки і права водіїв механічних транспортних
                засобів</a>
            <a href="/rule/vehiclesWithSpecialSignal" class="list-group-item">3. Рух транспортних засобів із
                спеціальними сигналами</a>
            <a href="/rule/pedestriansRight" class="list-group-item">4. Обов'язки і права пішоходів</a>
            <a href="/rule/passengerRights" class="list-group-item">5. Обов'язки і права пасажирів</a>
            <a href="/rule/requirementsForCyclists" class="list-group-item">6. Вимоги до велосипедистів</a>
            <a href="/rule/requirementsForAnimalsMushers" class="list-group-item">7. Вимоги до осіб, які керують гужовим
                транспортом, і погоничів тварин</a>
            <a href="/rule/trafficRegulation" class="list-group-item">8. Регулювання дорожнього руху</a>
            <a href="/rule/warningSignals" class="list-group-item">9. Попереджувальні сигнали</a>
            <a href="/rule/startMovement" class="list-group-item">10. Початок руху та зміна його напрямку</a>
            <a href="/rule/locationOnTheRoad" class="list-group-item">11. Розташування транспортних засобів на
                дорозі</a>
        </div>
    </div>
    <br><br>

    <div style="text-align: center;">
        <%@include file="footer.jsp" %>
    </div>
</div>
<!-- /container -->
</body>
</html>
