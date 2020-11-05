package ar.edu.unlam.videoClub;

public class Pelicula {
	
	private String nombre;
	private Integer codigoPelicula;

	public Pelicula(String nombre, Integer codigoPelicula){
		this.nombre=nombre;
		this.codigoPelicula=codigoPelicula;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Integer getCodigoPelicula() {
		return codigoPelicula;
	}
	
	public void setCodigoPelicula(Integer codigoPelicula) {
		this.codigoPelicula = codigoPelicula;
	}
	
	

}
