<%-- 
    Document   : index
    Created on : 14/10/2016, 09:45:31 AM
    Author     : Erlan Valencia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>:: Aplicacion Web de Busqueda ::</title>
    </head>
    <body>
        <center><h1><b> Aplicacion Web de Busqueda </b></h1></center>
        <hr style="width: 45%">
        <div style="text-align: center">
            <h3>MENU PARA OPERACIONES SOBRE PERSONAS</h3>
            <table border="0" style="margin: 0 auto; text-align: left">
                    <tr>
                        <td><a href="<%= request.getContextPath() %>/cpersona?accion=sol_listar">Buscar Personas</a></td>
                    </tr>
                    <tr>
                        <td><a href="<%= request.getContextPath() %>/cpersona?accion=sol_agregar">Agregar Personas</a></td>
                    </tr>
                    <tr>
                        <td><a href="<%= request.getContextPath() %>/cpersona?accion=sol_buscar">Consultar Personas</a></td>
                    </tr>
                    <tr>
                        <td><a href="<%= request.getContextPath() %>/cpersona?accion=sol_buscar">Eliminar Personas</a></td>
                    </tr>
            </table> 
        </div>
    </body>
</html>
