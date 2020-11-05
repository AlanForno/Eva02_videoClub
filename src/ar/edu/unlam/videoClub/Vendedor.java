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
		/*
		 *  creo que este metodo seria algo asi como una copia de arrays
		 *  osea en la clase cliente el cuando alquila copia la pelicula a su array
		 *  pero tampoco estoy muy seguro de si esta bien la logica esa (Alan)
		 */
		peliculas.remove(pelicula);
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public Integer getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(Integer codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
}
