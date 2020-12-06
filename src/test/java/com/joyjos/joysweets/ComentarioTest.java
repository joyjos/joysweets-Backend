package com.joyjos.joysweets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.joyjos.joysweets.modelo.ComentarioVO;
import com.joyjos.joysweets.modelo.PostVO;
import com.joyjos.joysweets.seguridad.modelo.UsuarioVO;
import com.joyjos.joysweets.seguridad.servicios.ServicioUsuario;
import com.joyjos.joysweets.servicios.ServicioComentario;
import com.joyjos.joysweets.servicios.ServicioPost;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ComentarioTest {

	@Autowired
	ServicioUsuario su;
	
	@Autowired
	ServicioPost sp;
	
	@Autowired
	ServicioComentario sc;
	
	@Test
	public void t01ConexionOK() {
		assertNotNull(su);
	}
	
	@Test
	public void t02ConexionOK() {
		assertNotNull(sp);
	}
	
	@Test
	public void t03ConexionOK() {
		assertNotNull(sc);
	}
	
	//Inserta un comentario del usuario "Pedro" en el post "Bizcocho de leche caliente"
	@Test
	public void t04saveComentario(){
		UsuarioVO u=su.findByNombre("Jose");
		PostVO p=sp.findByNombre("Bizcocho de leche caliente");
		//actualizo la colección del post dentro del usuario
		ComentarioVO up =new ComentarioVO(LocalDate.now(),u,p);
		p.addUsuario(up);
		u.addPost(up);
		//salvo el usuario, lo que implica que hace una inserción en la tercera tabla comentarios
		su.save(u);
	}
	
	//Actualiza comentario
	@Test
	public void t05modificaComentarioOK() {
		ComentarioVO c=sc.findByComentario("El mejor cupcake");
		c.setComentario("Espectaculares!");
		sc.save(c);
		assertEquals("Espectaculares!",sc.findByComentario("Espectaculares!").getComentario());
	}
	
	//Elimina comentario
	@Test
	public void t06eliminaComentarioOK() {
		ComentarioVO c=sc.findByComentario("Riquísima");
		try{
			sc.delete(c);
		}catch(Exception e) {
			System.out.println("Error al eliminar el comentario "+e.getMessage());
		}
		assertNull(sc.findByComentario("Riquísima"));
	}
		
	//Busca por comentario
	@Test
	public void t07buscarPorComentarioOK(){
		assertEquals(4,sc.findByComentario("Vaya bomba!").getIdComentario());
	}

}
