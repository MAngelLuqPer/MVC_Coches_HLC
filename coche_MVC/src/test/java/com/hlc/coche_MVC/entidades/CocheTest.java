package com.hlc.coche_MVC.entidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hlc.coche_MVC.modelo.Coche;

public class CocheTest {
	private Coche coche;
	@BeforeEach
	void setup() {
		coche = new Coche();
	}
	
	@Test
	void testSetAndGetID() {
		int id = 1;
		coche.setId(1);
		
		assertEquals(id, coche.getId(), "El ID no es el mismo");
	}
	
	@Test
	@DisplayName ("Prueba de getter y setter de marca")
	void testGetterSetterMarca() {
		String resultadoEsperado = "Toyota";
		coche.setMarca(resultadoEsperado);
		
		assertEquals(resultadoEsperado, coche.getMarca(), "La marca no es la esperada");
	}
	
	@Test
	@DisplayName ("Prueba de constructor con parametros")
	void testConstructorParametros() {
		String marca = "Toyota";
		String matricula = "123123ABC";
		String color = "rosa";
		
		Coche coche = new Coche (marca,matricula,color);
		assertEquals(marca, coche.getMarca(), "La marca del coche no es igual a la que se ha creado");
		assertEquals(matricula, coche.getMatricula(), "La matricula no coincide a la que se ha creado");
		assertEquals (color, coche.getColor(), "El color del coche no es el mismo que el coche creado");
	}
	

}

