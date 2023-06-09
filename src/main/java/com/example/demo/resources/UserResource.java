package com.example.demo.resources;

import com.example.demo.entities.User;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
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

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User e )
    {
        e = service.insert(e);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getId()).toUri();
        return ResponseEntity.created(uri).body(e);
    }

    @DeleteMapping( value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping( value = "/{id}")
    public ResponseEntity<User> update(@PathVariable long id,@RequestBody User e)
    {
        e = service.update(id, e);
        return ResponseEntity.ok(e);
    }
}
