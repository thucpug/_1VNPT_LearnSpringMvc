package com.tutorialspoint.config;

import com.tutorialspoint.model.Order;
import com.tutorialspoint.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tutorialspoint")
public class HelloConfiguration {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "person", initMethod = "init", destroyMethod = "destroy")
    @Scope(value = "singleton")
    public Person person() {
        return new Person("Thuc Config", 22);
    }

    @Bean(name = "person2")
    public Person person2() {
        return new Person("Thuc Config2", 22);
    }
    //    @Bean
//    public Order order() {
//        return new Order(person());
//    }
    @Bean
    @Autowired
    @Qualifier("person2")
    public Order order(Person person) {
        return new Order(person);
    }
}
