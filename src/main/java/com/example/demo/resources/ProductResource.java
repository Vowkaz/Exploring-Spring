package com.example.demo.resources;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductResource
{
    @Autowired
    private ProductService service;
    @GetMapping
    public ResponseEntity<List<Product>> findUsers()
    {
        List<Product> u = service.findAll();

            return ResponseEntity.ok(u);
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id)
    {
        Product o = service.findById(id);
        return ResponseEntity.ok(o);
    }
}
