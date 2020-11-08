package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class Vendedor extends Empleado{
	
	private String nombre;
	private Integer codigoVendedor;
	private HashSet<Pelicula> listaDePeliculas;
	
	private Integer cantidadlistaDePeliculasAlquladas;

	public Vendedor(String nombre, Integer codigoEmpleado) {
		super(nombre, codigoEmpleado);
		this.nombre = nombre;
		this.codigoVendedor = codigoEmpleado;
	}

	/*
	 * modifique la firma del segundo parametro (codigoDePelicula) porque 
	 * con el primer parametro al ser de tipo objeto ya podemos sacar informacion 
	 * del objeto pelicula (nombre, codigo, precio, etc)
	 */
	public Boolean alquilarPelicula(Pelicula pelicula, Cliente cliente) {
		/* en este caso puse .remove porque
			alquila una pelicula, osea, la saca de la lista

			No se como se utilizaría codigoPelicula y cliente

			(Mariano)
		 */
		Boolean seAlquiloLaPelicula = false;
		
		if (cliente.alquilarPelicula(pelicula) == true) {
			listaDePeliculas.remove(pelicula);
			seAlquiloLaPelicula = true;
		}
		
		return seAlquiloLaPelicula;
	}
	
	public Integer obtenerCantidadDelistaDePeliculasAlquiladas() {
		return cantidadlistaDePeliculasAlquladas;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public Integer getCodigoVendedor() {
		return codigoVendedor;
	}
	
}