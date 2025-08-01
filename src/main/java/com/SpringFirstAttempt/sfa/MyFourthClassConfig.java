package com.SpringFirstAttempt.sfa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MyFourthClassConfig {

    //Es buena práctica definir los beans en otra clase, este bean es para myfourthclass

    //Definimos varios beans los cuales podrán ser indentificados por su nombre, qualifer o profile
    @Bean
    @Profile("dev")
    public MyFourthClass mf4cConfig(){
        return new MyFourthClass("Fourth bean v1");
    }

    @Bean
    public MyFourthClass mf4SecondBean(){return new MyFourthClass("Fourth bean v2");}

    @Bean
    public MyFourthClass mf4ThirdBean(){return new MyFourthClass("Fourth bean v3");}

}
