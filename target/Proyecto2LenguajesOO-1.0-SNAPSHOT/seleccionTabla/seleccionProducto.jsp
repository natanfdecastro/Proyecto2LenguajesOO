<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../menuStyle.html" %>

<div style="padding-left:16px">
    <h1>Seccion Modificar</h1>
    <p>En esta pagina se podra eliminar o modificar un elemento de la tabla.</p>
</div>

<%@include file="../deployJSP/deployProductos.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <script>
            var tabla = document.getElementById("tabla");
            

            
            var rows = tabla.rows;
            var lengthRows = rows.length;
            
            for (var i = 1, max = lengthRows; i < max; i++) {
                
                var cells = rows[i].cells;
                var cellBorrar = rows[i].insertCell(-1);
                var cellModificar = rows[i].insertCell(-1);
                
                var id = cells[0].innerHTML;
                var nombre = cells[1].innerHTML;
                var descripcion = cells[2].innerHTML;
                var cantidad = cells[3].innerHTML;
                
                cellBorrar.innerHTML = ""
                        + "<form name='form' method='post' action='../borrarDatos/funcionesBorrar/borrarProducto.jsp'>"
                        + "<input hidden name='id' value='" + id + "'>"
                        + "<input hidden name='nombre' value='" + nombre + "'>"
                        + "<input hidden name='descripcion' value='" + descripcion + "'>"
                        + "<input hidden name='cantidad' value='" + cantidad + "'>"
                        + "<input class='button2' type='submit' value='Borrar'>"
                        + "</form>";
                
                cellModificar.innerHTML = ""
                        + "<form name='form' method='post' action='../modificarDatos/formularioProducto.jsp'>"
                        + "<input hidden name='id' value='" + id + "'>"
                        + "<input hidden name='nombre' value='" + nombre + "'>"
                        + "<input hidden name='descripcion' value='" + descripcion + "'>"
                        + "<input hidden name='cantidad' value='" + cantidad + "'>"
                        + "<input class='button3' type='submit' value='Modificar'>"
                        + "</form>";

                
            }
            

            
            

            
            
        </script>
    </body>
</html>
