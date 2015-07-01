

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <sf:form method="post" action="altaImagen.html"  enctype="multipart/form-data">
            <div class="main">
                <br> <br> <br> <br> <br>
                <table align="center">
                    <tr>
                        <td class="block" colspan="2" align="center">ALTA DE IMAGENES</td>

                    </tr>
                    <tr>
                        <td class="indenth2">Selecciona fichero:</td>
                        <td><input type="file" name="fichero"></td>
                    </tr>
                          
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="GRABAR"></td>
                    </tr>
                </table> 
            </div>
        </sf:form>
    </body>
</html>
