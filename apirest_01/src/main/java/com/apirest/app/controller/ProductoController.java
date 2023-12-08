package com.apirest.app.controller;


import com.apirest.app.entitys.Product;
import com.apirest.app.entitys.dto.ProductDTO;
import com.apirest.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductoController {

    @Autowired
    private ProductService service;


    @PostMapping
    public ResponseEntity<ProductDTO> guardarProducto(@RequestBody @Valid ProductDTO productDTO){
        return new ResponseEntity<>(service.crearProducto(productDTO), HttpStatus.CREATED);
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
