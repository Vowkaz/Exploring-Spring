package com.example.demo.config;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(0, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(0, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(0, "Luca Blue", "luca@gmail.com", "966666666", "123456");
        User u4 = new User(0, "Jeff Red", "jeff@gmail.com", "955555555", "123456");
        User u5 = new User(0, "Jhon Gray", "jhon@gmail.com", "944444444", "123456");
        User u6 = new User(0, "Raph Black", "raph@gmail.com", "955555555", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5,u6));
    }
}
