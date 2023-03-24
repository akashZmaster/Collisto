package com.collisto.card.service;

import com.collisto.card.entity.TarotCard;
import com.collisto.card.mapper.TarotCardMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TarotCardService {

    @Resource
    TarotCardMapper tarotCardMapper;

    public int insertTarotCard(TarotCard tarotCard) {
        return tarotCardMapper.insert(tarotCard);
    }

}
