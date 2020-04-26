package com.joyjos.joysweets.modelo;

import java.time.LocalDate;

public class PostDTO {
	
	private int idPost;
	private String nombre;
	private String categoria;
	private String post;
	private String imagen;
	private LocalDate fechaPost;
	
	public PostDTO() {
		super();
	}

	public PostDTO(int idPost, String nombre, String categoria, String post, String imagen, LocalDate fechaPost) {
		super();
		this.idPost = idPost;
		this.nombre = nombre;
		this.categoria = categoria;
		this.post = post;
		this.imagen = imagen;
		this.fechaPost = fechaPost;
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
	
}
