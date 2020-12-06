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

import com.joyjos.joysweets.seguridad.modelo.UsuarioVO;
import com.joyjos.joysweets.seguridad.servicios.ServicioUsuario;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UsuarioTest {

	@Autowired
	ServicioUsuario su;
	
	@Test
	public void t01ConexionOK() {
		assertNotNull(su);
	}
	
	//Inserta usuario
	@Test
	public void t02saveUsuarioOK() {	
		UsuarioVO u=new UsuarioVO("Julen");
		su.save(u);
		assertNotNull(su.findByNombre("Julen"));
	}
	
	//Actualiza usuario
	@Test
	public void t03modificaUsuarioOK() {
		UsuarioVO u=su.findByNombre("Pedro");
		u.setNombre("Fran");
		su.save(u);
		assertEquals("Fran",su.findByNombre("Fran").getNombre());
	}
	
	//Elimina usuario
	@Test
	public void t04eliminaUsuarioOK() {
		UsuarioVO u=su.findByNombre("Juan");
		//elimina el usuario y sus comentarios porque la
		//restricción permite un borrado en cascada
		try{
			su.delete(u);
		}catch(Exception e) {
			System.out.println("Error al eliminar el usuario "+e.getMessage());
		}
		assertNull(su.findByNombre("Juan"));
	}
	
	//Busco por nombre
	@Test
	public void t05BuscarPorNombreOK() {
		assertEquals(1,su.findByNombre("Jose").getIdUsuario());
	}

}
