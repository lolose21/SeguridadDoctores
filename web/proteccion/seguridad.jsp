
<%@page import="models.Doctores"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PROTECCION</title>
    </head>
    <body>
        <%
        Doctores doctor =(Doctores)
            session.getAttribute("DOCTORES");
        %>
        <h1 style="color: green">Zona Segura </h1>
        <h2 style="color: red">Bien Venido  perfil:<%=doctor.getApellido()%> 
            , <%=doctor.getEspecialidad()%></h2>
            <ul>
                <li>
                    <a href="../webcasa.jsp">CASA</a>
                </li>
                <li>
                    <a href="../doctoreshorario.jsp">Horario</a>
                </li>
                <li>
                    <a href="../webtablaempleados.jsp">TABLA DOCTORES</a>
                </li>
            </ul>
    </body>
</html>
