<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>                                                                                                                               
<%@page contentType="text/html" pageEncoding="UTF-8"%>                                                                                                                                        
<!DOCTYPE html>                                                                                                                                                                               
<html>                                                                                                                                                                                        
    <head>                                                                                                                                                                                    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">                                                                                                                   
        <title>Rekisteröi uusi asiakas</title>                                                                                                                                                            
    </head>                                                                                                                                                                                   
    <body>                                                                                                                                                                                                                                                                                                                                                    
        <div>
            <h2>Asiakkaan rekisteröiminen onnistui</h2>
            <table border="1">
                <tr><td>Tunnus</td><td>Nimi</td><td>Osoite</td><td>Omalääkäri</td></tr>
                <tr><td>${asiakas.tunnus}</td><td>${asiakas.etunimi} ${asiakas.sukunimi}</td><td>${asiakas.osoite}</td><td>${asiakas.omalaakari.tunnus} (${asiakas.omalaakari.etunimi} ${asiakas.omalaakari.sukunimi})</td></tr> 
            </table>
        </div>
            

        <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a></p>
    </body>
</html>
