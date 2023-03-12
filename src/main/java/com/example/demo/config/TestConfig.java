package com.example.demo.config;

import com.example.demo.entities.*;
import com.example.demo.entities.enums.OrderStatus;
import com.example.demo.repositories.*;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(0, "Ice Cream");
        Category cat2 = new Category(0, "Frozen Yogurt");
        Category cat3 = new Category(0, "Fake Cake");

        Product p1 = new Product(0, "Sorbet of dirt", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(0, "Cake", "The cake is a lie", 2190.0, "");
        Product p3 = new Product(0, "Yogurt pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(0, "Cookie cream ice gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(0, "Rails for Cake", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        p1.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p2.getCategories().add(cat2);
        p3.getCategories().add(cat2);
        p4.getCategories().add(cat1);
        p5.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        User u1 = new User(0, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(0, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(0, "Luca Blue", "luca@gmail.com", "966666666", "123456");
        User u4 = new User(0, "Jeff Red", "jeff@gmail.com", "955555555", "123456");
        User u5 = new User(0, "Jhon Gray", "jhon@gmail.com", "944444444", "123456");
        User u6 = new User(0, "Raph Black", "raph@gmail.com", "955555555", "123456");

        Order o1 = new Order(0, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(0, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, u2);
        Order o3 = new Order(0, Instant.parse("2019-05-12T15:21:22Z"), OrderStatus.CANCELED, u1);
        Order o4 = new Order(0, Instant.parse("2019-09-21T03:42:10Z"),OrderStatus.DELIVERED, u4);
        Order o5 = new Order(0, Instant.parse("2019-04-18T15:21:22Z"),OrderStatus.PAID, u5);
        Order o6 = new Order(0, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, u1);
        Order o7 = new Order(0, Instant.parse("2019-08-21T03:42:10Z"), OrderStatus.CANCELED, u2);
        Order o8 = new Order(0, Instant.parse("2019-02-21T15:21:22Z"), OrderStatus.CANCELED, u1);
        Order o9 = new Order(0, Instant.parse("2019-03-21T03:42:10Z"),OrderStatus.SHIPPED, u4);
        Order o10 = new Order(0, Instant.parse("2019-06-18T15:21:22Z"),OrderStatus.PAID, u5);

        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5,u6));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5,o6,o7,o8,o9,o10));

        OrderItem oi1 = new OrderItem(o1, p1, 25, p1.getPrice());
        OrderItem oi2 = new OrderItem(o2, p3, 12, p3.getPrice());
        OrderItem oi3 = new OrderItem(o3, p3, 23, p3.getPrice());
        OrderItem oi4 = new OrderItem(o4, p5, 5, p5.getPrice());
        OrderItem oi5 = new OrderItem(o5, p2, 23, p1.getPrice());
        OrderItem oi6 = new OrderItem(o6, p2, 11, p3.getPrice());
        OrderItem oi7 = new OrderItem(o7, p3, 27, p3.getPrice());
        OrderItem oi8 = new OrderItem(o8, p4, 21, p5.getPrice());
        OrderItem oi9 = new OrderItem(o9, p5, 23, p5.getPrice());
        OrderItem oi10 = new OrderItem(o10, p5, 12, p5.getPrice());
        OrderItem oi11 = new OrderItem(o10, p3, 30, p5.getPrice());
        OrderItem oi12 = new OrderItem(o4, p1, 8, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4,oi5,oi6,oi7,oi8,oi9,oi10,oi11,oi12));



    }

}
