package com.apirest.app.service.impl;

import com.apirest.app.entitys.Product;
import com.apirest.app.repository.ProductRepository;
import com.apirest.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository repository;

    @Override
    public Product crearProducto(Product product) {
        //creando nuevo objeto
        Product productNew = new Product();
        //guardando en el nuevo objeto
        productNew.setName(product.getName());
        productNew.setDescription(product.getDescription());
        productNew.setPrice(product.getPrice());
        productNew.setAmount(product.getAmount());
        productNew.setDiscount(product.isDiscount());

        return repository.save(productNew);
    }

    @Override
    public List<Product> listarTodosLosProductos() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> BuscarPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void borrarPorId(Integer id) {
        System.out.println("se borro el usuario con Id:" + id);
        repository.deleteById(id);
    }


}
