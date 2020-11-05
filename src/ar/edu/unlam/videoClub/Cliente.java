package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class Cliente {
	private String nombre;
	private Integer codigoCliente;

	public Cliente(String nombre, Integer codigoCliente){
		this.nombre=nombre;
		this.codigoCliente=codigoCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
}
