package com.hlc.coche_MVC.controlador;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.hlc.coche_MVC.modelo.Coche;
import com.hlc.coche_MVC.servicio.CocheServicio;
@WebMvcTest(CocheController.class)
class CocheControladorTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	
	private CocheServicio servicio;
	
	@Test
	@DisplayName("Lista todos los coches y muestra la vista")
	void listarCoches() throws Exception {
		when(servicio.obtenerTodosLosCoches()).thenReturn(
				Arrays.asList(
						new Coche ("Toyota","1234ABC","Rojo"),
						new Coche("Ford","5678DEF","Gris")
						)
				);
		mockMvc.perform("/").andExpect(status().isOk()).andExpect(view().name("/")).andExpect(model().attributeExists("coche"));
	}

}
