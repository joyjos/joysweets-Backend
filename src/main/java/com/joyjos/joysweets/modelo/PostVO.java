package com.joyjos.joysweets.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class PostVO {
	
	@Id
	@Column(name="idPost")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPost;
	
	@Column(name="nombre", length=45)
	private String nombre;
	
	@Column(name="categoria", length=45)
	private String categoria;
	
	@Column(name="post", columnDefinition="TEXT")
	private String post;
	
	@Column(name="imagen", length=255)
	private String imagen;
	
	@Column(name="fechaPost")
	private LocalDate fechaPost;
	
	@PrePersist
	public void prePersist(){
		fechaPost=LocalDate.now();
	}
		
	//Al eliminar un post tengo que eliminar en cascada los registros de ese post en la tabla intermedia
	@OneToMany(mappedBy="post", fetch=FetchType.EAGER, cascade= {CascadeType.REMOVE}, orphanRemoval = true)
	private List<ComentarioVO> usuarios;

	public PostVO() {
		super();
	}

	public PostVO(int idPost, String nombre, String categoria, String post, String imagen, LocalDate fechaPost,
			List<ComentarioVO> usuarios) {
		super();
		this.idPost = idPost;
		this.nombre = nombre;
		this.categoria = categoria;
		this.post = post;
		this.imagen = imagen;
		this.fechaPost = fechaPost;
		this.usuarios = usuarios;
	}
	
	public PostVO(String nombre, String categoria, String post, String imagen, LocalDate fechaPost) {
		this.nombre=nombre;
		this.categoria=categoria;
		this.post = post;
		this.imagen = imagen;
		this.fechaPost = fechaPost;
	}

	public PostVO(String nombre, String categoria, String post, LocalDate fechaPost) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.post = post;
		this.fechaPost = fechaPost;
	}

	public PostVO(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public LocalDate getFechaPost() {
		return fechaPost;
	}

	public void setFechaPost(LocalDate fechaPost) {
		this.fechaPost = fechaPost;
	}

	public List<ComentarioVO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<ComentarioVO> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "PostVO [idPost=" + idPost + ", nombre=" + nombre + ", categoria=" + categoria + ", post=" + post
				+ ", imagen=" + imagen + ", fechaPost=" + fechaPost + ", usuarios=" + usuarios + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((fechaPost == null) ? 0 : fechaPost.hashCode());
		result = prime * result + idPost;
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
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
		PostVO other = (PostVO) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (fechaPost == null) {
			if (other.fechaPost != null)
				return false;
		} else if (!fechaPost.equals(other.fechaPost))
			return false;
		if (idPost != other.idPost)
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

	public void addUsuario(ComentarioVO up) {
		this.usuarios.add(up);
	}

}
