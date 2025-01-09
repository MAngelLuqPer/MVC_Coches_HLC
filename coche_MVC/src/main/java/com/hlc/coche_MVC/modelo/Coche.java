package com.hlc.coche_MVC.modelo;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
public class Coche {
	@Id
	private int id;
	private String marca;
	private String matricula;
	private String color;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
