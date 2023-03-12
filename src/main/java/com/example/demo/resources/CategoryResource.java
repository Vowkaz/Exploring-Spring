package com.example.demo.resources;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource
{
    @Autowired
    private CategoryService service;
    @GetMapping
    public ResponseEntity<List<Category>> findUsers()
    {
        List<Category> u = service.findAll();

            return ResponseEntity.ok(u);
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable long id)
    {
        Category o = service.findById(id);
        return ResponseEntity.ok(o);
    }
}
