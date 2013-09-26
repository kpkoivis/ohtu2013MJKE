<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>                                                                                                                               
<%@page contentType="text/html" pageEncoding="UTF-8"%>                                                                                                                                        
<!DOCTYPE html>                                                                                                                                                                               
<html>                                                                                                                                                                                        
    <head>                                                                                                                                                                                    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">                                                                                                                   
        <title>Luo uusi ajanvarausaika</title>                                                                                                                                                            
    </head>                                                                                                                                                                                   
    <body>                                                                                                                                                                                                                                                                                                                                                    
        <div>
            <h2>Uuden ajanvarausajan luominen onnistui</h2>
            <table border="1">
                <tr><td>Lääkäri</td><td>Alkamisaika</td><td>Kesto</td></tr>
                <tr><td>${ajanvarausaika.laakari.tunnus} (${ajanvarausaika.laakari.etunimi} ${ajanvarausaika.laakari.sukunimi})</td><td>${ajanvarausaika.aloitusAika}</td><td>${ajanvarausaika.kesto}</td></tr> 
            </table>
        </div>
            

        <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a></p>
    </body>
</html>
