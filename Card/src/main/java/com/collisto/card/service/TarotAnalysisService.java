package com.collisto.card.service;

import com.collisto.card.entity.TarotAnalysis;
import com.collisto.card.mapper.TarotAnalysisMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TarotAnalysisService {

    @Resource
    TarotAnalysisMapper tarotAnalysisMapper;

    public int insertTarotAnalysis(TarotAnalysis tarotAnalysis) {
        return tarotAnalysisMapper.insert(tarotAnalysis);
    }

}
