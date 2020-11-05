package ar.edu.unlam.videoClub;

public class Empleado {

    private String nombre;
    private Integer codigoEmpleado;

    public Empleado(String nombre,Integer codigoEmpleado ){
        this.nombre=nombre;
        this.codigoEmpleado=codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Integer codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
}
