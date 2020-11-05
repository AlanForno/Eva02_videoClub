package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class Vendedor {
	private String nombre;
	private Integer codigoVendedor;
	private HashSet<Pelicula>peliculasAlquiladas;
	
	Vendedor(String nombre, Integer codigoVendedor){
		this.nombre=nombre;
		this.codigoVendedor=codigoVendedor;
	}
	
	public Boolean alquilarPeliculas(HashSet<Pelicula>listaDePeliculas,Integer codigoPelicula,Cliente cliente) {
		return null;
	}

}
