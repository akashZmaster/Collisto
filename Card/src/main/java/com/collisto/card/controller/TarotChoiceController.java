package com.collisto.card.controller;

import com.collisto.card.enums.CardArrays;
import com.collisto.card.enums.TarotCardEnums;
import com.collisto.card.service.TarotAnalysisService;
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
    TarotKeyWordService tarotKeyWordService;

    @Resource
    TarotAnalysisService tarotAnalysisService;

    @Resource
    private RestTemplate restTemplate;

    @CrossOrigin(origins = "*", maxAge = 36000)
    @RequestMapping(value = "/getTarotCard")
    public Map getTarotCard(boolean primary, int cardArray, String personality) {
        // 根据牌阵获取待抽取的牌数
        int cardAmount = CardArrays.getCardArraysByCode(cardArray).getCardSums();
        // 获取塔罗牌枚举
        List<TarotCardEnums> tarotCardEnums = new ArrayList<>();
        // 判断是否只启用主牌
        if (primary) {
            tarotCardEnums = TarotCardEnums.getTarotCardEnumsPrimaryList();
        } else {
            tarotCardEnums = TarotCardEnums.getTarotCardEnumsAssistList();
        }
        // 洗牌
        Collections.shuffle(tarotCardEnums);
        // 生成cardAmount个不一样的随机数
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < cardAmount; i++) {
            int random = (int) (Math.random() * tarotCardEnums.size());
            while (randomList.contains(random)) {
                random = (int) (Math.random() * tarotCardEnums.size());
            }
            randomList.add(random);
        }
        // 根据随机数获取塔罗牌
        List<String> tarotCardList = new ArrayList<>();
        for (int i = 0; i < randomList.size(); i++) {
            // 生成随机权重（0-1）;用于判断正位或逆位
            int seat = getSeat(Math.random());
            TarotCardEnums tarotCardEnum = tarotCardEnums.get(randomList.get(i));
            StringBuffer tarotCard = new StringBuffer();
            tarotCard.append("第").append(i + 1)
                    .append("张牌：")
                    .append(tarotCardEnum.getName())
                    .append("-")
                    .append(seat == 0 ? "正位" : "逆位")
                    .append(",对应星象：")
                    .append(tarotCardEnum.getConstellation())
                    .append(",对应数字：")
                    .append(tarotCardEnum.getValue())
                    .append(",对应释义：");

            tarotAnalysisService.getCardAnalysis(tarotCardEnum.getIndex() + 1, seat).forEach(tarotAnalysis -> {
                tarotCard.append(tarotAnalysis.getCnMeaning());
            });
            tarotCard.append(",对应关键词：");
            tarotKeyWordService.getKeyWordByCardId(tarotCardEnum.getIndex() + 1).forEach(tarotKeyWord -> {
                tarotCard.append(tarotKeyWord.getCnKeyword()).append(";");
            });
            // 将塔罗牌添加到集合中
            tarotCardList.add(tarotCard.toString());
        }
        // 问题信息
        StringBuffer context = new StringBuffer();
        tarotCardList.forEach(tarotCard -> {
            context.append(tarotCard.toString()).append(";");
        });
        // 追加指令
        if (cardArray > 0) {
            context.append("请根据上述信息，使用").append(CardArrays.getCardArraysByCode(cardArray).getName()).append("牌阵进行塔罗牌占卜，并给出不少于").append((tarotCardList.size() * 100)).append("字的建议或意见。");
        }
        StringBuffer result = new StringBuffer("您的塔罗牌已经选好了，小萝为您准备了一份专属的建议，请查收：\r\n");
        int failed = 0;
        // 调用GPT-3接口获取结果
        while (result.length() == 32) {
            String gpt = restTemplate.getForObject("http://API-GPT/chat/" + context.toString(), String.class);
            if (gpt != null) {
                result.append(gpt);
            } else {
                failed++;
            }
            if (result.length() > 32 || failed > 5) {
                break;
            }
        }
        if (failed > 5) {
            result.append("排队人数太多啦，小萝正在拼命为您占卜中，占卜完成后小萝会第一时间通知您，还请主人稍事等待~/(ㄒoㄒ)/~~");
        }
        Map record = new HashMap();
        record.put("context", context.toString());
        record.put("result", result.toString());
        return record;
    }

    private int getSeat(double weight) {
        double random = Math.random();
        if (random < random) {
            return 0;
        } else {
            return 1;
        }
    }

}
