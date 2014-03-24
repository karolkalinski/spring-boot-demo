package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;


@EnableAutoConfiguration
public class BootDemo {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootDemo.class, args);
    }

}
