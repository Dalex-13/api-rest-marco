package com.apirest.app.service;

import com.apirest.app.entitys.Product;
import com.apirest.app.entitys.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public ProductDTO crearProducto(ProductDTO productDTO);

    public List<Product> listarTodosLosProductos();

    public Optional<Product> BuscarPorId(Integer id);


    public void borrarPorId(Integer id);

}
