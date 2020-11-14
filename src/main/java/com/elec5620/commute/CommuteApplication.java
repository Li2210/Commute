package com.elec5620.commute;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.elec5620.commute.Dao")
public class CommuteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommuteApplication.class, args);
    }

}
