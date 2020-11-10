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
	public void queUnVendedorPuedaAlquilarAUnCliente() {

		// Se crean los objetos necesarios para alquilar una pelicula

		VideoClub blaze = new VideoClub("Blaze");
		Empleado nuevoVendedor = new Vendedor("Ramon", 456);
		Empleado nuevoRepositor = new Repositor("Jorge", 654);
		Pelicula nuevaPeli = new Pelicula("SAW 3", 243, 20.0, 16);
		Cliente nuevoCliente = new ClienteBasico("Marcos", 123, 30, 100.0);

		// VideoClub agrega a su lista de empleados Repositor y Vendedor

		blaze.agregarEmpleadoRepositorOVendedor(nuevoRepositor);
		blaze.agregarEmpleadoRepositorOVendedor(nuevoVendedor);

		// VideoClub agrega a su nuevo cliente
		blaze.agregarCliente(nuevoCliente);

		// VideoClub agrega la pelicula al stock del negocio
		blaze.agregarPelicula(nuevoRepositor.getCodigoEmpleado(), nuevaPeli);

		Boolean sePudoAlquilarLaPelicula;
		Integer peliculasEnAlquiler = 1;
		
		// Se realiza el casteo a tipo Vendedor y su utiliza el metodo para alquilarle
		// al cliente una pelicula
		sePudoAlquilarLaPelicula = ((Vendedor) nuevoVendedor).alquilarACliente(blaze.getListaCliente(), nuevoCliente,
				blaze.listaDePeliculas(), nuevaPeli, blaze.getListaDePeliculasAlquiladas());

		assertTrue(sePudoAlquilarLaPelicula);
		
		// Aca se evalua si la cantidad de peliculas alquiladas es 1
		assertEquals(peliculasEnAlquiler, ((Vendedor) nuevoVendedor).getCantidadPeliculasAlquiladas());

	}
	
	@Test
	public void queUnVendedorRecibaUnaPeliculaDelCliente() {
		// Se crean los objetos necesarios para alquilar una pelicula

		VideoClub blaze = new VideoClub("Blaze");
		Empleado nuevoVendedor = new Vendedor("Ramon", 456);
		Empleado nuevoRepositor = new Repositor("Jorge", 654);
		Pelicula nuevaPeli = new Pelicula("SAW 3", 243, 20.0, 16);
		Cliente nuevoCliente = new ClienteBasico("Marcos", 123, 30, 100.0);
		
		Boolean sePudoAlquilarLaPelicula;
		Boolean sePudoDevolverLaPelicula;
		Integer peliculasEnAlquiler = 0;

		// VideoClub agrega a su lista de empleados Repositor y Vendedor

		blaze.agregarEmpleadoRepositorOVendedor(nuevoRepositor);
		blaze.agregarEmpleadoRepositorOVendedor(nuevoVendedor);

		// VideoClub agrega a su nuevo cliente
		blaze.agregarCliente(nuevoCliente);

		// VideoClub agrega la pelicula al stock del negocio
		blaze.agregarPelicula(nuevoRepositor.getCodigoEmpleado(), nuevaPeli);
		
		// El vendedor le alquila la pelicula al cliente (ahora la pelicula esta en la listaDePeliculas de Cliente)
		sePudoAlquilarLaPelicula = ((Vendedor) nuevoVendedor).alquilarACliente(blaze.getListaCliente(), nuevoCliente,
				blaze.listaDePeliculas(), nuevaPeli, blaze.getListaDePeliculasAlquiladas());
		
		assertTrue(sePudoAlquilarLaPelicula);
		
		// El cliente devuelve la pelicula que le alquilo al vendedor anteriormente
		sePudoDevolverLaPelicula = ((Vendedor) nuevoVendedor).recibirPelicula(blaze.getListaCliente(), nuevoCliente,
				blaze.listaDePeliculas(), nuevaPeli, blaze.getListaDePeliculasAlquiladas());
		
		assertTrue(sePudoDevolverLaPelicula);
		
		// Aca se evalua si la cantidad de peliculas alquiladas es 0 (porque se devolvio la pelicula)
		assertEquals(peliculasEnAlquiler, ((Vendedor) nuevoVendedor).getCantidadPeliculasAlquiladas());
	}

}
