package ar.edu.unlam.videoClub;

import java.util.HashSet;
import java.util.Objects;

public class Repositor extends Empleado{
	private Integer codigoRepositor;
	private String nombre;
	/*private HashSet<Pelicula> peliculas;*/

	public Repositor(String nombre, Integer codigoEmpleado) {
		super(nombre, codigoEmpleado);
		this.codigoRepositor = codigoEmpleado;
		this.nombre = nombre;
	}

	public Boolean agregarNuevaPelicula(HashSet<Pelicula> listaPeliculas, Pelicula nueva){
		listaPeliculas.add(nueva);
		return true;
	}
	
	public Boolean quitarPelicula(HashSet<Pelicula> listaPeliculas, Pelicula deposito) {
		listaPeliculas.remove(deposito);
		return true;
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
	/*
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Repositor repositor = (Repositor) o;
		return peliculas.equals(repositor.peliculas);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), peliculas);
	}

	Lo comento porque ya no era funcional al eliminar el HashSet<Pelicula> peliculas
	*/
}