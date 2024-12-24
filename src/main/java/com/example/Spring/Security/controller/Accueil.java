package com.example.Spring.Security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accueil")
public class Accueil {

    @GetMapping("")
    public String accueil(){
        return "accueil";
    }

    /**
     * HELLObEFORE INFORMAITON A LOT OF INFORMAITON
     * AS YOU CAN SEE IT S BAD WAY ...
     *
     */

}
