<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kotikäynnin kirjaaminen sairaskertomukseen</title>
    </head>
    <body>
        <h1>Kotikäynnin kirjaaminen sairaskertomukseen</h1>

        <h2>Kotikäynnin kirjaaminen onnistui</h2>
        <table border="1">
            <tr><table border="1">
                <tr><td>Ajanvarausaika</td><td>Asiakas</td><td>Lääkäri</td><td>Varauksen syy</td></tr>
                <tr><td>${kertomus.ajanvaraus.aloitusAika}</td><td>${kertomus.ajanvaraus.asiakas.tunnus} (${kertomus.ajanvaraus.asiakas.etunimi} ${kertomus.ajanvaraus.asiakas.sukunimi}</td><td>${kertomus.ajanvaraus.laakari.tunnus} (${kertomus.ajanvaraus.laakari.etunimi} ${ketomus.ajanvaraus.laakari.sukunimi}</td><td>${kertomus.ajanvaraus.varausSyy}</td></tr> 
            </table></tr>
        <tr><table border="1">
            <tr><td>${kertomus.kayntiTeksti}</td></tr>
        </table></tr>
</table>

<p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a></p>
</body>
</html>
