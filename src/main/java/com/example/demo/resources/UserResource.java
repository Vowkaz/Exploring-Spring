package com.example.demo.resources;

import com.example.demo.entities.User;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource
{
    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<User>> findUsers()
    {
        List<User> u = service.findAll();

            return ResponseEntity.ok(u);
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable long id)
    {
        User o = service.findById(id);
        return ResponseEntity.ok(o);
    }
}
