package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class Repositor extends Empleado{
	private Integer codigoRepositor;
	private String nombre;
	/*private HashSet<Pelicula> peliculasParaQuitar;*/
	private HashSet<Pelicula> peliculas;

	public Repositor(String nombre, Integer codigoEmpleado) {
		super(nombre, codigoEmpleado);
		this.codigoRepositor = codigoEmpleado;
		this.nombre = nombre;
	}

	public void agregarNuevaPelicula(Pelicula pelicula) {
		peliculas.add(pelicula);
	}
	
	public void quitarPelicula(Pelicula pelicula) {
		peliculas.remove(pelicula);
	}

	public Integer getCodigoRepositor() {
		return codigoRepositor;
	}

	public void setCodigoRepositor(Integer codigoRepositor) {
		this.codigoRepositor = codigoRepositor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/*
	Comento estos codigos porque no me cierran mucho. (Mariano)

	public HashSet<Pelicula> getPeliculasParaQuitar() {
		return peliculasParaQuitar;
	}

	public void setPeliculasParaQuitar(HashSet<Pelicula> peliculasParaQuitar) {
		this.peliculasParaQuitar = peliculasParaQuitar;
	}*/

	public HashSet<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(HashSet<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	

}
