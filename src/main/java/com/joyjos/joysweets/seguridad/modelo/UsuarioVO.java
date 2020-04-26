package com.joyjos.joysweets.seguridad.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.joyjos.joysweets.modelo.ComentarioVO;

@Entity
@Table(name="usuarios")
public class UsuarioVO {
	
	@Id
	@Column(name="idUsuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="nombre", length=45)
	private String nombre;
	
	@Column(name="username", length=45, unique=true)
	@Email
	private String username;
	
	@Column(name="password", length=60)
	private String password;
	
//	//Al eliminar un usuario tengo que eliminar el registro en la tabla intermedia
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@ManyToMany(mappedBy="usuario", cascade= {CascadeType.REMOVE}, orphanRemoval = true)
//	private List<UsuarioRolVO> roles;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "usuariosroles", 
				joinColumns = @JoinColumn(name = "idUsuario"), 
				inverseJoinColumns = @JoinColumn(name = "idRol"))
	private Set<RolVO> roles = new HashSet<>();
	
	//Al eliminar un usuario tengo que eliminar el registro en la tabla intermedia
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="usuario", cascade= {CascadeType.REMOVE}, orphanRemoval = true)
	private List<ComentarioVO> posts;
	
	public UsuarioVO() {
		super();
	}

	public UsuarioVO(int idUsuario, String nombre, @Email String username,
			String password, Set<RolVO> roles, List<ComentarioVO> posts) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.posts = posts;
	}
	
	public UsuarioVO(String nombre) {
		super();
		this.nombre = nombre;
	}

	public UsuarioVO(String nombre, String username, String password) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.password = password;
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
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(Set<RolVO> roles) {
		this.roles = roles;
	}

	public void setPosts(List<ComentarioVO> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "UsuarioVO [idUsuario=" + idUsuario + ", nombre=" + nombre + ", username=" + username + ", password=" + password + ", roles=" + roles + ", posts=" + posts
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUsuario;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UsuarioVO other = (UsuarioVO) obj;
		if (idUsuario != other.idUsuario)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public void addRol(RolVO ur) {
		this.roles.add(ur);
	}

	public List<ComentarioVO> getPost() {
		return posts;
	}

	public void addPost(ComentarioVO up) {
		this.posts.add(up);
	}

	public List<ComentarioVO> getPosts() {
		return posts;
	}

	public Set<RolVO> getRoles() {
		return roles;
	}
}
