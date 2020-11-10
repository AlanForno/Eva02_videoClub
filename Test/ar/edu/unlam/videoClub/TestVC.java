package ar.edu.unlam.videoClub;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVC {

	@Test
	public void queSePuedaAgregarUnaPeliculaYComprobarSuExistencia() {

		VideoClub mania = new VideoClub("VideoMania");
		Cliente yo = new ClientePremium("Gerardo", 1, 18, 30d);
		Empleado nuevo = new Repositor("Cristian", 1);
		Pelicula accion = new Pelicula("Rambo", 1, 30d, 18);

		assertTrue(mania.agregarCliente(yo));
		assertTrue(mania.agregarEmpleadoRepositorOVendedor(nuevo));

		assertTrue(mania.agregarPelicula(1, accion));// el 1 es el numero de repositor. solo un repositor puede agregar
														// una peli.
		assertTrue(mania.existeLaPelicula(1)); // si se le pone otro codigo no lo encuentra

	}

	@Test
	public void queSePuedanAgregarCantidadDeUsuariosPremium() {
		VideoClub mania = new VideoClub("VideoMania");
		Cliente cliente1 = new ClientePremium("Gerardo", 1, 18, 30d);
		Cliente cliente2 = new ClientePremium("Gerardo", 2, 18, 30d);
		Cliente cliente3 = new ClientePremium("Gerardo", 3, 18, 30d);
		Cliente cliente4 = new ClienteMedio("Gerardo", 4, 18, 30d); // este no deberia contar como premium al ser medio

		assertTrue(mania.agregarCliente(cliente1));
		assertTrue(mania.agregarCliente(cliente2));
		assertTrue(mania.agregarCliente(cliente3));
		assertTrue(mania.agregarCliente(cliente4)); // lo agrega al medio pero no lo cuenta en la lista de premium.

		Integer re = 3;
		Integer ro = mania.cantidadDeClientesPremium();

		assertEquals(re, ro);

	}

	@Test
	public void queMuestraLaCantidadDeUsuariosBasicoMedioYPremium() {
		VideoClub mania = new VideoClub("VideoMania");

		Cliente cliente1 = new ClienteBasico("Gerardo", 1, 18, 30d);
		Cliente cliente2 = new ClienteBasico("Gerardo", 2, 18, 30d);
		Cliente cliente3 = new ClienteBasico("Gerardo", 3, 18, 30d);

		Cliente cliente4 = new ClienteMedio("Gerardo", 1, 18, 30d);
		Cliente cliente5 = new ClienteMedio("Gerardo", 2, 18, 30d);
		Cliente cliente6 = new ClienteMedio("Gerardo", 3, 18, 30d);

		Cliente cliente7 = new ClientePremium("Gerardo", 1, 18, 30d);
		Cliente cliente8 = new ClientePremium("Gerardo", 2, 18, 30d);
		Cliente cliente9 = new ClientePremium("Gerardo", 3, 18, 30d);

		mania.agregarCliente(cliente1);
		mania.agregarCliente(cliente2);
		mania.agregarCliente(cliente3);
		mania.agregarCliente(cliente4);
		mania.agregarCliente(cliente5);
		mania.agregarCliente(cliente6);
		mania.agregarCliente(cliente7);
		mania.agregarCliente(cliente8);
		mania.agregarCliente(cliente9);

		Integer cantidadDeBasicos = 3;
		Integer cantidadDeMedio = 3;
		Integer cantidadDePremium = 3;

		assertEquals(cantidadDeBasicos, mania.cantidadDeClientesBasico());
		assertEquals(cantidadDeMedio, mania.cantidadDeClientesBasico());
		assertEquals(cantidadDePremium, mania.cantidadDeClientesBasico());

	}

	@Test
	public void queNoMePermitaAgregarDosClientesIguales() {
		VideoClub mania = new VideoClub("VideoMania");

		Cliente cliente1 = new ClienteBasico("Gerardo", 1, 18, 30d);
		Cliente cliente2 = new ClienteMedio("Gerardo", 1, 18, 30d); // a pesar de ser basico y medio, si tienen el mismo
																	// codigo no se puede agregar

		mania.agregarCliente(cliente1);
		assertFalse(mania.agregarCliente(cliente2)); // como los dos tienen el mismo codigo (1) no lo puede agregar.
	}

	@Test
	public void queNoAdmitaEmpleadosDuplicadosYQuitarEmpleados() {
		VideoClub mania = new VideoClub("VideoMania");
		Empleado empleado1 = new Repositor("Cristian", 1);
		Empleado empleado2 = new Repositor("Cristian", 2);
		Empleado empleado3 = new Vendedor("Cristian", 3);
		Empleado empleado4 = new Vendedor("Cristian", 4);

		assertTrue(mania.agregarEmpleadoRepositorOVendedor(empleado1));
		assertTrue(mania.agregarEmpleadoRepositorOVendedor(empleado2));
		assertTrue(mania.agregarEmpleadoRepositorOVendedor(empleado3));
		assertTrue(mania.agregarEmpleadoRepositorOVendedor(empleado4));
		assertFalse(mania.agregarEmpleadoRepositorOVendedor(empleado2));// Duplicado

		assertTrue(mania.despedirEmpleado(1));
		assertTrue(mania.despedirEmpleado(2));
		assertTrue(mania.despedirEmpleado(3));
		assertTrue(mania.despedirEmpleado(4)); // los despide sin problemas

		assertFalse(mania.despedirEmpleado(1)); // no puede despedir a quien no esta contratado.
		assertFalse(mania.despedirEmpleado(2));
		assertFalse(mania.despedirEmpleado(3));
		assertFalse(mania.despedirEmpleado(4));
	}

	@Test
	public void queNoMePermitaAgregarUnRepositorYVendedorConElMismoCodigo() {
		VideoClub mania = new VideoClub("VideoMania");
		Empleado empleado1 = new Repositor("Cristian", 1);
		Empleado empleado2 = new Vendedor("Roberto", 1);

		assertTrue(mania.agregarEmpleadoRepositorOVendedor(empleado1));
		assertFalse(mania.agregarEmpleadoRepositorOVendedor(empleado2));

	}
//_________________________________________________________________________________________________________//
	// test para alquiler de peliculas

	@Test
	public void QuePermitaAlquilarPeliculaAClienteYCompruebeSuDinero() {
		VideoClub mania = new VideoClub("VideoMania");

		Empleado repositor = new Repositor("Juan", 1); // creo un repositor
		mania.agregarEmpleadoRepositorOVendedor(repositor); // lo agrego

		Pelicula tarzan = new Pelicula("Tarzan", 1, 200.0, 5); // creo una pelicula
		mania.agregarPelicula(1, tarzan); // agrego la pelicula con el codigo del repositor

		Empleado vendedor = new Vendedor("Jose", 2); // creo un vendedor, con un codigo diferente al repositor.
		mania.agregarEmpleadoRepositorOVendedor(vendedor); // agrego al vendedor

		Cliente carlos = new ClienteBasico("cris", 1, 20, 1000.0); // creo al cliente
		mania.agregarCliente(carlos); // lo agrego.

		assertTrue(mania.alquilarPelicula(2, carlos, tarzan)); // el 2 es el codigo del vendedor, un repositor no puede
																// alquilarle a nadie.
		
		Double valorActualDelCliente = 800.0; //al costar 200.0 la pelicula y al traer 1000.0 el cliente.
		assertEquals(valorActualDelCliente,carlos.getDinero());
	}
}
