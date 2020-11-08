package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class Vendedor extends Empleado{
	
	private String nombre;
	private Integer codigoVendedor;
	private HashSet<Pelicula> peliculas;
	
	private Integer cantidadPeliculasAlquladas;

	public Vendedor(String nombre, Integer codigoEmpleado) {
		super(nombre, codigoEmpleado);
		this.nombre = nombre;
		this.codigoVendedor = codigoEmpleado;
	}

	/*
	 * modifique la firma del segundo parametro (codigoDePelicula) porque 
	 * con el primer parametro al ser de tipo objeto ya podemos sacar informacion 
	 * del objeto pelicula (nombre, codigo, precio, etc)
	 */
	public void alquilarPeliculas(Pelicula pelicula, Cliente cliente) {
		/* en este caso puse .remove porque
			alquila una pelicula, osea, la saca de la lista

			No se como se utilizaría codigoPelicula y cliente

			(Mariano)
		 */
		/*
		 * esto de aca no se si esta bien pero deberia copiar el objeto pasado por parametro
		 * (cliente) hacia la variable clienteEjemplo
		 */
		Cliente clienteEjemplo = cliente;
		
		clienteEjemplo.alquilarPelicula(pelicula);
		peliculas.remove(pelicula);
		cantidadPeliculasAlquladas++;
	}
	
	public Integer obtenerCantidadDePeliculasAlquiladas() {
		return cantidadPeliculasAlquladas;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public Integer getCodigoVendedor() {
		return codigoVendedor;
	}
	
}