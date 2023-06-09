package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    public UserRepository repository;

    public List<User> findAll()
    {
        return repository.findAll();
    }

    public User findById(long id){
        Optional<User> o = repository.findById(id);
        return o.get();
    }

    public User insert(User i)
    {
        return repository.save(i);
    }

    public void delete(long i)
    {
        repository.deleteById(i);
    }

    public User update(long id, User i)
    {
        User e = repository.getReferenceById(id);
        updateData(e,i);
        return repository.save(e);
    }

    private void updateData(User e, User i)
    {
        e.setName(i.getName());
        e.setEmail(i.getEmail());
        e.setPhone(i.getPhone());
    }
}
