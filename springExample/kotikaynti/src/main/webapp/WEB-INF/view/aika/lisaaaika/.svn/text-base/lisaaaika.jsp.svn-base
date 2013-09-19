
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Luo uusi ajanvarausaika</title>
    </head>
    <body>
        <h1>Luo uusi ajanvarausaika</h1>
        <form:form commandName="aika" action="${pageContext.request.contextPath}/lisaaaika" method="POST">
            <p>Valitse lääkäri:
                <select name="laakariId">
                <c:forEach var="laakari" items="${laakarit}">
                    <option value="${laakari.id}">${laakari.tunnus}</option>
                </c:forEach>
            </select>
            </p>

            <table border="0">     
                <tr><td>Päivä (1-31):</td><td><form:input path="paiva" /></td><td><form:errors path="paiva" /><br/></td></tr>
                <tr><td>Kuukausi (1-12):</td><td><form:input path="kuukausi" /></td><td><form:errors path="kuukausi" /><br/></td></tr>
                <tr><td>Vuosi (YYYY):</td><td><form:input path="vuosi" /></td><td><form:errors path="vuosi" /><br/></td></tr>
                <tr><td>Tunti (0-23):</td><td><form:input path="tunti" /></td><td><form:errors path="tunti" /><br/></td></tr>
                <tr><td>Minuutti (0-59):</td><td><form:input path="minuutti" /></td><td><form:errors path="minuutti" /><br/></td></tr>
                <tr><td>Kesto (minuuteissa 10-99):</td><td><form:input path="kesto" /></td><td><form:errors path="kesto" /><br/></td></tr>
            </table>
            <input type="submit">
            
            <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a> (Luomatta uutta aikaa)</p>
        </form:form>
    </body>
</html>
