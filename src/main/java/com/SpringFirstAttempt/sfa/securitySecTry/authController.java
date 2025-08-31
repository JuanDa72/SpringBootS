package com.SpringFirstAttempt.sfa.securitySecTry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class authController {

    private final AuthService authService;

    public authController(AuthService authService) {
        this.authService = authService;
    }

    //Usamos responseEntity para controlar mucho mas la respuesta que ofrecemos desde el backend como
    //el codigo, el body y la firma (creo)


    //Arreglar esto despues mientras verifico los test xd

    /*
    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@RequestBody final RegisterRequest request){
        final TokenResponse token=service.register(request);
        return ResponseEntity.ok(token);
        return null;
    }


     */

}
