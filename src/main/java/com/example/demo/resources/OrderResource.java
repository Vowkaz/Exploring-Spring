package com.example.demo.resources;

import com.example.demo.entities.Order;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderResource
{
    @Autowired
    private OrderService service;
    @GetMapping
    public ResponseEntity<List<Order>> findUsers()
    {
        List<Order> u = service.findAll();

            return ResponseEntity.ok(u);
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable long id)
    {
        Order o = service.findById(id);
        return ResponseEntity.ok(o);
    }
}
