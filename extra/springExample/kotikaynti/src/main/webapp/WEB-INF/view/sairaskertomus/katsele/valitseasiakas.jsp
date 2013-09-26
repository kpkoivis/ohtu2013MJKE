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
        
        <h2>Valitse asiakas, jonka kertomusta katsellaan</h2>
        <form:form action="${pageContext.request.contextPath}/sairaskertomus_katsele_asiakkaan" method="GET">
            Valitse asiakas:
            <select name="asiakasId">
                <c:forEach var="asiakas" items="${asiakkaat}">

                    <option value="${asiakas.id}">${asiakas.tunnus}</option>
                </c:forEach>
            </select>
            <input type="submit">
        </p>
        </form:form>
        
        <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a></p>
    </body>
</html>
