package com.SpringFirstAttempt.sfa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/Hello")
    public String sayHello(){
        return "Hello from my first controller";
    }

    @GetMapping("/Hello2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2(){
        return "Hello from my first controller but with another http code";
    }

    //Se puede probar en postman :)
    @PostMapping("/post")
    public String post(@RequestBody String message){
        return "Request accepted and message is "+message;
    }


    @PostMapping("/post-order")
    public String postOrder(@RequestBody Order order){
        return "Request accepted and message is "+order.toString();
    }

    @PostMapping("/post-order-record")
    public String postOrder(@RequestBody OrderRecord orderRecord){
        return "Request accepted and message is "+orderRecord.toString();
    }

    //Get pasando un parametro COMO ruta identificadora, indicamos que es un parametro con
    // los {}
    //PathVariable nos permite mapear para que no necesariamente tengan el mismo nombre
    @GetMapping("/hello/{user-name}")
    public String pathVar(@PathVariable("user-name") String userName){
        return "My variable is "+userName;
    }


    //Get pasando parametros usando la url
    @GetMapping("/bye")
    public String paramVarU(@RequestParam("user-name") String name1, @RequestParam("user-name2") String name2){
        return "The parameters are "+name1+", "+name2;
    }



}
