package ar.edu.unlam.videoClub;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVC {

	@Test
	public void test() {

		VideoClub mania=new VideoClub("VideoMania");
		Cliente yo=new ClientePremium("Gerardo",1,18,30d);
		Empleado nuevo=new Repositor("Cristian",1);
		Pelicula accion=new Pelicula("Rambo",1,30d,18);
		
		
		assertTrue(mania.agregarCliente(yo));
		assertTrue(mania.agregarEmpleadoRepositorOVendedor(nuevo));
		
		assertTrue(mania.agregarPelicula(1, accion));
		assertTrue(mania.existeLaPelicula(1));
		
	}

	@Test
	public void testuno() {

		VideoClub mania=new VideoClub("VideoMania");
		Cliente yo=new ClientePremium("Gerardo",1,18,30d);
		
		assertTrue(mania.agregarCliente(yo));
		
	}
	@Test 
	public void queSePuedanAgregarClientesYCantidadDeUsuariosPremium() {
		VideoClub mania=new VideoClub("VideoMania");
		Cliente cliente1=new ClientePremium("Gerardo",1,18,30d);
		Cliente cliente2=new ClientePremium("Gerardo",2,18,30d);
		Cliente cliente3=new ClientePremium("Gerardo",3,18,30d);
		Cliente cliente4=new ClienteMedio("Gerardo",4,18,30d);
		
		assertTrue(mania.agregarCliente(cliente1));
		assertTrue(mania.agregarCliente(cliente2));
		assertTrue(mania.agregarCliente(cliente3));
		assertTrue(mania.agregarCliente(cliente4));
		
		Integer re=3;
		Integer ro=mania.cantidadDeClientesPremium();
		
		assertEquals(re,ro);
		
	}
}
