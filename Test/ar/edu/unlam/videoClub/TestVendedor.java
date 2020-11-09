package ar.edu.unlam.videoClub;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.videoClub.Vendedor;

public class TestVendedor {

	@Test
	public void queSePuedaCrearUnVendedor() {
		Vendedor vendedor = new Vendedor ("Gabriel", 1125);
		
		assertNotNull(vendedor);
	}
	
	
	@Test
	public void queUnVendedorAlquileAUnCliente() {
		Vendedor nuevoVendedor = new Vendedor("Ramon", 456);
		Pelicula nuevaPeli = new Pelicula ("SAW 3", 243, 20.0, 16);
//		Repositor nuevoRepositor = new Repositor ("Jorge", 654);
		Cliente nuevoCliente = new ClienteMedio ("Marcos", 123, 30, 100.0);
		
		nuevoCliente.alquilarPelicula(nuevaPeli);
		assertTrue(nuevoVendedor.alquilarPelicula(nuevaPeli, nuevoCliente));
	}

}
