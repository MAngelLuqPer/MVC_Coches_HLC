package com.hlc.coche_MVC.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hlc.coche_MVC.modelo.Coche;
@Repository
public interface CocheRepositorio extends JpaRepository<Coche, Integer>{
	

}
