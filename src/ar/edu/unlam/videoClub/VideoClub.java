package ar.edu.unlam.videoClub;

import java.util.HashSet;
	/*En realidad esto tendría que ser lo más basico de todo si es que
	estamos respetando la jerarquia/herencia real (Mariano)
	 */
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
		Empleado empleadoRepositor=encontrarEmpleadoPorId(codigoRepositor);
		
		if(empleadoRepositor!=null) {
			resultado=((Repositor)empleadoRepositor).agregarNuevaPelicula(nueva);
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
	
	private Pelicula encontrarPeliculaDisponiblePorId(Integer id) {//La busta entre las listas de peliculas y alquiladas 
		this.listaPeliculas=listaDePeliculas();
		Pelicula resultado=null;
		for(Pelicula prueba:this.listaPeliculas) {
			if(prueba.getCodigoPelicula().equals(id)) {
				resultado=prueba;
			}
		}
		return resultado;
	}
	
	
	public Boolean quitarPelicula(Integer codigoRepositor, Integer idPeliculaAQuitar) {
		Boolean resultado=false;
		Pelicula deposito=encontrarPeliculaDisponiblePorId(idPeliculaAQuitar);
		this.listaPeliculas=listaDePeliculas();
		
		if((encontrarEmpleadoPorId(codigoRepositor) instanceof Repositor)==true) {
			if(deposito!=null) {
		  resultado=((Repositor)encontrarEmpleadoPorId(codigoRepositor)).quitarPelicula(deposito);
			  }
		 }
		
		return resultado;
	}
	
	private Empleado encontrarEmpleadoPorId(Integer codigoRepositor) {//revisar
	    Empleado resultado=null;
		for(Empleado prueba:this.listaDeEmpleados) {
			if(prueba.getCodigoEmpleado().equals(codigoRepositor)) {
				resultado=prueba;	
			}
		}
		return resultado;
	}
	public Boolean alquilarPelicula(Integer codigoCliente,Integer codigoPelicula) {
		return null;
	}
	
	public HashSet<Pelicula> listaDePeliculas() {
		HashSet<Pelicula>peliculas=new HashSet<>();
		for(Empleado prueba:this.listaDeEmpleados) {
			if((prueba instanceof Repositor)==true ) {
				peliculas.addAll(((Repositor)prueba).getPeliculas());
			}
			
		}
		return peliculas;
	}
	
	
	public Boolean queSeaDeLaClaseClientePremium() {
		for(Cliente prueba:this.listaCliente) {
			if(prueba instanceof ClienteBasico) {
				return true;
			}
		}
		return false;
	}
	  

}
