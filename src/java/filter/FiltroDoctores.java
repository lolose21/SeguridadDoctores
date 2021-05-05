package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Doctores;

public class FiltroDoctores implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // aqui se recibe la primera peticion para el filtro
        //aqui podemos cambiar el comportamiento del filtro.

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //recibe el parametro objeto request y response
        //cadena de filtros para pasar la cadena al sigiente filtro
        HttpServletRequest peticion = (HttpServletRequest) request;
        //recuperamos el usuario de la sesion o recuperamos la uri (String peticion)
        String uri = peticion.getRequestURI();
        //necesitamos recuperar el usuario de la sesion
        //en nuestro caso , es un doctor
        Doctores doctores = (Doctores) peticion.getSession().getAttribute("DOCTORES");
        if (uri.contains("proteccion")) {
            //necesitamos validar la zona protegida
            if (doctores != null) {
                //debemos preguntar si tiene permiso
                if (doctores.getEspecialidad().equalsIgnoreCase("Cardiologia")) {
                    //navega feliz
                    chain.doFilter(request, response);
                } else {
                    //el doctor existe , pero no tiene permiso
                    HttpServletResponse respuesta = (HttpServletResponse) response;
                    respuesta.sendRedirect("../Denegado.jsp");
                }
            } else {
                // no se ha validado todavia
                HttpServletResponse respuesta = (HttpServletResponse) response;
                respuesta.sendRedirect("../login.jsp");
            }
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        //se ejecuta cuando decidimos "apagar" el filtro
        //sucede en el cierre de la aplicacion

    }

}
