package com.collisto.card.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.collisto.card.entity.TarotKeyWord;
import com.collisto.card.mapper.TarotKeyWordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarotKeyWordService {

    @Resource
    TarotKeyWordMapper tarotKeyWordMapper;

    public int insertTarotKeyWord(TarotKeyWord tarotKeyWord) {
        return tarotKeyWordMapper.insert(tarotKeyWord);
    }

    public List<TarotKeyWord> getKeyWordByCardId(Integer id) {
        QueryWrapper<TarotKeyWord> query = new QueryWrapper<>();
        query.eq("card_id", id);
        return tarotKeyWordMapper.selectList(query);
    }

}
