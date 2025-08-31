package com.SpringFirstAttempt.sfa.securitySecTry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenTest {

    private Token token;

    @BeforeEach
    public void setUp() {
        token=new Token();
        token.setId(1);
        token.setToken("token xd");
        token.setIsExpired(false);
        token.setIsRevoked(false);

    }

    @Test
    public void testGetters(){
        assertEquals(1,token.getId());
        assertEquals("token xd",token.getToken());
        assertEquals(false, token.getIsExpired());
        assertEquals(false, token.getIsRevoked());

    }

    @Test
    public void testSetters(){
        token.setToken("token");
        token.setIsExpired(true);
        token.setIsRevoked(true);

        assertEquals("token",token.getToken());
        assertEquals(true,token.getIsExpired());
        assertEquals(true, token.getIsExpired());

    }

    @Test
    public void testBuilder(){
        Token tokenBuilder=Token.builder().
                id(2).
                token("lo que hicimos").
                isExpired(false).
                isRevoked(true).
                build();

        assertEquals(2, tokenBuilder.getId());
        assertEquals("lo que hicimos",tokenBuilder.getToken());
        assertEquals(false, tokenBuilder.getIsExpired());
        assertEquals(true,tokenBuilder.getIsRevoked());

    }





}