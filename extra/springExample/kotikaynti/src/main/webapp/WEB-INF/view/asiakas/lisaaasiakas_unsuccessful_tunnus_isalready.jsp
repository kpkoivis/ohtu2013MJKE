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
            <h2>Asiakkaan rekisteröiminen epäonnistui</h2>
            
            <p>Asiakkaan rekisteröiminen epäonnistui, koska tunnus oli jo olemassa.</p>
        <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a></p>
    </body>
</html>
