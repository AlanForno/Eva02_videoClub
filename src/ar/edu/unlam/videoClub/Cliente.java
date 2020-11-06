package ar.edu.unlam.videoClub;

import java.util.HashSet;

public abstract class Cliente { // por defecto todos los clientes van a tener esto

	protected String nombre;

	protected Integer edad;

	protected Integer codigoCliente; // CODIGO UNICO PARA BUSCAR EL CLIENTE <----

	protected Integer limiteDePeliculas; // EL LIMITE DE PELICULAS SE INICIALIZA ES CADA CLASE HIJA CON SU RESPECTIVO
											// LIMITE
	protected HashSet<Pelicula> listaDePeliculas; // el cliente puede tener una lista de peliculas no repetidas, EL
													// TAMAÑO DEL HASHSET SE DEFINE EN LA CLASE HIJA
	protected Double porcentaje = 0.0; // EL DESCUENTO APLICADO A CADA TIPO DE CLIENTE, SE ESPECIFICA EN LA CLASE HIJA.

	protected Double dinero;

	public Cliente(String nombre, Integer codigoCliente, Integer edad, Double dinero) {
		this.nombre = nombre;
		this.codigoCliente = codigoCliente;
		this.edad = edad;
		this.dinero = dinero;
	}

	public boolean alquilarPelicula(Pelicula pelicula) {
		// en videoClub donde se va usar este metodo, al pasar por
		// parametro un cliente ya existente y una pelicula ya
		// existente, se va a recorrer la lista
		// de peliculas y la lista de clientes. si el cliente y la
		// pelicula pasadas por parametros existen en la lista entonces
		// se remueve esa pelicula de la lista y se la agrega a la lista
		// de ese cliente con el metodo comprar

		if (verificarSiLeAlcanzaYSiCumpleLaEdad(pelicula) == true) {
			// si este metodo valida todo ok.
			if (listaDePeliculas.add(pelicula) == true) {
				// si puede agregar una pelicula mas. (por el limite de peliculas)

				dinero -= pelicula.getValor() - ((porcentaje * pelicula.getValor()) / 100);
				// dinero es igual a el valor de la pelicula menos el descuento de la pelicula.

				listaDePeliculas.add(pelicula);
				return true;
				// si cumple los 2 if , lo agrega a la lista y le descuenta dinero
			}

			return false;
			// si cumple la primera pero la segunda no (debido a que se alcanzo el limite)
			// da false
		}
		return false;
		// si no verifica ni la primera , da false;
	}

	private boolean verificarSiLeAlcanzaYSiCumpleLaEdad(Pelicula pelicula) {
		if (dinero - pelicula.getValor() > 0) { // si al restarle a su dinero el valor de la pelicula sigue teniendo
												// dinero.
			if (edad > pelicula.getAptaParaMayoresDe()) {
				return true;
			}
			return false;

		}
		return false;
	}

	public boolean devolverPelicula(Pelicula pelicula) { // recibo por parametro la pelicula a devolver

		return listaDePeliculas.remove(pelicula); // remueve el elemento si lo contiene y es igual.

	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public HashSet<Pelicula> getListaDePeliculas() {
		return listaDePeliculas;
	}

	public void setListaDePeliculas(HashSet<Pelicula> listaDePeliculas) {
		this.listaDePeliculas = listaDePeliculas;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public Integer getLIMITEDEPELICULAS() {
		return limiteDePeliculas;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getLimiteDePeliculas() {
		return limiteDePeliculas;
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}

}
