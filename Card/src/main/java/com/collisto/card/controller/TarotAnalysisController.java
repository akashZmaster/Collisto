package com.collisto.card.controller;

import com.collisto.card.entity.TarotAnalysis;
import com.collisto.card.service.TarotAnalysisService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarotAnalysisController {

    @Resource
    TarotAnalysisService tarotAnalysisService;

    /**
     * 插入
     * @param tarotAnalysis
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/tarotAnalysis/insert")
    public Result insertTarotAnalysis(@RequestBody TarotAnalysis tarotAnalysis) {
        int result = tarotAnalysisService.insertTarotAnalysis(tarotAnalysis);
        if (result > 0) {
            return Result.success(tarotAnalysis);
        } else {
            return Result.error("插入失败");
        }
    }

    /**
     * 批量插入
     * @param tarotCardId
     * @param seat
     * @param meanings
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/tarotAnalysis/insertBatch")
    public Result insertBatchTarotAnalysis(Integer tarotCardId, Integer seat, String meanings) {
        int success = 0;
        String[] meaning = meanings.split("\\|");
        if (meaning.length == 0) {
            return Result.error("KeyWords不能为空");
        } else {
            for (String mean : meaning) {
                if (mean == null || mean.equals("")) {
                    return Result.error("mean不能为空");
                } else {
                    TarotAnalysis tarotAnalysis = new TarotAnalysis();
                    tarotAnalysis.setCardId(tarotCardId);
                    tarotAnalysis.setCnMeaning(mean);
                    tarotAnalysis.setTarotSeat(seat); // 0:正位 1:逆位
                    tarotAnalysis.setTag(0);
                    success += tarotAnalysisService.insertTarotAnalysis(tarotAnalysis);
                }
            }
        }
        if (success == meaning.length) {
            return Result.success("插入成功");
        } else {
            return Result.error("插入失败");
        }
    }

}
