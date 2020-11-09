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
		assertTrue(mania.existe());
		
	}

	@Test
	public void testuno() {

		VideoClub mania=new VideoClub("VideoMania");
		Cliente yo=new ClientePremium("Gerardo",1,18,30d);
		
		assertTrue(mania.agregarCliente(yo));
		
	}
}
