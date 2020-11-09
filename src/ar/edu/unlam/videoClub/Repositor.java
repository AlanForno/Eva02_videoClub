package ar.edu.unlam.videoClub;

import java.util.HashSet;
import java.util.Objects;

public class Repositor extends Empleado{
	private Integer codigoRepositor;
	private String nombre;

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



}