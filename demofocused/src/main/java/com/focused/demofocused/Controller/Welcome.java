package com.focused.demofocused.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @GetMapping("/a1")
     public String home(String name,String role){
         return "welcome holder" + name +" ," + role;
     }
}
