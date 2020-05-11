package com.joyjos.joysweets.seguridad.modelo;

import java.util.HashSet;
import java.util.Set;

public class UsuarioDTO {
	
	private int idUsuario;
	private String nombre;
	private String username;
	private Set<RolVO> roles = new HashSet<>();
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(int idUsuario, String nombre, String username, Set<RolVO> roles) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.username=username;
		this.roles = roles;
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
	
	public void setRoles(Set<RolVO> roles) {
		this.roles = roles;
	}
	
	public Set<RolVO> getRoles() {
		return roles;
	}
}
