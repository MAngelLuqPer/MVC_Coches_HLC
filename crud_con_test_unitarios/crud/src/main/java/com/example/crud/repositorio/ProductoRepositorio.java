package com.example.crud.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.crud.entidad.Producto;

public interface ProductoRepositorio extends CrudRepository<Producto, Long>{

}
