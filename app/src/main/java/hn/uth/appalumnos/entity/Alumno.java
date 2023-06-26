package hn.uth.appalumnos.entity;

public class Alumno {
    private String nombre;
    private String cuenta;
    private String correo;
    private String genero;
    private String campus;

    public Alumno(String nombre, String cuenta, String correo, String genero, String campus) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.correo = correo;
        this.genero = genero;
        this.campus = campus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
}
