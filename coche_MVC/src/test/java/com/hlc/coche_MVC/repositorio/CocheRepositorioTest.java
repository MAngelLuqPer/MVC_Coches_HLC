package com.hlc.coche_MVC.repositorio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hlc.coche_MVC.modelo.Coche;
@DataJpaTest
class CocheRepositorioTest {
	@Autowired
	private CocheRepositorio cocheRepositorio;

	
	@Test
	void testSaveAndFindAll() {
		// Crear y guardar coches
		Coche coche1 = new Coche ("Toyota", "1234AA","Rojo");
		Coche coche2 = new Coche ("Ford","1876AVCX", "Gris");
		
		cocheRepositorio.save(coche1);
		cocheRepositorio.save(coche2);
		
		List<Coche> coches = cocheRepositorio.findAll();
		
		Integer resultadoEsperado = 2;
		
		assertEquals(resultadoEsperado, coches.size(), "Debe de haber 2 coches en la DB");
		assertTrue(coches.stream().anyMatch(c -> c.getMarca().equals("Toyota")), "Deberia de tener un coche Toyota");
		assertTrue(coches.stream().anyMatch(c -> c.getMarca().equals("Ford")), "Deberia de tener un coche Ford");

	}
}
