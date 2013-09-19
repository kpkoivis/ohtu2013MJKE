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

        <h2>Ajanvaraukset (kotikäynnit):</h2>
        <table border="1">
            <tr><td>Tunniste</td><td>Alkamisaika</td><td>Lääkäri</td><td>Asiakas</td></tr>


            <c:forEach var="aika" items="${ajanvarausajat}">
                <tr><td>${aika.idajanvarausaika}</td><td>${aika.aloitusAika}</td><td>${aika.laakari.tunnus} (${aika.laakari.etunimi} ${aika.laakari.sukunimi})</td><td>${aika.asiakas.tunnus} (${aika.asiakas.etunimi} ${aika.asiakas.sukunimi})</td></tr>

            </c:forEach>
        </table>
        
        <h2>Valitse kirjattavan kotikäynnin tunniste:</h2>
        <form:form action="${pageContext.request.contextPath}/kirjaasairaskertomus" method="POST">
        <p>Ajanvarausajan tunniste:
            <select name="aikaId">
                
                    <c:forEach var="aika" items="${ajanvarausajat}">
                        <option value="${aika.idajanvarausaika}">${aika.idajanvarausaika}</option>
                    </c:forEach>
            </select>

            <input type="submit">
        </p>

        </form:form>
        <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a> (Kirjaamatta käyntiä)</p>
    </body>
</html>
