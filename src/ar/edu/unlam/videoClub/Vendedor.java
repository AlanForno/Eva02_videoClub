package ar.edu.unlam.videoClub;

import java.util.HashSet;

import ar.edu.unlam.videoClub.Cliente;

public class Vendedor extends Empleado {

	// vendedor extiende de empleado, ya tiene incorporado los atributos.

	private HashSet<Pelicula> listaDePeliculas;

	private HashSet<Pelicula> registroDePeliculasAlquiladas;
	private Integer cantidadPeliculasAlquiladas = 0;

	public Vendedor(String nombre, Integer codigoEmpleado) {
		super(nombre, codigoEmpleado);
		this.registroDePeliculasAlquiladas = new HashSet<Pelicula>();
	}

	// Mariano te dejo este metodo para desarrollar asi vinculamos cliente con
	// vendedor y ahorramos codigo en videoclub

	public Boolean alquilarACliente(HashSet<Cliente> listaCliente, Cliente cliente, HashSet<Pelicula> listaPeliculas,
			Pelicula pelicula, HashSet<Pelicula> listaDePeliculasAlquiladas) {

		Boolean seEncontroAlCliente = false;
		Boolean seAlquiloLaPelicula = false;

		for (Cliente clientes : listaCliente) {
			if (clientes.getCodigoCliente().equals(cliente.getCodigoCliente())) {
				seEncontroAlCliente = true;
			}
		}
		if (seEncontroAlCliente == true) {
			for (Pelicula peliculas : listaPeliculas) {
				if (peliculas.getCodigoPelicula().equals(pelicula.getCodigoPelicula())) {

					if (cliente.alquilarPelicula(pelicula) == false) {
						/*
						 * En este if evalua si el cliente es capaz de alquilar la pelicula en cuestion
						 * (condiciones del metodo alquilarPelicula de clase Cliente) Si no puede
						 * alquilar esta pelicula se sale de este metodo retornando false
						 */
						return false;
					} else {
						/*
						 * Este es el caso si el cliente puede alquilar la pelicula
						 */
						cliente.alquilarPelicula(pelicula); // Se agrega a su lista de peliculas (Cliente)
						listaPeliculas.remove(pelicula); // Se borra la pelicula del stock (VideoClub / Vendedor)
						listaDePeliculasAlquiladas.add(pelicula); // Se agrega al registro de peliculas (Vendedor)

						cantidadPeliculasAlquiladas = listaDePeliculasAlquiladas.size();

						seAlquiloLaPelicula = true;
					}

				}
			}

		}

		return seAlquiloLaPelicula;
	}

	public Boolean recibirPelicula(HashSet<Cliente> listaCliente, Cliente cliente, HashSet<Pelicula> listaPeliculas,
			Pelicula pelicula, HashSet<Pelicula> listaDePeliculasAlquiladas) {

		Boolean seRecibioLaPelicula = false;

		for (Cliente clientes : listaCliente) {
			if (clientes.getCodigoCliente().equals(cliente.getCodigoCliente())) {

				cliente.devolverPelicula(pelicula); // Se borra la pelicula de la listaDePeliculas (Cliente)
				listaPeliculas.add(pelicula); // Se agrega al stock de peliculas (VideoClub / Vendedor)
				listaDePeliculasAlquiladas.remove(pelicula); // Se borra del registro de peliculas en alquiler
																// (Vendedor)

				cantidadPeliculasAlquiladas = listaDePeliculasAlquiladas.size();

				seRecibioLaPelicula = true;
			}
		}

		return seRecibioLaPelicula;
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
		Cliente ejemplo = cliente;

		if (ejemplo.getListaDePeliculas().contains(pelicula) == true) {
			seAlquiloLaPelicula = true;
			registroDePeliculasAlquiladas.add(pelicula);
		}

		return seAlquiloLaPelicula;
	}

	public Integer getCantidadPeliculasAlquiladas() {
		return cantidadPeliculasAlquiladas;
	}

	@Override
	public String getNombre() {
		return nombre;

	}

}