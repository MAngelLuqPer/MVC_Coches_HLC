package com.hlc.coche_MVC.config;

import com.hlc.coche_MVC.modelo.Coche;
import com.hlc.coche_MVC.repositorio.CocheRepositorio;

import jakarta.annotation.PostConstruct;

public class InicializarDatos {
	private CocheRepositorio cocheRepositorio;
	
	public InicializarDatos (CocheRepositorio cocheRepositorio) {
		this.cocheRepositorio = cocheRepositorio;
	}
	
	@PostConstruct
	public void init () {
		Coche coche1 = new Coche ("Toyota" , "1234ABC", "Gris");
		Coche coche2 = new Coche ("Citroen", "4433LFV", "Blanco");
		Coche coche3 = new Coche ("Chevrolet", "1245DEF", "Negro");
		
		cocheRepositorio.save(coche1);
		cocheRepositorio.save(coche2);
		cocheRepositorio.save(coche3);
		
	}
}
