package ar.edu.unlam.videoClub;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVC {

	@Test
	public void queSePuedaAgregarUnaPeliculaYComprobarSuExistencia() {

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
	@Test 
	public void queNoAdmitaEmpleadosDuplicadosYQuitarEmpleados() {
		VideoClub mania=new VideoClub("VideoMania");
		Empleado empleado1=new Repositor("Cristian",1);
		Empleado empleado2=new Repositor("Cristian",2);
		Empleado empleado3=new Vendedor("Cristian",3);
		Empleado empleado4=new Vendedor("Cristian",4);
		
		assertTrue(mania.agregarEmpleadoRepositorOVendedor(empleado1));
		assertTrue(mania.agregarEmpleadoRepositorOVendedor(empleado2));
		assertTrue(mania.agregarEmpleadoRepositorOVendedor(empleado3));
		assertTrue(mania.agregarEmpleadoRepositorOVendedor(empleado4));
		assertFalse(mania.agregarEmpleadoRepositorOVendedor(empleado2));//Duplicado
		
		assertTrue(mania.despedirEmpleado(1));
		assertTrue(mania.despedirEmpleado(2));
		assertTrue(mania.despedirEmpleado(3));
		assertTrue(mania.despedirEmpleado(4));
		
		assertFalse(mania.despedirEmpleado(1));
		assertFalse(mania.despedirEmpleado(2));
		assertFalse(mania.despedirEmpleado(3));
		assertFalse(mania.despedirEmpleado(4));
	}
	
	@Test
	public void encontrarClientePorIdYQueSePuedaBorrarUnCliente() {
		VideoClub mania=new VideoClub("VideoMania");
		
		Cliente cliente2=new ClientePremium("Gerardo",2,18,30d);
		Cliente cliente3=new ClientePremium("Gerardo",3,18,30d);
		Cliente cliente4=new ClienteMedio("Gerardo",4,18,30d);
		
		
		assertTrue(mania.agregarCliente(cliente2));
		assertTrue(mania.agregarCliente(cliente3));
		assertTrue(mania.agregarCliente(cliente4));
		
		Cliente re=cliente2;
		Cliente ro=mania.encontrarClientePorId(2);
		assertEquals(re,ro);
		
		assertTrue(mania.borrarUnCliente(2));
		
		
		
		assertNull(mania.encontrarClientePorId(2));

		
	}
}
