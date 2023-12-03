package com.apirest.app.controller;


import com.apirest.app.entitys.Product;
import com.apirest.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductoController {

    @Autowired
    private ProductService service;


    @PostMapping
    public Product guardarProducto(@RequestBody Product product){
        return service.crearProducto(product);
    }

    @GetMapping
    public List<Product> listarTodo(){
        return service.listarTodosLosProductos();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Product> listarPorId(@PathVariable Integer id){
        return service.BuscarPorId(id);
    }

    @DeleteMapping("/buscar/{id}")
    public void borrar(@PathVariable Integer id){
        service.borrarPorId(id);
    }


}
