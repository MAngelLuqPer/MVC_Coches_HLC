package com.example.crud.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.crud.entidad.Producto;
import com.example.crud.servicio.ProductoServicio;

import jakarta.annotation.PostConstruct;

@Component
public class InicializarDatos {
	 @Autowired
	    private ProductoServicio productoServicio;
	    
	    @PostConstruct
	    public void init() {
	        // Crear y guardar algunos productos de ejemplo
	        if (productoServicio.listarTodosLosProductos().iterator().hasNext()) {
	            // Si ya hay datos, no inicializamos.
	            return;
	        }
	        
	        Producto producto1 = new Producto();
	        producto1.setNombre("Producto 1");
	        producto1.setPrecio(new Double("10.99"));
	        productoServicio.guardarProducto(producto1);
	        
	        Producto producto2 = new Producto();
	        producto2.setNombre("Producto 2");
	        producto2.setPrecio(new Double("15.49"));
	        productoServicio.guardarProducto(producto2);
	    }
}
