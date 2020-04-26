package com.joyjos.joysweets.modelo;

import java.time.LocalDate;

public class ComentarioDTO {
	
	private int idComentario;
	private String comentario;
	private LocalDate fechaComentario;
	
	public ComentarioDTO() {
		super();
	}
	
	public ComentarioDTO(int idComentario) {
		super();
		this.idComentario=idComentario;
	}

	public ComentarioDTO(int idComentario, String comentario, LocalDate fechaComentario) {
		super();
		this.idComentario = idComentario;
		this.comentario = comentario;
		this.fechaComentario = fechaComentario;
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

}
