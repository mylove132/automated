package com.xdf.bling.qa;

import com.xdf.bling.qa.common.config.InitializationConfigFile;
import com.xdf.bling.qa.common.enums.ConfigType;
import com.xdf.bling.qa.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        InitializationConfigFile initializationConfigFile = new InitializationConfigFile();
        initializationConfigFile.initConfig(ConfigType.PROPERTIES, "automated-test");
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
