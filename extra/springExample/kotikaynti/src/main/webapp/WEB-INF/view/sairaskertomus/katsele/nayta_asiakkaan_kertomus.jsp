<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sairaskertomuksen katselu</title>
    </head>
    <body>
        <h1>Sairaskertomuksen katselu</h1>

        <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a></p>

        <h2>Asiakkaan ${asiakas.tunnus} (${asiakas.etunimi} ${asiakas.sukunimi}) sairaskertomus:</h2>

        <c:forEach var="kertomus" items="${sairaskertomus}">

            <table border="1">
                <tr><table border="1">
                    <tr><td>Ajanvarausaika</td><td>Lääkäri</td><td>Varauksen syy</td></tr>
                    <tr><td>${kertomus.ajanvaraus.aloitusAika}</td><td>${kertomus.ajanvaraus.laakari.tunnus} (${kertomus.ajanvaraus.laakari.etunimi} ${ketomus.ajanvaraus.laakari.sukunimi}</td><td>${kertomus.ajanvaraus.varausSyy}</td></tr> 
                </table></tr>
            <tr><table border="1">
                <tr><td>Kertomusteksti</td></tr>
                <tr><td>${kertomus.kayntiTeksti}</td></tr>
            </table></tr>

    </table><br><br>
</c:forEach>

<p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a></p>
</body>
</html>
