package com.example.crud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.crud.entidad.Producto;
import com.example.crud.servicio.ProductoServicio;

@Controller
public class ProductoController {
	 @Autowired
	 ProductoServicio productoServicio;
	 @GetMapping("/")
	    public String listarProductos(Model model) {
	        model.addAttribute("productos", productoServicio.listarTodosLosProductos());
	        return "index";
	    }

	    @GetMapping("/producto/nuevo")
	    public String mostrarFormularioDeNuevoProducto(Model model) {
	        Producto producto = new Producto();
	        model.addAttribute("producto", producto);
	        return "producto-form";
	    }

	    @GetMapping("/producto/editar/{id}")
	    public String mostrarFormularioDeEditarProducto(@PathVariable Long id, Model model) {
	        Producto producto = productoServicio.obtenerProductoPorId(id);
	        model.addAttribute("producto", producto);
	        return "producto-form"; 
	    }

	    @PostMapping("/producto")
	    public String guardarProducto(@ModelAttribute Producto producto) {
	        productoServicio.guardarProducto(producto);
	        return "redirect:/";
	    }

	    @GetMapping("/producto/eliminar/{id}")
	    public String eliminarProducto(@PathVariable Long id) {
	        productoServicio.eliminarProducto(id);
	        return "redirect:/";
	    }
	}

