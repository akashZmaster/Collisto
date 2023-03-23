package com.collisto.chatgpt.service;

import com.plexpt.chatgpt.ChatGPT;
import com.plexpt.chatgpt.util.Proxys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.net.Proxy;

@Component
@RefreshScope
public class ChatGptService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Value("${chatgpt.apiKey}")
    private String apiKey;

    @Value("${chatgpt.apiHost}")
    private String apiHost;

    @Value("${chatgpt.ip}")
    private String ip;

    @Value("${chatgpt.port}")
    private Integer port;

    @Value("${chatgpt.prefix}")
    private String prefix;

    public String getNormalChat(String context) {
        Proxy proxy = Proxys.http(ip, port);
        ChatGPT chatGPT = ChatGPT.builder()
                .apiKey(apiKey)
                .proxy(proxy)
                .apiHost(apiHost) //反向代理地址
                .build()
                .init();
        return prefix + chatGPT.chat(context);
    }


}
