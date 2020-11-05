package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class Vendedor extends Empleado{
	private String nombre;
	private Integer codigoVendedor;
	private HashSet<Pelicula>peliculas;

	public Vendedor(String nombre, Integer codigoEmpleado) {
		super(nombre, codigoEmpleado);
		this.nombre = nombre;
		this.codigoVendedor = codigoEmpleado;
	}

	public void alquilarPeliculas(Pelicula pelicula, Integer codigoPelicula, Cliente cliente) {
		/* en este caso puse .remove porque
			alquila una pelicula, osea, la saca de la lista

			No se como se utilizaría codigoPelicula y cliente

			(Mariano)
		 */
		peliculas.remove(pelicula);
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(Integer codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
}
