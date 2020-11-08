package ar.edu.unlam.videoClub;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestClientes {

//TEST GENERALES CLIENTES ___________________________________________________________________________________//

	@Test
	public void testQueMePermitaCrearUnClienteBMPYUnaPelicula() {
		Cliente cris = new ClienteBasico("Cris", 1, 22, 500.0); // polimorfismo.
		Cliente pepe = new ClienteMedio("pepe", 2, 40, 1000.0);
		Cliente roberto = new ClientePremium("roberto", 3, 20, 300.0);

		Pelicula peli = new Pelicula("Godzilla", 25, 400.0, 18);

		assertNotNull(peli);
		assertNotNull(cris);
		assertNotNull(pepe);
		assertNotNull(roberto);

	}

	@Test
	public void testQueNoMePermitaAgregarUnaPeliculaPorNoAlcanzarleElDinero() {
		Cliente cris = new ClienteBasico("Cris", 1, 22, 300.0);
		Pelicula peli = new Pelicula("Godzilla", 25, 400.0, 18);

		assertFalse(cris.alquilarPelicula(peli)); // No me permite porque cris no tiene 400 pesos para la peli.

	}

	@Test
	public void testQueMeMuestraSiUnClienteTieneUnaPelicula() {
		Cliente cris = new ClienteBasico("Cris", 1, 22, 500.0); // le alcanza,
		Pelicula peli = new Pelicula("Godzilla", 25, 400.0, 18);

		assertTrue(cris.alquilarPelicula(peli));

		assertEquals(peli, cris.buscarSiTieneUnaPelicula(peli)); // este metodo va a ser util para videoClub, al buscar
																	// las peliculas que tiene un cliente. devuelve una
																	// peli.

	}

	@Test
	public void testQueMePermitaDevolverUnaPeliculaYQueNoPuedaDevolverUnaQueNoTiene() {
		Cliente cris = new ClienteBasico("Cris", 1, 22, 500.0);
		Pelicula peli = new Pelicula("Godzilla", 25, 400.0, 18);

		cris.alquilarPelicula(peli);

		cris.devolverPelicula(peli);

		assertEquals(null, cris.buscarSiTieneUnaPelicula(peli));

		assertFalse(cris.devolverPelicula(peli)); // no puede devolver una pelicula que ya devolvio.
	}

//TEST CLIENTES BASICOS ___________________________________________________________________________________//

	@Test
	public void testQueMePermitaAlquilarUnaPeliculaClienteBasico() {
		Cliente cris = new ClienteBasico("Cris", 1, 22, 500.0);
		Pelicula peli = new Pelicula("Godzilla", 25, 400.0, 18);
		Pelicula peli1 = new Pelicula("nemo", 25, 400.0, 18);

		assertTrue(cris.alquilarPelicula(peli));
		assertFalse(cris.alquilarPelicula(peli)); // tampoco me deja agregar peliculas repetidas, (Cuando su codigo es
													// el mismo)

	}

	@Test
	public void testQueNoMePermitaAgregarUnaPeliculaPorSerMenorDeLaEdadRequeridaClienteBasico() {
		Cliente cris = new ClienteBasico("Cris", 1, 17, 500.0);
		Pelicula peli = new Pelicula("Godzilla", 25, 400.0, 18);

		assertFalse(cris.alquilarPelicula(peli)); // No me permite porque cris es menor de 18 años
	}

	@Test
	public void testQueVerificaQueDescontoElDineroDelClienteBasicoSinDescuento() {
		Cliente cris = new ClienteBasico("Cris", 1, 22, 500.0); // le alcanza,
		Pelicula peli = new Pelicula("Godzilla", 25, 400.0, 18);

		cris.alquilarPelicula(peli);

		Double ve = 100.0;

		assertEquals(ve, cris.getDinero());// se le desconoto los 400.

	}

	@Test
	public void testQueNoMePermiteQueUnClienteBasicoTengaMasDe5Productos() {
		Cliente cris = new ClienteBasico("Cris", 1, 22, 7000.0); // le alcanza,
		Pelicula peli = new Pelicula("Godzilla", 25, 400.0, 18);
		Pelicula peli2 = new Pelicula("tarzan", 2, 400.0, 18);
		Pelicula peli3 = new Pelicula("titanic", 30, 400.0, 18);
		Pelicula peli4 = new Pelicula("dbz", 5, 400.0, 18);
		Pelicula peli5 = new Pelicula("nose", 125, 400.0, 18);
		Pelicula peli6 = new Pelicula("otrs", 15, 400.0, 18);

		cris.alquilarPelicula(peli);
		cris.alquilarPelicula(peli2);
		cris.alquilarPelicula(peli3);
		cris.alquilarPelicula(peli4);
		assertTrue(cris.alquilarPelicula(peli5));
		assertFalse(cris.alquilarPelicula(peli6)); // como es cliente basico no puede tener mas de 5 pelis.

	}

//TEST  CLIENTES MEDIOS ___________________________________________________________________________________//

	@Test
	public void testQueMePermitaAlquilarUnaPeliculaClienteMedio() {
		Cliente cris = new ClienteMedio("Cris", 1, 22, 500.0);
		Pelicula peli = new Pelicula("Godzilla", 25, 400.0, 18);

		assertTrue(cris.alquilarPelicula(peli));

	}

	@Test
	public void testQueNoMePermitaAgregarUnaPeliculaPorSerMenorDeLaEdadRequeridaClienteMedio() {
		Cliente cris = new ClienteMedio("Cris", 1, 17, 500.0);
		Pelicula peli = new Pelicula("Godzilla", 25, 400.0, 18);

		assertFalse(cris.alquilarPelicula(peli)); // No me permite porque cris es menor de 18 años
	}

	@Test
	public void testQueVerificaQueDescontoElDineroDelClienteMedio10Porciento() {
		Cliente cris = new ClienteMedio("Cris", 1, 22, 500.0); // le alcanza,
		Pelicula peli = new Pelicula("Godzilla", 25, 400.0, 18);

		cris.alquilarPelicula(peli);// me deberia aplicar 10porciento de descuento por ser cliente medio

		Double ve = 140.0;

		assertEquals(ve, cris.getDinero());// se le desconoto 400 MENOS EL 10%

	}

	@Test
	public void testQueNoMePermiteQueUnClienteMedioTengaMasDe10Productos() {
		Cliente cris = new ClienteMedio("Cris", 1, 22, 7000.0);
		Pelicula peli = new Pelicula("Godzilla", 2, 400.0, 18);
		Pelicula peli2 = new Pelicula("tarzan", 3, 400.0, 18);
		Pelicula peli3 = new Pelicula("titanic", 4, 400.0, 18);
		Pelicula peli4 = new Pelicula("dbz", 5, 400.0, 18);
		Pelicula peli5 = new Pelicula("nose", 6, 400.0, 18);
		Pelicula peli6 = new Pelicula("otrs", 7, 400.0, 18);
		Pelicula peli7 = new Pelicula("nemo", 8, 400.0, 18);
		Pelicula peli8 = new Pelicula("it", 9, 400.0, 18);
		Pelicula peli9 = new Pelicula("harry potter", 10, 400.0, 18);
		Pelicula peli10 = new Pelicula("ni idea", 11, 400.0, 18);
		Pelicula peli11 = new Pelicula("ni", 12, 400.0, 18);

		cris.alquilarPelicula(peli);
		cris.alquilarPelicula(peli2);
		cris.alquilarPelicula(peli3);
		cris.alquilarPelicula(peli4);
		cris.alquilarPelicula(peli5);
		cris.alquilarPelicula(peli6); // como es cliente basico no puede tener mas de 5 pelis.
		cris.alquilarPelicula(peli7);
		cris.alquilarPelicula(peli8);
		cris.alquilarPelicula(peli9);
		assertTrue(cris.alquilarPelicula(peli10));
		assertFalse(cris.alquilarPelicula(peli11)); // no me deja alquilar 11 peliculas.

	}
	

//TEST  CLIENTES PREMIUM ___________________________________________________________________________________//
	@Test
	public void testQueMePermitaAlquilarUnaPeliculaClientePremium() {
		Cliente cris = new ClientePremium("Cris", 1, 22, 400.0);
		Pelicula peli = new Pelicula("Godzilla", 25, 400.0, 18);

		assertTrue(cris.alquilarPelicula(peli));

	}
	
	@Test
	public void testQueMePermitaAgregarUnaPeliculaInclusoSiendoMenorDeLaEdadRequeridaClientePremium() {
		Cliente cris = new ClientePremium("Cris", 1, 17, 500.0);
		Pelicula peli = new Pelicula("Godzilla", 25, 400.0, 18);

		assertTrue(cris.alquilarPelicula(peli)); // Me permite aun siendo menor de la edad xq es premium
	}
	
	
	
	@Test
	public void testQueVerificaQueDescontoElDineroDelClientePremium30Porciento() {
		Cliente cris = new ClientePremium("Cris", 1, 22, 1000.0); // le alcanza,
		Pelicula peli = new Pelicula("Godzilla", 25, 500.0, 18);

		cris.alquilarPelicula(peli);// me deberia aplicar 30 porciento de descuento por ser cliente premium

		Double ve = 650.0;

		assertEquals(ve, cris.getDinero());// se le desconoto 500 MENOS EL 30%

	}
	
}
