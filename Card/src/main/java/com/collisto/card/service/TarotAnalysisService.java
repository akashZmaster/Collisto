package com.collisto.card.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.collisto.card.entity.TarotAnalysis;
import com.collisto.card.mapper.TarotAnalysisMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarotAnalysisService {

    @Resource
    TarotAnalysisMapper tarotAnalysisMapper;

    public int insertTarotAnalysis(TarotAnalysis tarotAnalysis) {
        return tarotAnalysisMapper.insert(tarotAnalysis);
    }

    public List<TarotAnalysis> getCardAnalysis(Integer id, Integer tarotSeat) {
        QueryWrapper<TarotAnalysis> query = new QueryWrapper<>();
        query.eq("card_id", id);
        query.eq("tarot_seat", tarotSeat);
        return tarotAnalysisMapper.selectList(query);
    }

}
