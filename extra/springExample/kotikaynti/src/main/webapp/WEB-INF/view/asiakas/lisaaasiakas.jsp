
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rekisteröi uusi asiakas</title>
    </head>
    <body>
        <h1>Rekisteröi uusi asiakas</h1>
        <form:form commandName="asiakas" action="${pageContext.request.contextPath}/lisaaasiakas" method="POST">
            <table border="0">
                <tr><td>Tunnus:</td><td><form:input path="tunnus" /></td><td><form:errors path="tunnus" /><br/></td></tr>
                <tr><td>Etunimi:</td><td><form:input path="etunimi" /></td><td><form:errors path="etunimi" /><br/></td></tr>
                <tr><td>Sukunimi:</td><td><form:input path="sukunimi" /></td><td><form:errors path="sukunimi" /><br/></td></tr>
                <tr><td>Osoite:</td><td><form:input path="osoite" /></td><td><form:errors path="osoite" /><br/></td></tr>
            </table>
            <p>Valitse omalääkäri:
                <select name="laakariId">
                    <option value="0">Ei omalääkäriä</option>
                <c:forEach var="laakari" items="${laakarit}">
                    <option value="${laakari.id}">${laakari.tunnus}</option>
                </c:forEach>
            </select>
            </p><input type="submit">
        </form:form>
            <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a> (Rekisteröimättä uutta asiakasta)</p>
    </body>
</html>
