package ar.edu.unlam.videoClub;

import java.util.HashSet;
	/*En realidad esto tendría que ser lo más basico de todo si es que
	estamos respetando la jerarquia/herencia real (Mariano)
	 */
public class VideoClub {
	private String nombre;
	private HashSet<Cliente>listaCliente;
	private HashSet<Pelicula>listaPeliculas;
	private HashSet<Repositor>listaRepositor;
	private HashSet<Pelicula>listaDePeliculasAlquiladas;
	
	VideoClub(String nombre){
		this.nombre=nombre;
		this.listaCliente = new HashSet<>();
		this.listaPeliculas = new HashSet<>();
		this.listaRepositor = new HashSet<>();
		this.listaDePeliculasAlquiladas=new HashSet<>();
	}
	public Boolean agregarCliente(Cliente nuevo) {
		return listaCliente.add(nuevo);
	}
	
	public Boolean agregarRepositor(Repositor nuevo) {
		return listaRepositor.add(nuevo);
	}
	
	public Boolean agregarPelicula(Integer codigoRepositor,Pelicula nueva) {
		Boolean resultado=false;
		if(existePelicula(nueva.getCodigoPelicula())==false) {
			for (Repositor empleadoRepositor : this.listaRepositor) {
			if (empleadoRepositor.getCodigoEmpleado().equals(codigoRepositor)) {
				resultado=empleadoRepositor.agregarNuevaPelicula(nueva);
			}
		}
		}
		
		return false;
	}
	private Boolean existePelicula(Integer id) {
		Boolean resultado=false;
		for(Pelicula prueba:this.listaPeliculas) {
			if(prueba.getCodigoPelicula().equals(id)) {
				resultado=true;
			}
		}
		for(Pelicula prueba:this.listaDePeliculasAlquiladas) {
			if(prueba.getCodigoPelicula().equals(id)){
				resultado=true;
			}
		}
		return false;
	}
	/*
	 * cambie la firma del metodo quitarPelicula (Integer codigoRepositor, Pelicula codigoDePelicula
	 * y usamos el metodo getCodigoDePelicula, no estoy muy seguro si esta bien (Alan)
	 */
	public Boolean quitarPelicula(Integer codigoRepositor, Pelicula peliculaAQuitar) {
		
		for (Pelicula pelicula : listaPeliculas) {
			if (agregarPelicula(codigoRepositor, peliculaAQuitar) == true) {
				listaPeliculas.remove(peliculaAQuitar);
				return true;
			}
		}
		return false;
	}
	
	public Boolean alquilarPelicula(Integer codigoCliente,Integer codigoPelicula) {
		return null;
	}
	public HashSet<Pelicula> listaDePeliculas() {
		HashSet<Pelicula>peliculas=new HashSet<>();
		for(Repositor prueba:this.listaRepositor) {
			peliculas.addAll(prueba.getPeliculas());
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
