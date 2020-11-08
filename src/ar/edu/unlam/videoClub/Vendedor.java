package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class Vendedor extends Empleado {

	// vendedor extiende de empleado, ya tiene incorporado los atributos.

	private HashSet<Pelicula> listaDePeliculas;

	private Integer cantidadlistaDePeliculasAlquladas;

	public Vendedor(String nombre, Integer codigoEmpleado) {
		super(nombre, codigoEmpleado);
	}

	// Mariano te dejo este metodo para desarrollar asi vinculamos cliente con
	// vendedor y ahorramos codigo en videoclub

	public Boolean alquilarACliente(HashSet<Cliente> listaCliente, Cliente cliente, HashSet<Pelicula> listaPeliculas,
			Pelicula pelicula, HashSet<Pelicula> listaDePeliculasAlquiladas) {
		// recorre la listaDeCliente si posee a cliente, si lo encontro, recorre
		// listaDePeliculas si tiene pelicula. (podes hacer un metodo privado para
		// ahorrar codigo
		// despues usa el metodo de cliente.alquilar(pelicula); si esto es posible, hay
		// que pensar como restar esa pelicula de la lista de peliculas y agregarla a la
		// lista de peliculas alquiladas
		return false;
	}

	public Boolean recibirPelicula(HashSet<Cliente> listaCliente, Cliente cliente, HashSet<Pelicula> listaPeliculas,
			Pelicula pelicula, HashSet<Pelicula> listaDePeliculasAlquiladas) {
		// recorre la listaDeCliente si posee a cliente, usa el metodo
		// cliente.devolverPelicula(pelicula);(podes hacer un metodo privado para
		// ahorrar codigo) 
		// entonces a listaPeliculas le agregas pelicula con un add (osea cliente lo devuelve y lo agregas a la lista.
		// y luego  a listaDePelis le sacas la pelicula.
		return false;
	}

	public Boolean alquilarPelicula(Pelicula pelicula, Cliente cliente) {
		/*
		 * en este caso puse .remove porque alquila una pelicula, osea, la saca de la
		 * lista
		 * 
		 * No se como se utilizaría codigoPelicula y cliente
		 * 
		 * (Mariano)
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

}