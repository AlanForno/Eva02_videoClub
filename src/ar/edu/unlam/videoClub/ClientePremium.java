package ar.edu.unlam.videoClub;

import java.util.HashSet;
import java.util.Objects;

public class ClientePremium extends Cliente {

	public ClientePremium(String nombre, Integer codigoCliente, Integer edad, Double dinero) {
		super(nombre, codigoCliente, edad, dinero);
		porcentaje = 30.0; // SE LE VA HACER UN 30 % DE DESCUENTO AL VALOR DE LA PELICULA.
		listaDePeliculas = new HashSet<Pelicula>(); // NO TIENE LIMITES DE PELICULAS

	}

	@Override
	public Boolean alquilarPelicula(Pelicula pelicula) {
		if (dinero - pelicula.getValor() >= 0) {

			dinero -= pelicula.getValor() - ((porcentaje * pelicula.getValor()) / 100);
			// dinero es igual a el valor de la pelicula menos el descuento de la pelicula.

			return listaDePeliculas.add(pelicula); // no es necesario que el cliente premium valide ni la edad, ni si
													// alcanzo el limite de peliculas, si que tenga el dinero suficiente
													// y que el elemento no este repetido
		}
		return false;
	}
}