package ar.edu.unlam.videoClub;

import java.util.Objects;

public class Empleado {

	protected String nombre; // los atribuos deben ser protected
	protected Integer codigoEmpleado;

	public Empleado(String nombre, Integer codigoEmpleado) {
		this.nombre = nombre;
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(Integer codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Empleado empleado = (Empleado) o;
		return Objects.equals(nombre, empleado.nombre) && Objects.equals(codigoEmpleado, empleado.codigoEmpleado);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, codigoEmpleado);
	}
}
