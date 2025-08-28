package com.SpringFirstAttempt.sfa.securitySecTry;

//Dto convencional, podríamos agregar algunas validaciones pero no se si es necesario xd
public record RegisterRequest (

        String name,
        String email,
        String password

)
{
}
