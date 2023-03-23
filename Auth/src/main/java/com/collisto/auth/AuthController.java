package com.collisto.auth;

import com.plexpt.chatgpt.ChatGPT;
import com.plexpt.chatgpt.util.Proxys;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.net.Proxy;

@RestController
public class AuthController implements Serializable {

    @CrossOrigin(origins = "*", maxAge = 36000)
    @RequestMapping(value = "/login/{name}")
    public String login(@PathVariable("name")String name) {
        return "来自无敌的GPT4:" + gpt(name);
    }


    private String gpt(String name){
        Proxy proxy = Proxys.http("", 1090);

        ChatGPT chatGPT = ChatGPT.builder()
                .apiKey("")
                .proxy(proxy)
                .apiHost("https://api.openai.com/") //反向代理地址
                .build()
                .init();


        return chatGPT.chat(name);
    }
}
