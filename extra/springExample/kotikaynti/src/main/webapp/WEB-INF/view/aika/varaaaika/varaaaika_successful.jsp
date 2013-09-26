<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>                                                                                                                               
<%@page contentType="text/html" pageEncoding="UTF-8"%>                                                                                                                                        
<!DOCTYPE html>                                                                                                                                                                               
<html>                                                                                                                                                                                        
    <head>                                                                                                                                                                                    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">                                                                                                                   
        <title>Kotikäyntiajan varaaminen</title>                                                                                                                                                            
    </head>                                                                                                                                                                                   
    <body>                                                                                                                                                                                                                                                                                                                                                    
        <div>
            <h2>Kotikäyntiajan varaaminen onnistui</h2>
            <table border="1">
                <tr><td>Ajanvarausaika</td><td>Potilas</td><td>Lääkäri</td><td>Varauksen syy</td></tr>
                <tr><td>${ajanvarausaika.aloitusAika}</td><td>${ajanvarausaika.asiakas.tunnus} (${ajanvarausaika.asiakas.etunimi} ${ajanvarausaika.asiakas.sukunimi}</td><td>${ajanvarausaika.laakari.tunnus} (${ajanvarausaika.laakari.etunimi} ${ajanvarausaika.laakari.sukunimi}</td><td>${ajanvarausaika.varausSyy}</td></tr> 
            </table>
        </div>
            

        <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a></p>
    </body>
</html>
