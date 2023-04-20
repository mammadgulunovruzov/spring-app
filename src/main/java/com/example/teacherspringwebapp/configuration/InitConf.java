package com.example.teacherspringwebapp.configuration;

import com.example.teacherspringwebapp.lib.NonSpringUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class InitConf {

    @Bean
    @Scope(value = "prototype")
    public NonSpringUtil getNonSpringUtil(){
        return new NonSpringUtil();
    }
}
