package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class VideoClub {
	private String nombre;
	private HashSet<Cliente>listaCliente;
	private HashSet<Pelicula>listaPaliculas;
	private HashSet<Repositor>listaRepositor;
	
	VideoClub(String nombre){
		this.nombre=nombre;
		this.listaCliente=new HashSet<>();
		this.listaPaliculas=new HashSet<>();
		this.listaRepositor=new HashSet<>();
		
	}
	public Boolean agregarCliente(Cliente nuevo) {
		return null;
	}
	
	public Boolean agregarRepositor(Repositor nuevo) {
		return null;
	}
	public Boolean agregarPelicula(Integer codigoRepositor,Pelicula nueva) {
		return null;
	}
	public Boolean quitarPelicula(Integer codigoRepositor,Integer codigoDePelicula) {
		return null;
	}
	
	public Boolean alquilarPelicula(Integer codigoCliente,Integer codigoPelicula) {
		return null;
	}
	public HashSet<Pelicula> listaDePeliculas() {
		HashSet<Pelicula>peliculas=new HashSet<>();
		for(Repositor prueba:this.listaRepositor) {
			peliculas.addAll(prueba.getPaliculasParaAgregar());
		}
		return peliculas;
	}
	  

}
