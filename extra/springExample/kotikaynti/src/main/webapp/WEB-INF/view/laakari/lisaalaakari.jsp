
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rekisteröi uusi lääkäri</title>
    </head>
    <body>
        <h1>Rekisteröi uusi lääkäri</h1>
        <form:form commandName="laakari" action="${pageContext.request.contextPath}/lisaalaakari" method="POST">
            <table border="0">
                <tr><td>Tunnus:</td><td><form:input path="tunnus" /></td><td><form:errors path="tunnus" /><br/></td></tr>
                <tr><td>Etunimi:</td><td><form:input path="etunimi" /></td><td><form:errors path="etunimi" /><br/></td></tr>
                <tr><td>Sukunimi:</td><td><form:input path="sukunimi" /></td><td><form:errors path="sukunimi" /><br/></td></tr>
                <tr><td>sv-numero:</td><td><form:input path="svnumero" /></td><td><form:errors path="svnumero" /><br/></td></tr>
            </table>
            <input type="submit">
        </form:form>
            <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a> (Rekisteröimättä uutta lääkäriä)</p>
    </body>
</html>