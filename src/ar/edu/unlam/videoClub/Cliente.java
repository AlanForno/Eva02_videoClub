package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class Cliente {
	private String nombre;
	private Integer codigoCliente;
	private HashSet<Pelicula> peliculasAlquiladas;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public HashSet<Pelicula> getPeliculasAlquiladas() {
		return peliculasAlquiladas;
	}
	public void setPeliculasAlquiladas(HashSet<Pelicula> peliculasAlquiladas) {
		this.peliculasAlquiladas = peliculasAlquiladas;
	}
	
	
	
	

}
