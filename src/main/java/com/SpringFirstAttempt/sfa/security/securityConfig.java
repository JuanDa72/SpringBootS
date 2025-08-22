package com.SpringFirstAttempt.sfa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

    //Recuerda que podemos obtener tanto la sessionId como el csrf token en caso de
    //tener activada el login y querer hacer alguna solicitud post/put/delete

    //En esta clase intentaremos colocar nuestros propios filtros

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        //Desactivamos la seguridad contra csrf
        httpSecurity.csrf(customizer -> customizer.disable());

        //Pedimos autenticación siempre (creo)
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());

        //Indicamos que si se intenta acceder a cualquier url primero se pasa por el login que ya
        //nos brinda srping
        //hasta este punto tenemos lo mismo que usa srping por defecto en su configuración de
        //seguridad
        httpSecurity.formLogin(Customizer.withDefaults());

        //Cambia lo que nos retorna
        httpSecurity.httpBasic(Customizer.withDefaults());

        //Crea un nuevo session id por cada nueva solicitud
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }

    //Bean para definir nuestros usuarios nosotros mismos y no usando la forma automatica
    //que brinda spring en donde solo cambiaríamos la configuración en el yml
    //En este caso queda en memoria xd
    //@Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1= User.withDefaultPasswordEncoder().
//                username("juanda").password("jijo").roles("USER").build();
//
//        UserDetails user2= User.withDefaultPasswordEncoder().
//                username("juanpa").password("joji").roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(user1,user2
//        );



    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(myUserDetailsService);
        return provider;
    }






}
