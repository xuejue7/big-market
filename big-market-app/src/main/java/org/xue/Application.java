package org.xue;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@Configurable
@MapperScan("org.xue.infrastructure.dao")
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

}
