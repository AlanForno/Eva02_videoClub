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

	public Boolean agregarNuevaPelicula(Pelicula pelicula) {
		return peliculas.add(pelicula);
	}
	
	public void quitarPelicula(Pelicula pelicula) {
		peliculas.remove(pelicula);
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

	public Integer getCodigoRepositor() {
		return codigoRepositor;
	}

	public void setCodigoRepositor(Integer codigoRepositor) {
		this.codigoRepositor = codigoRepositor;
	}

	@Override
	public String getNombre() {
		return nombre;
	}
	// elimine el metodo setNombre() porque no creo que sea necesario (Alan)

}