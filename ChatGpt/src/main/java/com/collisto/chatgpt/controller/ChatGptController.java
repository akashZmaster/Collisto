package com.collisto.chatgpt.controller;

import com.collisto.chatgpt.service.ChatGptService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatGptController {

    @Resource
    ChatGptService chatGptService;

    @CrossOrigin(origins = "*", maxAge = 36000)
    @RequestMapping(value = "/chat/{context}")
    public String getNormalChat(@PathVariable String context) {
        return chatGptService.getNormalChat(context);
    }

}
