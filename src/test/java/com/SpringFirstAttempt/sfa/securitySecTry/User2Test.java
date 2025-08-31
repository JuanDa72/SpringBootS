package com.SpringFirstAttempt.sfa.securitySecTry;

import jakarta.persistence.SqlResultSetMapping;
import net.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class User2Test {

    private User2 user;

    //Aplicamos esto antes de cada método para no tener que correr lo mismo multiples veces
    @BeforeEach
    void setUp(){
        user=new User2();
        user.setId(1);
        user.setName("juan");
        user.setEmail("jcruzgi@unal.edu.co");
        user.setPassword("it40594");
        user.setTokens(new ArrayList<>());
    }

    @Test
    void testGetters(){
        assertEquals(1,user.getId());
        assertEquals("juan",user.getName());
        assertEquals("jcruzgi@unal.edu.co",user.getEmail());
        assertEquals("it40594",user.getPassword());
        assertNotNull(user.getTokens());
        assertTrue(user.getTokens().isEmpty());

    }

    @Test
    void testSetters(){
        user.setName("david");
        user.setEmail("cruzgiraldojuandavid537@gmail.com");
        user.setPassword("123456");

        assertEquals("david",user.getName());
        assertEquals("cruzgiraldojuandavid537@gmail.com",user.getEmail());
        assertEquals("123456",user.getPassword());

    }

    @Test
    void testBuilder(){
        User2 userBuilder=User2.builder().
                id(2).
                name("nancy").
                email("gnancypineda@gmail.com").
                password("qwerty").
                build();

        assertEquals(2,userBuilder.getId());
        assertEquals("nancy",userBuilder.getName());
        assertEquals("gnancypineda@gmail.com",userBuilder.getEmail());
        assertEquals("qwerty",userBuilder.getPassword());



    }



}