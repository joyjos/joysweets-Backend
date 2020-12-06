package com.joyjos.joysweets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.joyjos.joysweets.modelo.PostVO;
import com.joyjos.joysweets.servicios.ServicioPost;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PostTest {

	@Autowired
	ServicioPost sp;
	
	@Test
	public void t01ConexionOK() {
		assertNotNull(sp);
	}
	
	//Inserta post
	@Test
	public void t02savePostOK() {	
		PostVO p=new PostVO("Teresitas");
		sp.save(p);
		assertNotNull(sp.findByNombre("Teresitas"));
	}
	
	//Actualiza post
	@Test
	public void t03modificaPostOK() {
		PostVO p=sp.findByNombre("Macarons de café");
		p.setNombre("Frixuelos");
		sp.save(p);
		assertEquals("Frixuelos",sp.findByNombre("Frixuelos").getNombre());
	}
	
	//Elimina post
	@Test
	public void t04eliminaPostOK() {
		PostVO p=sp.findByNombre("Brownie");
		//elimina el post y sus comentarios porque la
		//restricción permite un borrado en cascada
		try{
			sp.delete(p);
		}catch(Exception e) {
			System.out.println("Error al eliminar el post "+e.getMessage());
		}
		assertNull(sp.findByNombre("Brownie"));
	}
	
	//Busca por nombre
	@Test
	public void t05buscarPorNombreOK(){
		assertEquals(5,sp.findByNombre("Bizcocho de leche caliente").getIdPost());
	}

}
