package com.joyjos.joysweets;

import static org.junit.Assert.assertNotNull;

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
import com.joyjos.joysweets.servicios.ServicioPost;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ComentarioTest {

	@Autowired
	ServicioUsuario su;
	
	@Autowired
	ServicioPost sp;
	
	@Test
	public void t01ConexionOK() {
		assertNotNull(su);
	}
	
	@Test
	public void t02ConexionOK() {
		assertNotNull(sp);
	}
	
	//Inserta comentario
	@Test
	public void t03saveComentario(){
		UsuarioVO u=su.findByNombre("Pedro");
		PostVO p=sp.findByPost("Brownie");
		//actualizo la colección del post dentro del usuario
		ComentarioVO up =new ComentarioVO(LocalDate.now(),u,p);
		p.addUsuario(up);
		u.addPost(up);
		//salvo el usuario, lo que implica que hace una inserción en la tercera tabla
		//comentarios
		su.save(u);
	}

}
