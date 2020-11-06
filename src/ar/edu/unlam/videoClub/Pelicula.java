package ar.edu.unlam.videoClub;

public class Pelicula {
	
	private String nombre;
	private Integer codigoPelicula;
	private Double valor;
	private Integer aptaParaMayoresDe;

	public Pelicula(String nombre, Integer codigoPelicula, Double valor, Integer aptaParaMayoresDe){
		this.nombre=nombre;
		this.codigoPelicula=codigoPelicula;
		this.valor = valor;
		this.aptaParaMayoresDe = aptaParaMayoresDe;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getAptaParaMayoresDe() {
		return aptaParaMayoresDe;
	}

	

	
	
	

}
