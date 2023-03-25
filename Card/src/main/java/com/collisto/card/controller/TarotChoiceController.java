package com.collisto.card.controller;

import com.collisto.card.entity.TarotAnalysis;
import com.collisto.card.entity.TarotCard;
import com.collisto.card.entity.TarotKeyWord;
import com.collisto.card.enums.StarEnums;
import com.collisto.card.service.TarotAnalysisService;
import com.collisto.card.service.TarotCardService;
import com.collisto.card.service.TarotKeyWordService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class TarotChoiceController {

    @Resource
    TarotCardService tarotCardService;

    @Resource
    TarotKeyWordService tarotKeyWordService;

    @Resource
    TarotAnalysisService tarotAnalysisService;

    @Resource
    private RestTemplate restTemplate;

    @CrossOrigin(origins = "*", maxAge = 36000)
    @RequestMapping(value = "/getTarotCard")
    public String getTarotCard(String personality, int cardAmount) {
        StringBuffer result = new StringBuffer();
        List<TarotCard> cardList = new ArrayList<>();

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 23; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        // 塔罗预选
        for (int i = 0; i < cardAmount; i++) {
            cardList.add(tarotCardService.selectById(numbers.get(i)));
        }
        // 数据整合
        StringBuffer context = new StringBuffer();
        for (TarotCard card : cardList) {
            int seat = getSeat();
            result.append("\r\nNO.").append(card.getSurfaceVal()).append(card.getCnName()).append("<").append(seat == 0 ? "正" : "逆")
                    .append(">,隶属星象:【").append(StarEnums.getStarNameByCode(card.getRelationStar())).append("】");
            List<TarotAnalysis> analysisList = tarotAnalysisService.getCardAnalysis(card.getId(), seat);
            if (analysisList.size() > 0) {
                Collections.shuffle(analysisList);
                for (int i = 0; i < analysisList.size() / 2; i++) {
                    context.append(analysisList.get(i).getCnMeaning());
                }
            }
            List<TarotKeyWord> keyWordList = tarotKeyWordService.getKeyWordByCardId(card.getId());
            if (keyWordList.size() > 0) {
                Collections.shuffle(keyWordList);
                for (int i = 0; i < keyWordList.size() / 2; i++) {
                    context.append(keyWordList.get(i).getCnKeyword()).append(",");
                }
            }
        }
        if (cardList.size() > 0) {
            result.append("您的关键词是：").append(context.toString()).append("\r\n");
            result.append("您的塔罗牌已经选好了，小萝为您准备了一份专属的建议，请查收：\r\n");
            String gpt = null;
            while (gpt == null) {
                gpt = restTemplate.getForObject("http://API-GPT/chat/" + personality + "/" + context.toString(), String.class);
                if (gpt != null) {
                    break;
                }
            }
            result.append(gpt);
        } else {
            result.append("小萝没有为您找到合适的塔罗牌，请重新选择");
        }
        return result.toString();
    }

    private int getSeat() {
        double random = Math.random();
        if (random < 0.5) {
            return 0;
        } else {
            return 1;
        }
    }

}
