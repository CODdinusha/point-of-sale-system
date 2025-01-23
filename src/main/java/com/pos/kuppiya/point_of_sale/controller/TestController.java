package com.pos.kuppiya.point_of_sale.controller;


import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin
public class TestController {

    @GetMapping(path = "/get-1")
    public String getMyText(){

        String myText="this is our first spring boot project";
        System.out.println(myText);

        return myText;
    }

    @GetMapping(path = "/get-2")
    public String getMyText1(){

        String myText="that is our first spring boot project";
        System.out.println(myText);

        return myText;
   }

}
