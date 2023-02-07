package com.softuni.mobilele.config;

import com.softuni.mobilele.domain.beans.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    //todo logged user class -> user logged entity

    @Bean
    public LoggedUser loggedUser() {
        return new LoggedUser();
    }
}
