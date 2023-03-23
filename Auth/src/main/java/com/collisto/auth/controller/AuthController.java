package com.collisto.auth.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

@RestController
public class AuthController implements Serializable {

    @Resource
    private RestTemplate restTemplate;

    @CrossOrigin(origins = "*", maxAge = 36000)
    @RequestMapping(value = "/login/{context}")
    public String login(@PathVariable("context") String context) {
        return restTemplate.getForObject("http://API-GPT/chat/" + context, String.class);
    }


}
