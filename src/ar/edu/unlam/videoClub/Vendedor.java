package ar.edu.unlam.videoClub;

import java.util.HashSet;

import ar.edu.unlam.videoClub.Cliente;

public class Vendedor extends Empleado {

	// vendedor extiende de empleado, ya tiene incorporado los atributos.

	private HashSet<Pelicula> listaDePeliculas;
	
	private HashSet<Pelicula> registroDePeliculasAlquiladas;

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
					
					// algo asi seria?
					if (cliente.alquilarPelicula(pelicula) == false) {
						return false;
					} else {
						
						// se agrega al registro de peliculas alquiladas
						listaDePeliculasAlquiladas.add(pelicula);
						// se borra la pelicula de la lista (se borra del stock)
						listaDePeliculas.remove(pelicula);
						
						seAlquiloLaPelicula = true;
					}
					
					
				}
			}
		}
		
		
		return seAlquiloLaPelicula;
	}

	public Boolean recibirPelicula(HashSet<Cliente> listaCliente, Cliente cliente, HashSet<Pelicula> listaPeliculas,
			                       Pelicula pelicula, HashSet<Pelicula> listaDePeliculasAlquiladas) {
		// recorre la listaDeCliente si posee a cliente, usa el metodo
		// cliente.devolverPelicula(pelicula);(podes hacer un metodo privado para
		// ahorrar codigo) 
		// entonces a listaPeliculas le agregas pelicula con un add (osea cliente lo devuelve y lo agregas a la lista.
		// y luego  a listaDePelis le sacas la pelicula.
		Boolean seRecibioLaPelicula = false;
		
		for (Cliente clientes : listaCliente) {
			if (clientes.getCodigoCliente().equals(cliente.getCodigoCliente())) {
				// el cliente devuelve la peli pasa por parametro (se borra de su lista)
				
				//esta ponelo dentro de un if porque puede devolver un false 
				cliente.devolverPelicula(pelicula);	
				
				
				
				// se agrega la peli pasada por paraetro a la lista de pelis
				listaDePeliculas.add(pelicula);
				// al no estar alquilada porque la devolvio el cliente se borra del registro de alquileres
				listaDePeliculasAlquiladas.remove(pelicula);
				
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
	
	public Integer obtenerCantidadPeliculasAlquiladas() {
		return registroDePeliculasAlquiladas.size();
	}


	@Override
	public String getNombre() {
		return nombre;

	}

}