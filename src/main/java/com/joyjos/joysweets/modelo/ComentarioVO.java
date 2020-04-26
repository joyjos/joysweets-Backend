package com.joyjos.joysweets.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.joyjos.joysweets.seguridad.modelo.UsuarioVO;

@Entity
@Table(name="comentarios")
public class ComentarioVO {

	@Id
	@Column(name="idComentario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComentario;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private UsuarioVO usuario;
	
	@ManyToOne
	@JoinColumn(name="idPost")
	private PostVO post;
	
	@Column(name="comentario")
	private String comentario;
	
	@Column(name="fechaComentario")
	private LocalDate fechaComentario;
	
	//Creo la fecha automáticamente
	@PrePersist
	public void prePersist(){
		fechaComentario=LocalDate.now();
	}
	
	public ComentarioVO() {
		super();
	}

	public ComentarioVO(UsuarioVO usuario, PostVO post, String comentario) {
		super();
		this.usuario = usuario;
		this.post = post;
		this.comentario = comentario;
	}

	public ComentarioVO(int idComentario, UsuarioVO usuario, PostVO post, String comentario,
			LocalDate fechaComentario) {
		super();
		this.idComentario = idComentario;
		this.usuario = usuario;
		this.post = post;
		this.comentario = comentario;
		this.fechaComentario = fechaComentario;
	}

	public ComentarioVO(LocalDate fechaComentario, UsuarioVO usuario, PostVO post) {
		this.fechaComentario=fechaComentario;
		this.usuario=usuario;
		this.post=post;
	}

	public ComentarioVO(UsuarioVO usuario, PostVO post, String comentario, LocalDate fechaComentario) {
		this.usuario = usuario;
		this.post = post;
		this.comentario = comentario;
		this.fechaComentario = fechaComentario;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public PostVO getPost() {
		return post;
	}

	public void setPost(PostVO post) {
		this.post = post;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LocalDate getFechaComentario() {
		return fechaComentario;
	}

	public void setFechaComentario(LocalDate fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

	@Override
	public String toString() {
		return "ComentarioVO [idComentario=" + idComentario + ", usuario=" + usuario + ", post=" + post
				+ ", comentario=" + comentario + ", fechaComentario=" + fechaComentario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((fechaComentario == null) ? 0 : fechaComentario.hashCode());
		result = prime * result + idComentario;
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		ComentarioVO other = (ComentarioVO) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (fechaComentario == null) {
			if (other.fechaComentario != null)
				return false;
		} else if (!fechaComentario.equals(other.fechaComentario))
			return false;
		if (idComentario != other.idComentario)
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
