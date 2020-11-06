package ar.edu.unlam.videoClub;

import java.util.HashSet;
import java.util.Objects;

public class ClienteMedio extends Cliente {

	public ClienteMedio(String nombre, Integer codigoCliente, Integer edad, Double dinero) {
		super(nombre, codigoCliente, edad, dinero);
		limiteDePeliculas = 10; // este cliente puede tener hasta 10 peliculas.
		porcentaje = 10.0; // este tipo de cliente va a tener 10 % de descuento.
		listaDePeliculas = new HashSet<Pelicula>(limiteDePeliculas); // su lista se limita a 10.

	}

}
