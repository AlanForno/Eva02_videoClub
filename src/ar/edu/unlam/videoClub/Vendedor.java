package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class Vendedor {
	private String nombre;
	private Integer codigoVendedor;
	private HashSet<Pelicula>peliculas;
	
	public Vendedor(String nombre, Integer codigoVendedor){
		this.nombre=nombre;
		this.codigoVendedor=codigoVendedor;
	}
	
	public void alquilarPeliculas(Pelicula pelicula,Integer codigoPelicula,Cliente cliente) {
		/* en este caso puse .remove porque
			alquila una pelicula, osea, la saca de la lista

			No se como se utilizaría codigoPelicula y cliente

			(Mariano)
		 */
		peliculas.remove(pelicula);
	}

}
