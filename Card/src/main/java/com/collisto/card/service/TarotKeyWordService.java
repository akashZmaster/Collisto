package com.collisto.card.service;

import com.collisto.card.entity.TarotKeyWord;
import com.collisto.card.mapper.TarotKeyWordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TarotKeyWordService {

    @Resource
    TarotKeyWordMapper tarotKeyWordMapper;

    public int insertTarotKeyWord(TarotKeyWord tarotKeyWord) {
        return tarotKeyWordMapper.insert(tarotKeyWord);
    }

}
