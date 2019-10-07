package com.tutorialspoint.config;

import com.tutorialspoint.model.Order;
import com.tutorialspoint.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.tutorialspoint")
@PropertySource(value = {"classpath:db.properties"})
public class HelloConfiguration implements WebMvcConfigurer {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Autowired
    Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    //region Bean
//    @Bean(name = "person", initMethod = "init", destroyMethod = "destroy")
//    @Scope(value = "singleton")
//    public Person person() {
//        return new Person("Thuc Config", 22);
//    }
//
//    @Bean(name = "person2")
//    public Person person2() {
//        return new Person("Thuc Config2", 22);
//    }
//    @Bean
//    @Autowired
//    @Qualifier("person2")
//    public Order order(Person person) {
//        return new Order(person);
//    }
    //endregion
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resource/**").addResourceLocations("/resources");
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
        bundleMessageSource.setBasename("classpath:messages");
        bundleMessageSource.setDefaultEncoding("utf-8");
        return bundleMessageSource;
    }

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(-1);
        return commonsMultipartResolver;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("driver"));
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setUsername(env.getProperty("usernames"));
        dataSource.setPassword(env.getProperty("password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(getDataSource());
        bean.setPackagesToScan("com.tutorialspoint.entity");
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
        hibernateProperties.put("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
        bean.setHibernateProperties(hibernateProperties);
        return bean;
    }
    @Bean
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return  transactionManager;
    }
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(getDataSource());
//    }
//    @Bean(name = "transactionManager")
//    public DataSourceTransactionManager dataSourceTransactionManager()
//    {
//        return  new DataSourceTransactionManager(getDataSource());
//    }

}
