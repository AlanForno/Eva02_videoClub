package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class Repositor {
	private Integer codigoRepositor;
	private String nombre;
	private HashSet<Pelicula> peliculasParaQuitar;
	private HashSet<Pelicula> paliculasParaAgregar;
	
	Repositor(String nombre,Integer codigoRepositor){
		this.nombre=nombre;
		this.codigoRepositor=codigoRepositor;
	}
	
	public Boolean agregarNuevaPelicula() {
		return null;
	}
	
	public Boolean quitarPelicula(HashSet<Pelicula>listaDePeliculas) {
		return null;
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

	public HashSet<Pelicula> getPeliculasParaQuitar() {
		return peliculasParaQuitar;
	}

	public void setPeliculasParaQuitar(HashSet<Pelicula> peliculasParaQuitar) {
		this.peliculasParaQuitar = peliculasParaQuitar;
	}

	public HashSet<Pelicula> getPaliculasParaAgregar() {
		return paliculasParaAgregar;
	}

	public void setPaliculasParaAgregar(HashSet<Pelicula> paliculasParaAgregar) {
		this.paliculasParaAgregar = paliculasParaAgregar;
	}
	

}
