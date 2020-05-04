package com.joyjos.joysweets.seguridad.modelo;

public class UsuarioDTO {
	
	private int idUsuario;
	private String nombre;
	private String username;
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(int idUsuario, String nombre, String username) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.username=username;
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
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.nombre = username;
	}
}
