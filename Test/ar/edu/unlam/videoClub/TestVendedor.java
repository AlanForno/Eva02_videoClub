package ar.edu.unlam.videoClub;
import ar.edu.unlam.videoClub.*;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.videoClub.Vendedor;
import ar.edu.unlam.videoClub.Test.*;

public class TestVendedor {

	@Test
	public void queSePuedaCrearUnVendedor() {
		Vendedor vendedor = new Vendedor ("Gabriel", 1125);
		
		assertNotNull(vendedor);
	}
	
	@Test
	public void queUnClienteAlquileUnaPeli() {
		Cliente cliente = new ClienteMedio ("Marcos", 123, 30, 100.0);
		Pelicula nuevaPeli = new Pelicula ("SAW 3", 243, 20.0, 16);
		
		Boolean pudoAlquilarLaPelicula = cliente.alquilarPelicula(nuevaPeli);
		
		assertTrue(pudoAlquilarLaPelicula);
	}
	
	@Test
	public void queUnVendedorAlquileAUnCliente() {
		Vendedor nuevoVendedor = new Vendedor("Ramon", 456);
		Pelicula nuevaPeli = new Pelicula ("SAW 3", 243, 20.0, 16);
		Repositor nuevoRepositor = new Repositor ("Jorge", 654);
		Cliente nuevoCliente = new ClienteMedio ("Marcos", 123, 30, 100.0);
		
		assertTrue(nuevoCliente.alquilarPelicula(nuevaPeli));
		nuevoVendedor.alquilarPelicula(nuevaPeli, nuevoCliente);
		
		assertNotNull(nuevoCliente.getListaDePeliculas());
		
	}

}
