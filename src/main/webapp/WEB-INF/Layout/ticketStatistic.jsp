<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="standartLibs.jsp" %>

    <title>Статистика по билетам</title>
</head>
<body>
<div class="container">
    <%@include file="menu.jsp" %>
    <div class="container">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Ticket</th>
                <th>Date</th>
                <th>1</th>
                <th>2</th>
                <th>3</th>
                <th>4</th>
                <th>5</th>
                <th>6</th>
                <th>7</th>
                <th>8</th>
                <th>9</th>
                <th>10</th>
                <th>11</th>
                <th>12</th>
                <th>13</th>
                <th>14</th>
                <th>15</th>
                <th>16</th>
                <th>17</th>
                <th>18</th>
                <th>19</th>
                <th>20</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="test" items="${userTests}" varStatus="vs">
                <tr>
                    <td>${test.userAnswers.get(0).question.ticket_id}</td>
                    <td>${test.date}</td>
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
            </c:forEach>
            </tbody>
        </table>
    </div>
    <br><br>

    <div style="text-align: center;">
        <%@include file="footer.jsp" %>
    </div>
</div>
</body>
</html>
