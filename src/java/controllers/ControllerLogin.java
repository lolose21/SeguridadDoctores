package controllers;

import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import models.Doctores;
import repositories.RepositoryDoctor;

public class ControllerLogin {

    HttpSession session;
    RepositoryDoctor repo;

    public ControllerLogin() {
        this.repo = new RepositoryDoctor();

    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public boolean existeDoctor(String apellido, int iddoctor) throws SQLException {
        Doctores doctor = this.repo.existeDoctor(apellido, iddoctor);
        if (doctor == null) {
            //no existe
            return false;
        } else {
            //existe el doctor y se a validado
            session.setAttribute("DOCTORES", doctor);
            return true;
        }

    }
}
