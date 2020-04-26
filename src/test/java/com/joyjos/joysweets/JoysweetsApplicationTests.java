package com.joyjos.joysweets;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.joyjos.joysweets.seguridad.servicios.ServicioUsuario;

@SpringBootTest
class JoysweetsApplicationTests {

	@Autowired
	ServicioUsuario su;
	
	@Test
	public void t01ServicioOK() {
		Persistence.generateSchema("jpa", null);
		assertNotNull(su);
	}

}
