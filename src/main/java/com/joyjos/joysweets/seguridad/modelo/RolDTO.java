package com.joyjos.joysweets.seguridad.modelo;

import com.joyjos.joysweets.seguridad.enums.RoleName;

public class RolDTO {
	
	private int idRol;
	private RoleName roleName;
	
	public RolDTO() {
		super();
	}

	public RolDTO(int idRol, RoleName roleName) {
		super();
		this.idRol = idRol;
		this.roleName = roleName;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
}
