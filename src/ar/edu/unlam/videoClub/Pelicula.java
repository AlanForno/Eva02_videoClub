package ar.edu.unlam.videoClub;

public class Pelicula {
	
	private String nombre;
	private Integer codigoPelicula;
	private Double valor;
	private Integer aptaParaMayoresDe;

	public Pelicula(String nombre, Integer codigoPelicula, Double valor, Integer aptaParaMayoresDe){
		this.nombre = nombre;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoPelicula == null) ? 0 : codigoPelicula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) { //dos objetos pelicula son iguales cuando su codigo es igual.
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		if (codigoPelicula == null) {
			if (other.codigoPelicula != null)
				return false;
		} else if (!codigoPelicula.equals(other.codigoPelicula))
			return false;
		return true;
	}

	

	
	
	

}
