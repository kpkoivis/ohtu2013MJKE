<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kotikäyntitoiminnot</title>
    </head>
    <body>
        <h1>Kotikäyntisovelluksen toiminnot:</h1>
        <h2>Lääkäritoiminnot:</h2>
        <p><a href="${pageContext.request.contextPath}/lisaalaakari">Uuden lääkärin rekiströityminen</a></p>
        <p><a href="${pageContext.request.contextPath}/lisaaaika">Lääkärin kotikäyntiajan lisääminen</a></p>
        <p><a href="${pageContext.request.contextPath}/kirjaasairaskertomus">Sairaskertomusmerkinnän tallentaminen</a></p>
       
        <h2>Asiakastoiminnot:</h2>
        <p><a href="${pageContext.request.contextPath}/lisaaasiakas">Uuden asiakkaan rekisteröityminen</a></p>
        <p><a href="${pageContext.request.contextPath}/varaaaika">Ajanvarausajan varaaminen</a></p>
        <p><a href="${pageContext.request.contextPath}/katsosairaskertomus">Sairaskertomusmerkintöjen katseleminen</a></p>
    
        <h2>Ylläpitäjän toiminnot:</h2>
        <p><a href="${pageContext.request.contextPath}/listaalaakarit">Näytä rekisteröidyt lääkärit</a></p>
        <p><a href="${pageContext.request.contextPath}/listaaasiakkaat">Näytä rekisteröidyt asiakkaat</a></p>

    </body>
</html>
