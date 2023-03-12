package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService
{
    @Autowired
    public OrderRepository repository;

    public List<Order> findAll() { return repository.findAll();}

    public Order findById(long id){
        Optional<Order> o = repository.findById(id);
        return o.get();
    }
}
