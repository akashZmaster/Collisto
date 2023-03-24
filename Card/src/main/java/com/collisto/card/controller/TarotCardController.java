package com.collisto.card.controller;

import com.collisto.card.entity.TarotCard;
import com.collisto.card.service.TarotCardService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarotCardController {

    @Resource
    TarotCardService tarotCardService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/tarotCard/insert")
    public Result insertTarotCard(@RequestBody TarotCard tarotCard) {
        int result = tarotCardService.insertTarotCard(tarotCard);
        if (result > 0) {
            return Result.success(tarotCard);
        } else {
            return Result.error("插入失败");
        }
    }

}
