<%-- 
 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerlogin"
             class="controllers.ControllerLogin"
             scope="request"/>
<%
controllerlogin.setSession(session);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LOGIN! DOCTORES</h1>
        <form method="post">
            <label>APELLIDO</label>
            <input type="text" name="apellido" required/><br/>
            <label>ID DOCTOR</label>
            <input type="number" name="cajaid" required/><br/>
            <button type="submit">ENTER</button>
        </form>
        <%
        String apellido = request.getParameter("apellido");
        String dato = request.getParameter("cajaid");
        if (apellido != null){
            int iddoctor = Integer.parseInt("dato");
            boolean acceso = controllerlogin.existeDoctor(apellido, iddoctor);
            if(acceso == true){
                response.sendRedirect("proteccion/seguridad.jsp");
                
                }else{
                %>
                <h1 style="color: red">Usuario/password incorrectos</h1>
                <%
                }
            }
        %>
    </body>
</html>
