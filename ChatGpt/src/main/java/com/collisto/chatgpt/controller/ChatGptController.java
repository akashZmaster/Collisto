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

    @CrossOrigin(origins = "*", maxAge = 36000)
    @RequestMapping(value = "/chat/{personality}/{context}")
    public String getPersonalityChat(@PathVariable String personality, @PathVariable String context) {
        return chatGptService.getPersonalityChat(personality, context);
    }

    @CrossOrigin(origins = "*", maxAge = 36000)
    @RequestMapping(value = "/chat/stream/{personality}/{context}")
    public void getStreamChat(@PathVariable String personality, @PathVariable String context) {
        chatGptService.getStreamChat(personality, context);
    }

}
