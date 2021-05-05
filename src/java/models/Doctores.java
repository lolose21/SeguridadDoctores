package models;

public class Doctores {

    private int hospital;
    private int iddoctor;
    private String apellido;
    private String especialidad;
    private int salario;

    public Doctores() {
    }
    //llamamos al constructor

    public Doctores(int hospi, int id, String ape, String espe, int sal) {
        this.hospital = hospi;
        this.iddoctor = id;
        this.apellido = ape;
        this.especialidad = espe;
        this.salario = sal;
    }
//<editor-fold defaultstate="collapsed" desc="getter and setter">

    public int getHospital() {
        return hospital;
    }

    public void setHospital(int hospital) {
        this.hospital = hospital;
    }

    public int getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
//</editor-fold>

}
