package com.collisto.chatgpt.service;

import com.plexpt.chatgpt.ChatGPT;
import com.plexpt.chatgpt.ChatGPTStream;
import com.plexpt.chatgpt.entity.chat.ChatCompletion;
import com.plexpt.chatgpt.entity.chat.ChatCompletionResponse;
import com.plexpt.chatgpt.entity.chat.Message;
import com.plexpt.chatgpt.listener.ConsoleStreamListener;
import com.plexpt.chatgpt.util.Proxys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.Proxy;
import java.util.Arrays;

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

    /**
     * 普通聊天
     *
     * @param context
     * @return
     */
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

    /**
     * 人格聊天
     *
     * @param personality
     * @param context
     * @return
     */
    public String getPersonalityChat(String personality, String context) {
        Proxy proxy = Proxys.http(ip, port);
        ChatGPT chatGPT = ChatGPT.builder()
                .apiKey(apiKey)
                .proxy(proxy)
                .timeout(1000L)
                .apiHost(apiHost) //反向代理地址
                .build()
                .init();

        Message system = Message.ofSystem(personality);
        Message message = Message.of(context);

        ChatCompletion chatCompletion = ChatCompletion.builder()
                .model(ChatCompletion.Model.GPT_3_5_TURBO.getName())
                .messages(Arrays.asList(system, message))
                .maxTokens(3000)
                .temperature(0.9)
                .build();

        ChatCompletionResponse response = chatGPT.chatCompletion(chatCompletion);
        Message res = response.getChoices().get(0).getMessage();
        return prefix + res.getContent();
    }

    /**
     * 流式聊天
     * @param personality 人格
     * @param context 上下文
     */
    public void getStreamChat(String personality, String context) {
        Proxy proxy = Proxys.http(ip, port);
        ChatGPTStream chatGPTStream = ChatGPTStream.builder()
                .apiKey(apiKey)
                .proxy(proxy)
                .timeout(1000L)
                .apiHost(apiHost) //反向代理地址
                .build()
                .init();

        Message system = Message.ofSystem(personality);
        Message message = Message.of(context);

        ChatCompletion chatCompletion = ChatCompletion.builder()
                .model(ChatCompletion.Model.GPT_3_5_TURBO.getName())
                .messages(Arrays.asList(system, message))
                .maxTokens(3000)
                .temperature(0.9)
                .build();

        ConsoleStreamListener listener = new ConsoleStreamListener();
        chatGPTStream.streamChatCompletion(chatCompletion, listener);
    }

}
