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

	public Boolean agregarNuevaPelicula(HashSet<Pelicula> listaPeliculas, HashSet <Pelicula> listaDePeliculasAlquiladas, Pelicula nueva){
		/*Boolean agregar=false;
		Boolean alq=true;*/
		//Boolean resultado=true;

		/*for (Pelicula x: listaPeliculas) {
			if (x.getCodigoPelicula().equals(nueva.getCodigoPelicula())){
				agregar=false;
			}
		}
		for (Pelicula x: listaDePeliculasAlquiladas){
			if (x.getCodigoPelicula().equals(nueva.getCodigoPelicula())){
				alq=false;
			}
		}
		if (agregar==true && alq==true){
			resultado=listaPeliculas.add(nueva);
		}
		return resultado;

		Comento todo este codigo porque no me daba los resultados esperados (al menos en mi test personal)
		*/
		return listaPeliculas.add(nueva);
	}
	
	public Boolean quitarPelicula(HashSet<Pelicula> listaPeliculas, Pelicula deposito) {

		return listaPeliculas.remove(deposito);
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