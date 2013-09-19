<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kotikäyntiajan varaaminen</title>
    </head>
    <body>
        <h1>Kotikäyntiajan varaaminen</h1>

        <h2>Vapaana olevat ajanvarausajat:</h2>
        <table border="1">
            <tr><td>Tunniste</td><td>Alkamisaika</td><td>Kesto</td><td>Lääkäri</td></tr>


            <c:forEach var="aika" items="${ajat}">
                <tr><td>${aika.idajanvarausaika}</td><td>${aika.aloitusAika}</td><td>${aika.kesto}</td><td>${aika.laakari.tunnus} (${aika.laakari.etunimi} ${aika.laakari.sukunimi})</td></tr>

            </c:forEach>
        </table>
        
        <h2>Varaa yksi ajanvarausaika:</h2>
        <form:form action="${pageContext.request.contextPath}/varaaaika" method="POST">
        <p>Ajanvarausajan tunniste:
            <select name="aikaId">
                
                    <c:forEach var="aika" items="${ajat}">
                        <option value="${aika.idajanvarausaika}">${aika.idajanvarausaika}</option>
                    </c:forEach>
            </select>

            Asiakkaan tunniste:
            <select name="asiakasId">
                <c:forEach var="asiakas" items="${asiakkaat}">

                    <option value="${asiakas.id}">${asiakas.tunnus}</option>
                </c:forEach>
            </select>
            Ajanvarauksen syy (oireet tms): <input name="syy" type="text"/>
            <input type="submit">
        </p>
        </form:form>
        
        <h2>Näytä omalääkärin vapaana olevat ajat:</h2>
        <form:form action="${pageContext.request.contextPath}/varaaaika_omalaakari" method="GET">
            Valitse asiakas:
            <select name="asiakasId">
                <c:forEach var="asiakas" items="${asiakkaat}">

                    <option value="${asiakas.id}">${asiakas.tunnus}</option>
                </c:forEach>
            </select>
            <input type="submit">
        </p>
        </form:form>
        
        <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a> (Varaamatta aikaa)</p>
    </body>
</html>
