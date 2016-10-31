<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.entidades.Persona"%>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    String accion = (String)request.getAttribute("accion");
    List<Persona> listado = (List<Persona>) request.getAttribute("persona.listar");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>:: Aplicacion Web de Busqueda ::</title>
    </head>
    <body>
    <center>
        <h1>
            <b> Aplicacion Web de Busqueda </b>
        </h1>
        <hr/>
        <h3><b> BUSQUEDA DE PERSONAS EN EL SISTEMA </b></h3>
    </center>
    <hr style="width: 45%">
    
    <div style="text-align: center">
        <fieldset style="margin: 0 auto; text-align: left; width: 45%">
            <legend><b>Resultados de la busqueda: </b></legend>     
            <table border="1" style="margin: 0 auto; text-align: left; width: 70% ">
                <tr>
                    <th>No.</th>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Edad</th>
                </tr>
                <%
                    int contador = 0;
                    Iterator<Persona> iterador = listado.iterator();
                    while (iterador.hasNext() == true) {
                        contador += 1;
                        Persona per = iterador.next();
                %>
                <tr>
                    <td><%= contador%></td>
                    <td><%= per.getIdPersonas()%></td>
                    <td><%= per.getNombre()%></td>
                    <td><%= per.getApellido()%></td>
                    <td><%= per.getEdad()%></td>
                </tr>
                <%
                    }
                %>
            </table>
        </fieldset>     
    </div>
    
    <hr style="width: 45%">
    <p style="text-align: center"><span style="color: red"><%= mensaje != null ? mensaje : "nada"%></span></p>
</body>
</html>
