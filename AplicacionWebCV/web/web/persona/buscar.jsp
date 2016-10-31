<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.entidades.Persona"%>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    String accion = (String) request.getAttribute("accion");
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
        <form action="/AplicacionWebCV/cpersona" method="POST" name="f2">
            <fieldset style="margin: 0 auto; text-align: left; width: 45%">
                <legend><b>Datos para Buscar una Persona:</b></legend>
                <table border="0 "style="margin: 0 auto; text-align: left; width: 70%">
                    <tr>
                        <th style="width: 50%; text-align: right">
                            Elije una opción:
                            <select id="opcion" name="opcion">
                                <optgroup label="Busqueda por">
                                    <option value = "apellido" >Apellido</option>
                                    <option value = "edad" selected="selected">Edad</option>
                            </select>   
                        </th>
                        <td style="width: 70%; text-align: left">
                            <input class="filtro" id="edad" name="filtro" style="width: 95%; text-align: left"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 30%; text-align: center" colspan="2">
                            <input  type="submit"  value="Listar" name="accion" />
                        </td>  
                    </tr>
                </table>  
            </fieldset>
        </form>
    </div>

    <hr style="width: 45%">
    <p style="text-align: center"><span style="color: red"><%= mensaje != null ? mensaje : "nada"%></span></p>
</body>

<script type="text/javascript" src="js/jquery-3.1.1.min.js">
</script>
<script>
    $('#opcion').on('change', function () {
        $('.filtro').attr('id', "" + this.value);
        $(":text").each(function(){	
			$($(this)).val('');
	});
    });
    var number = document.getElementById("edad");
    var apellido = document.getElementById("apellido");
    
    
    $(".filtro").keypress(function (e) {
        var id = $(".filtro").attr('id');
        if (id == "edad") {
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
        } else {
            if (id == "apellido") {
                var regex = /^[a-zA-Z_]+$/;
                var str = String.fromCharCode(e.keyCode);
                if (!regex.test(str)) {
                    return false;
                }

            }
        }
    }
    );
</script>
</html>
