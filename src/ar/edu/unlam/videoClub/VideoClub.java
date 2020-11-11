package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class VideoClub {
	private String nombre;
	private HashSet<Cliente> listaCliente;
	private HashSet<Pelicula> listaPeliculas;

	private HashSet<Empleado> listaDeEmpleados;
	private HashSet<Pelicula> listaDePeliculasAlquiladas;

	VideoClub(String nombre) {
		this.nombre = nombre;
		this.listaCliente = new HashSet<>();
		this.listaPeliculas = new HashSet<>();
		this.listaDeEmpleados = new HashSet<>();
		this.listaDePeliculasAlquiladas = new HashSet<>();
	}

	public Boolean agregarCliente(Cliente nuevo) {
		for (Cliente cliente : listaCliente) { // este codigo para que no me deje agregar un cliente B,M,P si tienen el
												// mismo codigo
			if (cliente != null) {
				if (cliente.getCodigoCliente().equals(nuevo.getCodigoCliente())) {
					return false;
				}
			}
		}
		return listaCliente.add(nuevo);
	}

	public Boolean agregarEmpleadoRepositorOVendedor(Empleado nuevo) {
		for (Empleado empleado : listaDeEmpleados) { // este codigo para que no me deje agregar un Empleado V,R si
														// tienen el
			// mismo codigo
			if (empleado != null) {
				if (empleado.getCodigoEmpleado().equals(nuevo.getCodigoEmpleado())) {
					return false;
				}
			}
		}
		return listaDeEmpleados.add(nuevo);
	}

	public Boolean agregarPelicula(Integer codigoRepositor, Pelicula nueva) {
		Boolean resultado = false;
		Empleado empleadoRepositor =encontrarEmpleadoPorId(codigoRepositor);

		if (empleadoRepositor != null) {
			if ((empleadoRepositor instanceof Repositor) == true) {
				resultado = ((Repositor)empleadoRepositor).agregarNuevaPelicula(this.listaPeliculas, this.listaDePeliculasAlquiladas,	nueva);
			}
		}

		return resultado;
	}

	public Boolean quitarPelicula(Integer codigoRepositor, Pelicula nueva) {
		Empleado empleado = encontrarEmpleadoPorId(codigoRepositor);
		Boolean resultado = false;

		if (empleado != null) {
			if ((empleado instanceof Repositor) == true) {
				resultado = ((Repositor) empleado).quitarPelicula(this.listaPeliculas, nueva);
			}
		}
		return resultado;
	}

	public Boolean alquilarPelicula(Integer idVendedor, Cliente cliente, Pelicula pelicula) {
		Empleado vendedor = encontrarEmpleadoPorId(idVendedor);
		Boolean resultado = false;

		if (vendedor != null) {
			if ((vendedor instanceof Vendedor) == true) {
				resultado = ((Vendedor) vendedor).alquilarACliente(this.listaCliente, cliente, this.listaPeliculas,
						pelicula, this.listaDePeliculasAlquiladas);
			}
		}

		return resultado;
	}

	public Boolean devolverPelicula(Integer idVendedor, Cliente cliente, Pelicula pelicula) {
		Empleado vendedor = encontrarEmpleadoPorId(idVendedor);
		Boolean resultado = false;

		if (vendedor != null) {
			if ((vendedor instanceof Vendedor) == true) {
				resultado = ((Vendedor) vendedor).recibirPelicula(this.listaCliente, cliente, this.listaPeliculas,
						pelicula, this.listaDePeliculasAlquiladas);
			}
		}

		return resultado;
	}

	public Boolean despedirEmpleado(Integer idEmpleado) {
		Boolean resultado = false;
		Empleado empleado = encontrarEmpleadoPorId(idEmpleado);

		for (Empleado prueba : this.listaDeEmpleados) {
			if (prueba.getCodigoEmpleado().equals(empleado.getCodigoEmpleado())) {
				resultado = this.listaDeEmpleados.remove(prueba);
				break;
			}
		}
		return resultado;
	}

	public Integer cantidadDeClientesBasico() {
		Integer clientesbasico = 0;

		for (Cliente prueba : this.listaCliente) {
			if (prueba instanceof ClienteBasico) {
				clientesbasico++;
			}
		}
		return clientesbasico;

	}

	public Integer cantidadDeClientesMedio() {
		Integer clientesMedio = 0;

		for (Cliente prueba : this.listaCliente) {
			if (prueba instanceof ClienteMedio) {
				clientesMedio++;
			}
		}
		return clientesMedio;

	}

	public Integer cantidadDeClientesPremium() {
		Integer clientePremium = 0;

		for (Cliente prueba : this.listaCliente) {
			if (prueba instanceof ClientePremium) {
				clientePremium++;
			}
		}
		return clientePremium;

	}

	public HashSet<Pelicula> listaDePeliculas() {
		return this.listaPeliculas;
	}

	public HashSet<Cliente> getListaCliente() {
		return listaCliente;
	}

	public HashSet<Empleado> getListaDeEmpleados() {
		return listaDeEmpleados;
	}

	public HashSet<Pelicula> getListaDePeliculasAlquiladas() {
		return listaDePeliculasAlquiladas;
	}

	public Boolean borrarUnCliente(Integer idCliente) {
		Boolean resultado = false;
		for (Cliente cliente : this.listaCliente) {
			if (cliente.equals(encontrarClientePorId(idCliente))) {
				resultado = this.listaCliente.remove(cliente);
				break;
			}
		}
		return resultado;
	}

	public Cliente encontrarClientePorId(Integer idCliente) {
		for (Cliente cliente : this.listaCliente) {
			if (cliente.getCodigoCliente().equals(idCliente)) {
				return cliente;
			}
		}
		return null;
	}

	public Boolean existeLaPelicula(Integer nroPelicula) {
		Pelicula resultado = encontrarPeliculaDisponiblePorId(nroPelicula);
		Boolean respuesta = false;
		if (resultado != null) {
			respuesta = true;
		}
		return respuesta;
	}

	public Cliente quienAlquilarLaPelicula(Integer idPelicula) {
		Cliente resultado = null;
		Pelicula pelicula1 = encontrarPeliculaAlquilada(idPelicula);

		if (pelicula1 != null) {
			for (Cliente cliente : this.listaCliente) {
				for (Pelicula pelicula : cliente.getListaDePeliculas()) {
					if (pelicula.equals(pelicula1)) {
						resultado = cliente;
						return resultado;
					}
				}
			}
		}

		return resultado;
	}

	// Aca empizan los metodos Privados
	private Empleado encontrarEmpleadoPorId(Integer codigoRepositor) {// revisar
		Empleado resultado = null;
		for (Empleado prueba : this.listaDeEmpleados) {
			if (prueba.getCodigoEmpleado().equals(codigoRepositor)) {
				resultado = prueba;
				break;
			}
		}
		return resultado;
	}

	private Pelicula encontrarPeliculaDisponiblePorId(Integer id) {// La busta entre las listas de peliculas y
																	// alquiladas
		Pelicula resultado = null;
		for (Pelicula prueba : this.listaPeliculas) {
			if (prueba.getCodigoPelicula().equals(id)) {
				resultado = prueba;
			}
		}
		return resultado;
	}

	private Pelicula encontrarPeliculaAlquilada(Integer idPelicula) {
		Pelicula resultado = null;
		for (Pelicula prueba : this.listaDePeliculasAlquiladas) {
			if (prueba.getCodigoPelicula().equals(idPelicula)) {
				resultado = prueba;
			}
		}
		return resultado;
	}

}