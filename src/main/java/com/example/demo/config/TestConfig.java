package com.example.demo.config;

import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.entities.enums.OrderStatus;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(0, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(0, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(0, "Luca Blue", "luca@gmail.com", "966666666", "123456");
        User u4 = new User(0, "Jeff Red", "jeff@gmail.com", "955555555", "123456");
        User u5 = new User(0, "Jhon Gray", "jhon@gmail.com", "944444444", "123456");
        User u6 = new User(0, "Raph Black", "raph@gmail.com", "955555555", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5,u6));

        Order o1 = new Order(0, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(0, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, u2);
        Order o3 = new Order(0, Instant.parse("2019-05-12T15:21:22Z"), OrderStatus.CANCELED, u1);
        Order o4 = new Order(0, Instant.parse("2019-09-21T03:42:10Z"),OrderStatus.DELIVERED, u4);
        Order o5 = new Order(0, Instant.parse("2019-03-18T15:21:22Z"),OrderStatus.PAID, u5);

        orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));
    }

}
