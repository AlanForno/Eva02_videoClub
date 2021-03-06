package ar.edu.unlam.videoClub;

import java.util.HashSet;

//import ar.edu.unlam.videoClub.Cliente;

public class Vendedor extends Empleado {

	private HashSet<Pelicula> listaDePeliculas;

	private HashSet<Pelicula> registroDePeliculasAlquiladas;
	private Integer cantidadPeliculasAlquiladas = 0;

	public Vendedor(String nombre, Integer codigoEmpleado) {
		super(nombre, codigoEmpleado);
		this.registroDePeliculasAlquiladas = new HashSet<Pelicula>();
	}

	public Boolean alquilarACliente(HashSet<Cliente> listaCliente, Cliente cliente, HashSet<Pelicula> listaPeliculas,
			Pelicula pelicula, HashSet<Pelicula> listaDePeliculasAlquiladas) {

		Boolean seEncontroAlCliente = false;
		Boolean seAlquiloLaPelicula = false;

		for (Cliente clientes : listaCliente) {
			if (clientes.getCodigoCliente().equals(cliente.getCodigoCliente())) {
				seEncontroAlCliente = true;
				break;
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
						listaDePeliculasAlquiladas.add(pelicula); // Se agrega a su lista de peliculas (Cliente)
						listaPeliculas.remove(pelicula); // Se borra la pelicula del stock (VideoClub / Vendedor)
						cliente.alquilarPelicula(pelicula); // Se agrega al registro de peliculas (Vendedor)
						
						cantidadPeliculasAlquiladas = listaDePeliculasAlquiladas.size();

						seAlquiloLaPelicula = true;
						break;
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
				listaDePeliculasAlquiladas.remove(pelicula); // Se borra del registro de peliculas en alquiler (Vendedor)

				cantidadPeliculasAlquiladas = listaDePeliculasAlquiladas.size();

				seRecibioLaPelicula = true;
			}
		}

		return seRecibioLaPelicula;
	}

	public Boolean alquilarPelicula(Pelicula pelicula, Cliente cliente) {
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