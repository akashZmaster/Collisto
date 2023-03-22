package com.collisto.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class AuthController implements Serializable {

    @CrossOrigin(origins = "*", maxAge = 36000)
    @RequestMapping(value = "/login/{name}")
    public String login(@PathVariable("name")String name) {
        return " user is login: " + name;
    }

}
