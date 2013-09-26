<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>                                                                                                                               
<%@page contentType="text/html" pageEncoding="UTF-8"%>                                                                                                                                        
<!DOCTYPE html>                                                                                                                                                                               
<html>                                                                                                                                                                                        
    <head>                                                                                                                                                                                    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">                                                                                                                   
        <title>Rekisteröi uusi lääkäri</title>                                                                                                                                                            
    </head>                                                                                                                                                                                   
    <body>                                                                                                                                                                                                                                                                                                                                                    
        <div>
            <h2>Lääkärin rekisteröiminen onnistui</h2>
            <table border="1">
                <tr><td>Tunnus</td><td>Lääkärin nimi</td><td>SV-numero</td></tr>
                <tr><td>${laakari.tunnus}</td><td>${laakari.etunimi} ${laakari.sukunimi}</td><td>${laakari.svnumero}</td></tr> 
            </table>
        </div>
            

        <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a></p>
    </body>
</html>
