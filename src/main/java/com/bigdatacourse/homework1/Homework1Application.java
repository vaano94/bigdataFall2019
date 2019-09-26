package com.bigdatacourse.homework1;

import com.bigdatacourse.homework1.service.DatabasePopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Homework1Application {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext run = SpringApplication.run(Homework1Application.class, args);
        DatabasePopulator bean = run.getBean(DatabasePopulator.class);
        bean.populate();
    }

}
