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
        <div>
            <h2>Kotikäynnin kirjaaminen sairaskertomukseen</h2>
            <table border="1">
                <tr><td>Ajanvarausaika</td><td>Asiakas</td><td>Lääkäri</td><td>Varauksen syy</td></tr>
                <tr><td>${ajanvaraus.aloitusAika}</td><td>${ajanvaraus.asiakas.tunnus} (${ajanvaraus.asiakas.etunimi} ${ajanvaraus.asiakas.sukunimi}</td><td>${ajanvaraus.laakari.tunnus} (${ajanvaraus.laakari.etunimi} ${ajanvaraus.laakari.sukunimi}</td><td>${ajanvaraus.varausSyy}</td></tr> 
            </table>
        </div>
            <p>Kirjaus:</p>
                <form name="kirjaus" action="${pageContext.request.contextPath}/kirjaa" method="POST">
                <input type="hidden" name="aikaID" value="${ajanvaraus.idajanvarausaika}">
                <textarea name="kertomusteksti" rows="20" cols="100" ></textarea>
                <p><input type="submit"></p>
            </form>

        <p><a href="${pageContext.request.contextPath}/home">Palaa toimintovalikkoon!</a></p>
    </body>
</html>
