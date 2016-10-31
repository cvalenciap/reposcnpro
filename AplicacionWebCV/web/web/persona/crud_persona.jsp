<%--
    Document   : agregar
    Created on : 14/10/2016, 10:37:48 AM
    Author     : Erlan Valencia
--%>
<%@page import="com.modelo.entidades.Persona"%>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    String accion = (String) request.getAttribute("accion");
    Persona per = (Persona) request.getAttribute("persona encontrada");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <h3><b> FORMULARIO PARA ADMINISTRAR PERSONAS </b></h3>
    </center>
    <hr style="width: 45%">
    <div style="text-align: center">
        <form action="/AplicacionWebCV/cpersona" method="POST" name="f1">
            <fieldset style="margin: 0 auto; text-align: left; width: 45%">
                <legend><b>Datos para Agregar una nueva Persona:</b></legend>
                <table border="0" style="margin: 0 auto; text-align: left; width: 70%">
                    <tr>
                        <th style="width: 30%; text-align: right">Identificacion:</th>
                        <td style="width: 70%; text-align: left"><input type="number" class="numeros" id="numeros" name="idPersonas" style="width: 95%" value="<%= (per != null) ? per.getIdPersonas() : ""%>" <%=(accion.equals("mos_persona")) ? "readonly required='false'" : "required"%>/></td>
                    </tr>
                    <tr>
                        <th style="width: 30%; text-align: right">Nombre:</th>
                        <td style="width: 70%; text-align: left"><input type="text" class="caracteres" id="caracteres" name="nombre" style="width: 95%" value="<%= (per != null) ? per.getNombre() : ""%>" <%=(accion.equals("mos_buscar")) ? "readonly required='false'" : "required"%> /></td>                            
                    </tr>
                    <tr>
                        <th style="width: 30%; text-align: right">Apellidos:</th>
                        <td style="width: 70%; text-align: left"><input type="text" class="caracteres" id="caracteres" name="apellido" style="width: 95%" value="<%= (per != null) ? per.getApellido() : ""%>" <%=(accion.equals("mos_buscar")) ? "readonly required='false'" : "required"%>/></td>                            
                    </tr>
                    <tr>
                        <th style="width: 30%; text-align: right">Edad:</th>
                        <td style="width: 70%; text-align: left"><input type="number" class="numeros"  id="numeros" min="1" max="100" name="edad" style="width: 95%" value="<%= (per != null) ? per.getEdad() : ""%>" <%=(accion.equals("mos_buscar")) ? "readonly required='false'" : "required"%>/></td>                            
                    </tr>
                    <tr>
                        <td style="width: 30%; text-align: center" colspan="2">
                            <input type="submit" value="Guardar" name="accion" <%=(accion.equals("mos_buscar") || accion.equals("mos_persona")) ? "disabled" : ""%>/>
                            <input type="submit" value="Buscar" name="accion" <%=(!accion.equals("mos_buscar")) ? "disabled" : "enabled"%>/> 
                            <input type="submit" value="Eliminar" name="accion"<%=(accion.equals("mos_buscar") || accion.equals("mos_agregar")) ? "disabled" : ""%>/>
                            <input type="reset" value="Restaurar" />
                        </td>                            
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js">
</script>
    <script>
        
        jQuery(document).ready(function() {
        jQuery('.numeros').keypress(function(e) {
            var id = $(".numeros").attr('id');
            if (id == "numeros") {
            var key=String.fromCharCode(e.keyCode);
            var regest = /^[0-9]+$/;
            console.log(key);
                if(!regest.test(key)){
                    return false;
                }
                if(this.value>10){
                    return false;
                }
//            
            }
        });
        jQuery('.caracteres').keypress(function(e) {
        var id = $(".caracteres").attr('id');    
        if (id == "caracteres") {
                var regex = /^[a-zA-Z_]+$/;
                var str = String.fromCharCode(e.keyCode);
                if (!regex.test(str)) {
                    return false;
                }

            }
        });
        });
        /*
        var number = document.getElementById("edad");
        var apellido = document.getElementById("apellido");

        
            var id = $(".filtro").attr('id');
            if (id == "edad") {
                //solo_numero(e);
                if (!((e.keyCode > 96 && e.keyCode < 106)
                        || (e.keyCode > 48 && e.keyCode < 58)
                        || e.keyCode == 8)) {
                    return false; 
                }
                if(this.value>100){
                    return false;
                }

            }*/
    </script>
    <hr style="width: 45%">
    <p style="text-align: center"><span style="color: red"><%= mensaje != null ? mensaje : "nada"%></span></p>
</body>
</html>
