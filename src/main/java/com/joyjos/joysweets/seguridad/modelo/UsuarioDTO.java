package com.joyjos.joysweets.seguridad.modelo;

public class UsuarioDTO {
	
	private int idUsuario;
	private String nombre;
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(int idUsuario, String nombre) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
