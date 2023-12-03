package com.apirest.app.service;

import com.apirest.app.entitys.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product crearProducto(Product product);

    public List<Product> listarTodosLosProductos();

    public Optional<Product> BuscarPorId(Integer id);


    public void borrarPorId(Integer id);

}
