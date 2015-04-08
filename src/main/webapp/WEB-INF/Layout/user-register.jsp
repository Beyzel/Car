<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<%@include file="standartLibs.jsp" %>

<title>Car School</title>

<body>
<div class="container">
    <%@include file="menu.jsp" %>
    <%--Login--%>
    <form:form commandName="user" cssClass="form-horizontal">
        <div class="form-group">
            <label for="login" class="col-sm-2 control-label">Login: </label>

            <div class="col-sm-10">
                <form:input path="login" cssClass="form-control"/>
            </div>
        </div>
        <%--Email--%>
        <div class="form-group">
            <label for="mail" class="col-sm-2 control-label">Email: </label>

            <div class="col-sm-10">
                <form:input path="mail" cssClass="form-control"/>
            </div>
        </div>
        <%--Password--%>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password: </label>

            <div class="col-sm-10">
                <form:password path="password" cssClass="form-control"/>
            </div>
        </div>

        <%--Register--%>
        <div class="form-group">
            <div class="col-sm-2">
                <input type="submit" value="Register" class="btn btn-lg btn-primary"/>
            </div>
        </div>
    </form:form>
    <div style="text-align: center;">
        <%@include file="footer.jsp" %>
    </div>
</div>
<!-- /container -->
</body>
</html>
