package com.hlc.coche_MVC.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hlc.coche_MVC.modelo.Coche;
import com.hlc.coche_MVC.servicio.CocheServicio;

public class CocheController {
	 @Autowired
	 CocheServicio cocheServicio;
	 @GetMapping("/")
	    public String listarCoches(Model model) {
	        model.addAttribute("productos", cocheServicio.obtenerTodosLosCoches());
	        return "index";
	    }

	    @GetMapping("/coche/nuevo")
	    public String mostrarFormularioDeNuevoProducto(Model model) {
	        Coche coche = new Coche();
	        model.addAttribute("coche", coche);
	        return "coche-form";
	    }

	    @GetMapping("/coche/editar/{id}")
	    public String mostrarFormularioDeEditarProducto(@PathVariable Integer id, Model model) {
	        Coche coche = cocheServicio.obtenerCochePorId(id);
	        model.addAttribute("coche", coche);
	        return "coche-form"; 
	    }

	    @PostMapping("/producto")
	    public String guardarCoche(@ModelAttribute Coche coche) {
	        cocheServicio.guardarCoche(coche);
	        return "redirect:/";
	    }

	    @GetMapping("/producto/eliminar/{id}")
	    public String eliminarCoche(@PathVariable Integer id) {
	        cocheServicio.eliminarCochePorId(id);
	        return "redirect:/";
	    }
}
