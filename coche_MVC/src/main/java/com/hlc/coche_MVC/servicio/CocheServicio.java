package com.hlc.coche_MVC.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlc.coche_MVC.modelo.Coche;
import com.hlc.coche_MVC.repositorio.CocheRepositorio;

@Service
public class CocheServicio {
    @Autowired
    private CocheRepositorio cocheRepositorio;

    public List<Coche> obtenerTodosLosCoches() {
        return (List<Coche>) cocheRepositorio.findAll();
    }

    public Coche obtenerCochePorId(Integer id) {
        return cocheRepositorio.findById(id).orElseThrow(() -> 
            new IllegalArgumentException("Producto no encontrado con id: " + id));
    }
    public Coche guardarCoche(Coche coche) {
        return cocheRepositorio.save(coche);
    }

    public void eliminarCochePorId(Integer id) {
        cocheRepositorio.deleteById(id);
    }
}
