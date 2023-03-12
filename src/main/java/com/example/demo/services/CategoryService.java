package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService
{
    @Autowired
    public CategoryRepository repository;

    public List<Category> findAll() { return repository.findAll();}

    public Category findById(long id){
        Optional<Category> o = repository.findById(id);
        return o.get();
    }
}
