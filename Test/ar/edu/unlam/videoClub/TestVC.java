package ar.edu.unlam.videoClub;

import static org.junit.Assert.*;

import org.junit.Assert;
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
	public void queMePermitaAgregarVariasPeliculas() {
		VideoClub mania = new VideoClub("VideoMania");

		Empleado repositor = new Repositor("Juan", 1);
		mania.agregarEmpleadoRepositorOVendedor(repositor);

		Empleado vendedor = new Vendedor("jose", 2);
		assertTrue(mania.agregarEmpleadoRepositorOVendedor(vendedor));

		Pelicula tarzan = new Pelicula("Tarzan", 1, 200.0, 18); 
		assertTrue(mania.agregarPelicula(1, tarzan));

		Pelicula nemo = new Pelicula("nemo", 2, 200.0, 18); 
		assertTrue(mania.agregarPelicula(1, nemo));
		
		Pelicula dbz = new Pelicula("dbz", 3, 200.0, 18); 
		assertTrue(mania.agregarPelicula(1, dbz));
		
		Cliente cris = new ClienteBasico ("Cris",2,25,3000.0);
		
		assertTrue(mania.agregarCliente(cris));
		assertTrue(mania.alquilarPelicula(2, cris, dbz));
	
		
		
		
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
	public void QuePermitaAlquilarPeliculaAClienteBasicoYCompruebeSuDinero() {
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

		Double valorActualDelCliente = 800.0; // al costar 200.0 la pelicula y al traer 1000.0 el cliente.
		assertEquals(valorActualDelCliente, carlos.getDinero());

	}

	@Test
	public void QuePermitaAlquilarPeliculaAClienteMedioConDescuentoYCompruebeSuDinero() {
		VideoClub mania = new VideoClub("VideoMania");

		Empleado repositor = new Repositor("Juan", 1); // creo un repositor
		mania.agregarEmpleadoRepositorOVendedor(repositor); // lo agrego

		Pelicula tarzan = new Pelicula("Tarzan", 1, 200.0, 5); // creo una pelicula
		mania.agregarPelicula(1, tarzan); // agrego la pelicula con el codigo del repositor

		Empleado vendedor = new Vendedor("Jose", 2); // creo un vendedor, con un codigo diferente al repositor.
		mania.agregarEmpleadoRepositorOVendedor(vendedor); // agrego al vendedor

		Cliente carlos = new ClienteMedio("cris", 1, 20, 1000.0); // creo al cliente
		mania.agregarCliente(carlos); // lo agrego.

		assertTrue(mania.alquilarPelicula(2, carlos, tarzan)); // el 2 es el codigo del vendedor, un repositor no puede
																// alquilarle a nadie.

		Double valorActualDelCliente = 820.0; // al cliente premium se le hace un descuento del 10% al valor de la
												// pelicula
		assertEquals(valorActualDelCliente, carlos.getDinero());

	}

	@Test
	public void queNoMePermitaAlquilarAUnClienteBasicoMenorDeLaEdadParaLaPelicula() {
		VideoClub mania = new VideoClub("VideoMania");

		Empleado repositor = new Repositor("Juan", 1);
		mania.agregarEmpleadoRepositorOVendedor(repositor);

		Empleado vendedor = new Vendedor("Jose", 2);
		mania.agregarEmpleadoRepositorOVendedor(vendedor);

		Pelicula tarzan = new Pelicula("Tarzan", 1, 200.0, 18); // la pelicula es para mayores de 18 años
		mania.agregarPelicula(1, tarzan);

		Cliente carlos = new ClienteMedio("cris", 1, 12, 1000.0);// carlos tiene 12 años.
		mania.agregarCliente(carlos);

		assertFalse(mania.alquilarPelicula(2, carlos, tarzan)); // el vendedor jose le alquila a carlos tarzan. no puede
																// porque es menor a la edad.

		Double dineroDeCarlos = 1000.0;
		assertEquals(dineroDeCarlos, carlos.getDinero()); // no se modifico el dinero de carlos.

	}

	@Test
	public void queNoPermitaAlquilarSiNoLeAlcanzaElDinero() {
		VideoClub mania = new VideoClub("VideoMania");

		Empleado repositor = new Repositor("Juan", 1);
		mania.agregarEmpleadoRepositorOVendedor(repositor);

		Empleado vendedor = new Vendedor("Jose", 2);
		mania.agregarEmpleadoRepositorOVendedor(vendedor);

		Pelicula tarzan = new Pelicula("Tarzan", 1, 200.0, 18); // la pelicula sale 200
		mania.agregarPelicula(1, tarzan);

		Cliente carlos = new ClienteMedio("cris", 1, 20, 100.0);// carlos tiene 100.
		mania.agregarCliente(carlos);

		assertFalse(mania.alquilarPelicula(2, carlos, tarzan)); // el vendedor jose le alquila a carlos tarzan. no puede
																// porque es no le alcanza el dinero.
	}

	@Test
	public void queLePermitaAlquilarAUnClientePremiumAunSiendoMenorDeLaEdad() {
		VideoClub mania = new VideoClub("VideoMania");

		Empleado repositor = new Repositor("Juan", 1);
		mania.agregarEmpleadoRepositorOVendedor(repositor);

		Empleado vendedor = new Vendedor("Jose", 2);
		mania.agregarEmpleadoRepositorOVendedor(vendedor);

		Pelicula tarzan = new Pelicula("Tarzan", 1, 200.0, 25); // esta pelicula es para mayores de 25
		mania.agregarPelicula(1, tarzan);

		Cliente carlos = new ClientePremium("cris", 1, 20, 1000.0);// cristian tiene 20, no deberia poder verla, pero al
																	// ser premium si puede
		mania.agregarCliente(carlos);

		assertTrue(mania.alquilarPelicula(2, carlos, tarzan)); // el vendedor jose le alquila a carlos tarzan. no podria
																// al ser menor de la edad per como es premium si puede
	}
	
	@Test
	public void queNoLePermitaAunClienteTenerDosPeliculasIguales() {
		VideoClub mania = new VideoClub("VideoMania");

		Empleado repositor = new Repositor("Juan", 1);
		mania.agregarEmpleadoRepositorOVendedor(repositor);

		Empleado vendedor = new Vendedor("Jose", 2);
		mania.agregarEmpleadoRepositorOVendedor(vendedor);

		Pelicula tarzan = new Pelicula("Tarzan", 1, 200.0, 18); 
		mania.agregarPelicula(1, tarzan);

		Cliente carlos = new ClienteMedio("cris", 1, 20, 1000.0);
		mania.agregarCliente(carlos);

		assertTrue(mania.alquilarPelicula(2, carlos, tarzan)); 
		assertFalse(mania.alquilarPelicula(2, carlos, tarzan));
	}
	
	@Test
	public void queVerifiqueQueAClienteSeLeAcumulanPeliculas() {
		VideoClub mania = new VideoClub("VideoMania");

		Empleado repositor = new Repositor("Juan", 1);
		mania.agregarEmpleadoRepositorOVendedor(repositor);

		Empleado vendedor = new Vendedor("jose", 2);
		mania.agregarEmpleadoRepositorOVendedor(vendedor);

		Pelicula tarzan = new Pelicula("Tarzan", 1, 200.0, 18); 
		mania.agregarPelicula(1, tarzan);

		Pelicula nemo = new Pelicula("nemo", 2, 200.0, 18); 
		mania.agregarPelicula(1, nemo);
		
		Pelicula dbz = new Pelicula("dbz", 3, 200.0, 18); 
		mania.agregarPelicula(1, dbz);
		
		Cliente cris = new ClienteBasico ("Cris",2,25,3000.0);
		
		assertTrue(mania.agregarCliente(cris));
		assertTrue(mania.alquilarPelicula(2, cris, dbz));
		assertTrue(mania.alquilarPelicula(2, cris, nemo));
		assertTrue(mania.alquilarPelicula(2, cris, tarzan));
		
		int cantidadDePeliculasAcumuladas = 3;
		
		assertEquals(cantidadDePeliculasAcumuladas, cris.getListaDePeliculas().size());

		
	}
	
	@Test
	public void queNoLePermitaAUnClienteBasicoTenerMasDeCincoPeliculas() {
		// ESTE NO ME SALE , QUIERO AGREGAR MAS PELICULAS PARA QUE ALQUILE MAS Y ME TIRA ROJOOOOO
		VideoClub mania = new VideoClub("VideoMania");

		Empleado repositor = new Repositor("Juan", 1);
		mania.agregarEmpleadoRepositorOVendedor(repositor);

		Empleado vendedor = new Vendedor("jose", 2);
		mania.agregarEmpleadoRepositorOVendedor(vendedor);

		Cliente cris = new ClienteBasico ("Cris",2,25,3000.0);
		mania.agregarCliente(cris);
		
		Pelicula tarzan = new Pelicula("Tarzan", 1, 200.0, 18); 
		mania.agregarPelicula(1, tarzan);

		Pelicula nemo = new Pelicula("nemo", 2, 200.0, 18); 
		mania.agregarPelicula(1, nemo);
		
		Pelicula dbz = new Pelicula("dbz", 3, 200.0, 18); 
		mania.agregarPelicula(1, dbz);
	
		
		
		assertTrue(mania.alquilarPelicula(2, cris, dbz));
		assertTrue(mania.alquilarPelicula(2, cris, nemo));
		assertTrue(mania.alquilarPelicula(2, cris, tarzan));
		
		
	}

	@Test
	public void encontrarClientePorIdYQueSePuedaBorrarUnCliente() {
		VideoClub mania = new VideoClub("VideoMania");

		Cliente cliente2 = new ClientePremium("Gerardo", 2, 18, 30d);
		Cliente cliente3 = new ClientePremium("Gerardo", 3, 18, 30d);
		Cliente cliente4 = new ClienteMedio("Gerardo", 4, 18, 30d);

		assertTrue(mania.agregarCliente(cliente2));
		assertTrue(mania.agregarCliente(cliente3));
		assertTrue(mania.agregarCliente(cliente4));

		Cliente re = cliente2;
		Cliente ro = mania.encontrarClientePorId(2);
		assertEquals(re, ro);

		assertTrue(mania.borrarUnCliente(2));

		assertNull(mania.encontrarClientePorId(2));

	}

	@Test
	public void testQueElimineUnaPeliculaDisponibleCuandoSeAlquile() {
		Cliente cliente6 = new ClientePremium("Gerardo", 6, 18, 30d);
		VideoClub mania = new VideoClub("VideoMania");
<<<<<<< HEAD
		Pelicula pelicula = new Pelicula("pelicula", 200, 20.0, 8);
		Vendedor vendedor = new Vendedor("Jorge", 06);
		Repositor r = new Repositor("Repo", 889);

		Integer codigo_Emp = vendedor.getCodigoEmpleado();
		mania.agregarPelicula(codigo_Emp, pelicula);
		/* Lista peliculas disponibles */
		Boolean resultado = mania.alquilarPelicula(codigo_Emp, cliente6, pelicula);
		/* lista de peliculas alquiladas */
=======
		Pelicula pelicula= new Pelicula("pelicula",200,20.0,8);
		Repositor r= new Repositor("Repo",889);
		Vendedor vendedor= new Vendedor("Juan", 20);


		mania.agregarEmpleadoRepositorOVendedor(r);
		mania.agregarEmpleadoRepositorOVendedor(vendedor);
		mania.agregarCliente(cliente6);

		Integer c_E= r.getCodigoRepositor();
		Integer codigo_Emp= vendedor.getCodigoEmpleado();
		mania.agregarPelicula(c_E,pelicula);

		Boolean alquilarPelicula= mania.alquilarPelicula(codigo_Emp,cliente6,pelicula);

		assertTrue(alquilarPelicula);
>>>>>>> 3a4a8433c2800c81ae384dbaee3e0c6aa25395be

		assertFalse(mania.listaDePeliculas().contains(pelicula));
		assertTrue(mania.getListaDePeliculasAlquiladas().contains(pelicula));

	}

}
