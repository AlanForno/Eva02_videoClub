package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class VideoClub {
	private String nombre;
	private HashSet<Cliente>listaCliente;
	private HashSet<Pelicula>listaPeliculas;

	private HashSet<Empleado>listaDeEmpleados;
	private HashSet<Pelicula>listaDePeliculasAlquiladas;
	
	VideoClub(String nombre){
		this.nombre=nombre;
		this.listaCliente = new HashSet<>();
		this.listaPeliculas = new HashSet<>();
		this.listaDeEmpleados = new HashSet<>();
		this.listaDePeliculasAlquiladas=new HashSet<>();
	}
	
	public Boolean agregarCliente(Cliente nuevo) {
		return listaCliente.add(nuevo);
	}
	public Boolean agregarEmpleadoRepositorOVendedor(Empleado nuevo) {
		return listaDeEmpleados.add(nuevo);
	}
	
	public Boolean agregarPelicula(Integer codigoRepositor,Pelicula nueva) {//En teorio estaria terminada
		Boolean resultado=false;
		Repositor empleadoRepositor=((Repositor)encontrarEmpleadoPorId(codigoRepositor));
		
		if(empleadoRepositor!=null) {
			if((empleadoRepositor instanceof Repositor)==true) {
				resultado = empleadoRepositor.agregarNuevaPelicula(this.listaPeliculas,this.listaDePeliculasAlquiladas, nueva);
			}
		}
		
		return resultado;
	}
	
	public Boolean quitarPelicula(Integer codigoRepositor,Pelicula nueva) {
		Empleado empleado=encontrarEmpleadoPorId(codigoRepositor);
		Boolean resultado=false;
		
		if(empleado!=null) {
			if((empleado instanceof Repositor)==true) {
				resultado=((Repositor)empleado).quitarPelicula(this.listaPeliculas,nueva);
			}
		}
		return null;
	}
	
	
	public Boolean alquilarPelicula(Integer idVendedor, Cliente cliente,Pelicula pelicula) {
		Empleado vendedor=encontrarEmpleadoPorId(idVendedor);
		Boolean resultado=false;
		
		if(vendedor!=null) {
			if((vendedor instanceof Vendedor)==true) {
			resultado=((Vendedor)vendedor).alquilarACliente(this.listaCliente, cliente, this.listaPeliculas, pelicula, this.listaDePeliculasAlquiladas);
		 }
		}
		
		
		return resultado;
	}
	
	public Boolean devolverPelicula(Integer idVendedor, Cliente cliente,Pelicula pelicula) {
		Empleado vendedor=encontrarEmpleadoPorId(idVendedor);
		Boolean resultado=false;
		
		if(vendedor!=null) {
			if((vendedor instanceof Vendedor)==true) {
			resultado=((Vendedor)vendedor).recibirPelicula(this.listaCliente, cliente, this.listaPeliculas, pelicula, this.listaDePeliculasAlquiladas);
		}
		}
		
		
		return resultado;
	}
	
	public Boolean despedirEmpleado(Integer idEmpleado) {
		Boolean resultado=false;
		Empleado empleado=encontrarEmpleadoPorId(idEmpleado);
		
		for(Empleado prueba:this.listaDeEmpleados) {
			if(prueba.equals(empleado)) {
				resultado=this.listaDeEmpleados.remove(prueba);
			}
		}
		return resultado;
	}
	
	public String cantidadDeClientesPorCategoria() {
		Integer clienteBasico=0;
		Integer clienteMedio=0;
		Integer clientePremium=0;
		
		for(Cliente cliente:this.listaCliente) {
			if(cliente instanceof ClienteBasico) {
				clienteBasico++;
			}else {if(cliente instanceof ClienteMedio) {
				clienteMedio++;
			}else{clientePremium++;}}
		}
		return "Cantidad"+'\n'+"clientes basicos="+clienteBasico+'\n'+"clientes medios="+clienteMedio+'\n'+"cientes premium="+clientePremium;
		
	}
	
	
	public HashSet<Pelicula> listaDePeliculas() {
		return this.listaPeliculas;
	}
	
	public HashSet<Cliente> getListaCliente() {
		return listaCliente;
	}

	public HashSet<Empleado> getListaDeEmpleados() {
		return listaDeEmpleados;
	}

	public HashSet<Pelicula> getListaDePeliculasAlquiladas() {
		return listaDePeliculasAlquiladas;
	}
	
	
	//Aca empizan los metodos Privados
	
	private Empleado encontrarEmpleadoPorId(Integer codigoRepositor) {//revisar
	    Empleado resultado=null;
		for(Empleado prueba:this.listaDeEmpleados) {
			if(prueba.getCodigoEmpleado().equals(codigoRepositor)) {
				resultado=prueba;	
			}
		}
		return resultado;
	}
	
	private Pelicula encontrarPeliculaDisponiblePorId(Integer id) {//La busta entre las listas de peliculas y alquiladas 
		Pelicula resultado=null;
		for(Pelicula prueba:this.listaPeliculas) {
			if(prueba.getCodigoPelicula().equals(id)) {
				resultado=prueba;
			}
		}
		return resultado;
	}
	
	private Pelicula encontrarPeliculaAlquilada(Integer idPelicula) {
		Pelicula resultado=null;
		for(Pelicula prueba:this.listaDePeliculasAlquiladas) {
			if(prueba.getCodigoPelicula().equals(idPelicula)) {
				resultado=prueba;
			}
		}
		return resultado;
	}
	
	  

}