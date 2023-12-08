package com.apirest.app.service.impl;

import com.apirest.app.entitys.Product;
import com.apirest.app.entitys.dto.ProductDTO;
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
    public ProductDTO crearProducto(ProductDTO productDTO) {
        //convert from DTO to entity
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setAmount(productDTO.getAmount());
        product.setDiscount(productDTO.isDiscount());

        Product newProduct = repository.save(product);

        //convert entity to DTO
        ProductDTO productResponse = new ProductDTO();
        productResponse.setId(newProduct.getId());
        productResponse.setName(newProduct.getName());
        productResponse.setDescription(newProduct.getDescription());
        productResponse.setPrice(newProduct.getPrice());
        productResponse.setAmount(newProduct.getAmount());
        productResponse.setDiscount(newProduct.isDiscount());

        return productResponse;
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
