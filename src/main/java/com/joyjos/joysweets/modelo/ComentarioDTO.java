package com.joyjos.joysweets.modelo;

import java.time.LocalDate;

import com.joyjos.joysweets.seguridad.modelo.UsuarioVO;

public class ComentarioDTO {
	
	private int idComentario;
	private String comentario;
	private LocalDate fechaComentario;
	private PostVO post;
	private UsuarioVO usuario;
	
	public ComentarioDTO() {
		super();
	}
	
	public ComentarioDTO(int idComentario) {
		super();
		this.idComentario=idComentario;
	}

	public ComentarioDTO(int idComentario, String comentario, LocalDate fechaComentario, PostVO post, UsuarioVO usuario) {
		super();
		this.idComentario = idComentario;
		this.comentario = comentario;
		this.fechaComentario = fechaComentario;
		this.post=post;
		this.usuario=usuario;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
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

	public PostVO getPost() {
		return post;
	}

	public void setPost(PostVO post) {
		this.post = post;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

}
