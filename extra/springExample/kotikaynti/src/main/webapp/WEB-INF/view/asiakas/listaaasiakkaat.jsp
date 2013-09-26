<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>                                                                                                                               
<%@page contentType="text/html" pageEncoding="UTF-8"%>                                                                                                                                        
<!DOCTYPE html>                                                                                                                                                                               
<html>                                                                                                                                                                                        
    <head>                                                                                                                                                                                    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">                                                                                                                   
        <title>Näytä rekisteröidyt asikakkaat</title>                                                                                                                                                            
    </head>                                                                                                                                                                                   
    <body>                                                                                                                                                                                    
        <h2>Rekisteröidyt asiakkaat:</h2>                                                                                                                                                                 
                                                                                                                                                                    
        <div>
            <table border="1">
                <tr><td>Tunnus</td><td>Nimi</td><td>Osoite</td><td>Omalääkäri</td></tr>
            <c:forEach var="asiakas" items="${asiakkaat}">                                                                                                                                       
                <tr><td>${asiakas.tunnus}</td><td>${asiakas.etunimi} ${asiakas.sukunimi}</td><td>${asiakas.osoite}</td><td>${asiakas.omalaakari}</td></tr>                                                                                                                      
            </c:forEach>
            </table>
        </div>                                                                                                                                                                                

        <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a></p>
    </body>
</html>
