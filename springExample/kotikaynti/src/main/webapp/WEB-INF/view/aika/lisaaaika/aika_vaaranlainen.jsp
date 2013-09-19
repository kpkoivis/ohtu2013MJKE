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
            <h2>Uuden ajanvarausajan luominen epäonnistui</h2>
            
            <p>Uuden ajanvarausajan luominen epäonnistui, koska annetut arvot eivät muodostaneet validia ajankohtaa.
            (Esim helmikuussa ei voilla olla ajanvarausta 30 päivälle)</p>
        <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a></p>
    </body>
</html>
