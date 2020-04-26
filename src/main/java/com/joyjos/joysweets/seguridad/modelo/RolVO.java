package com.joyjos.joysweets.seguridad.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.joyjos.joysweets.seguridad.enums.RoleName;

@Entity
@Table(name="roles")
public class RolVO {
	
	@Id
	@Column(name="idRol")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRol;
	
	@Enumerated(EnumType.STRING)
	@Column(name="roleName", length=20, unique=true)
	private RoleName roleName;
	
	public RolVO() {
		super();
	}

	public RolVO(int idRol, RoleName roleName) {
		super();
		this.idRol = idRol;
		this.roleName = roleName;
	}

	public RolVO(RoleName roleName) {
		super();
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

	@Override
	public String toString() {
		return "RolVO [idRol=" + idRol + ", rolName=" + roleName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRol;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolVO other = (RolVO) obj;
		if (idRol != other.idRol)
			return false;
		if (roleName != other.roleName)
			return false;
		return true;
	}
}
