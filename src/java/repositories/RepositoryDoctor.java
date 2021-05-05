package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Doctores;
import oracle.jdbc.OracleDriver;

public class RepositoryDoctor {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@LOCALHOST:1521:XE";
        Connection cn
                = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }
    //creo un nuevo arraylist para poder recorrer y mostrar datos

    public ArrayList<Doctores> getDoctores() throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from doctor";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Doctores> lista = new ArrayList<>();
        while (rs.next()) {
            int hospi = rs.getInt("hospital_cod");
            int id = rs.getInt("doctor_no");
            String ape = rs.getString("apellido");
            String espe = rs.getString("especialidad");
            int sal = rs.getInt("salario");
            Doctores doctor = new Doctores(hospi, id, ape, espe, sal);
            lista.add(doctor);
        }
        rs.close();
        cn.close();
        return lista;
    }

    public Doctores existeDoctor(String apellido, int iddoctor) throws SQLException {
        Connection cn
                = this.getConnection();
        String sql = "select * from doctor where lower(apellido) = lower(?) and emp_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, apellido);
        pst.setInt(2, iddoctor);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            //existe el empleado
            int hospi = rs.getInt("hospital_cod");
            int id = rs.getInt("doctor_no");
            String ape = rs.getString("apellido");
            String espe = rs.getString("especialidad");
            int sal = rs.getInt("salario");
            Doctores doctor = new Doctores(hospi, id, ape, espe, sal);
            rs.close();
            cn.close();
            return doctor;
        } else {
            //no existe
            rs.close();
            cn.close();
            return null;
        }

    }
}
