package com.collisto.card.controller;

import com.collisto.card.entity.TarotKeyWord;
import com.collisto.card.service.TarotKeyWordService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarotKeyWordController {

    @Resource
    TarotKeyWordService tarotKeyWordService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/tarotKeyWord/insert")
    public Result insertTarotKeyWord(@RequestBody TarotKeyWord tarotKeyWord) {
        int result = tarotKeyWordService.insertTarotKeyWord(tarotKeyWord);
        if (result > 0) {
            return Result.success(tarotKeyWord);
        } else {
            return Result.error("插入失败");
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/tarotKeyWord/insertBatch")
    public Result insertBatchTarotKeyWord(Integer tarotCardId, Integer type, Boolean extra, Integer extra_id, String keyWords) {
        int success = 0;
        String[] keyword = keyWords.split(",");
        if (keyword.length == 0) {
            return Result.error("KeyWords不能为空");
        } else {
            for (String word : keyword) {
                if (word == null || word.equals("")) {
                    return Result.error("KeyWord不能为空");
                } else {
                    TarotKeyWord tarotKeyWord = new TarotKeyWord();
                    tarotKeyWord.setCardId(tarotCardId);
                    tarotKeyWord.setCnKeyword(word);
                    tarotKeyWord.setExtra(extra ? 1 : 0);
                    if (extra){
                        tarotKeyWord.setExtraId(extra_id);
                    }
                    tarotKeyWord.setType(type);
                    tarotKeyWord.setTag(0);
                    success += tarotKeyWordService.insertTarotKeyWord(tarotKeyWord);
                }
            }
        }
        if (success == keyword.length) {
            return Result.success("插入成功");
        } else {
            return Result.error("插入失败");
        }
    }


}
