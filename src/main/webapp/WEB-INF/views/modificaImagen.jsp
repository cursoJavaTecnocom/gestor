

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
   
        <sf:form  action="grabaModificaImagen${imagen.id }.html"  modelAttribute="imagen">
            <div class="main">
                <br> <br> <br> <br> <br>
                <table align="center">
                    <tr>
                        <td class="block" colspan="2" align="center">MODIFICACION DE IMAGENES</td>

                    </tr>
                    <tr>
                        <td class="indenth2">Imagen:</td>
                        <td><sf:input path="nombre" disabled="true"/></td>
                    </tr>
                          <tr>
                        <td class="indenth2">Carrusel</td>
                        <td><sf:checkbox path="carrusel"/> </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="GRABAR"></td>
                    </tr>
                </table> 
            </div>
        </sf:form>
    </body>
</html>
