<%-- 
    Document   : error
    Created on : 16/10/2016, 02:24:50 PM
    Author     : Erlan Valencia
--%>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    String estilo = (String) request.getAttribute("estilo");
    String ruta = (String) request.getAttribute("ruta");
    String accion = (String) request.getAttribute("proxima accion");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>:: Aplicacion Web de Busqueda ::</title>
        <style type="text/css">
            .info, .exito, .alerta, .error{
                font-family: Arial, Helvetica, sans-serif;
                font-size: 17px;
                border: 1px,solid;
                margin: 10px 0px;
                padding: 15px 10px 15px 50px;
                background-repeat: no-repeat;
                background-position: 10px center;
            }
            .info{
                color: #00529B;
                background-color: #BDE5F8;
                background-image: url('imagenes/mensaje.png'); 
            }
            .exito{
                color: #4F8A10;
                background-color: #DFF2BF;
                background-image: url('imagenes/ok.png');
            }             
            .alerta{
                color: #9F6000;
                background-color: #FEEFB3;
                background-image: url('imagenes/atencion.png');
            }
            .error{
                color: #D8000C; 
                background-color: #FFBABA;
                background-image: url('imagenes/error.png');
            }
        </style>    
    </head>
    <body>
    <center>
        <img src="imagenes/logo_cenpro.png" width="50%" height="50%"/>
        <div class= "<%= estilo !=null ? estilo : ""%>" style="width: 50%; word-wrap: break-word;" >
                <%= mensaje != null ? mensaje : ""%>  
        </div>
        <p></p>
        <br/><hr/>
        <a href="<%= request.getContextPath()%>/<%= ruta %>?accion=<%= accion %> ">
            <img src="imagenes/home.png" width="10%" height="10%" alt="home"/>
        </a>
    </center>
    </body>
</html>
