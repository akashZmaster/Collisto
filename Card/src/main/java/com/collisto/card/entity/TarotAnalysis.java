package com.collisto.card.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName(value = "tarot_analysis")
public class TarotAnalysis implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id; // 主键

    @TableField(value = "card_id")
    private Integer cardId; // 卡牌id

    @TableField(value = "cn_meaning")
    private String cnMeaning; // 中文含义

    @TableField(value = "en_meaning")
    private String enMeaning; // 英文含义

    @TableField(value = "tarot_seat")
    private Integer tarotSeat; // 卡牌位置

    @TableField(value = "tag")
    private Integer tag; // 标签

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCnMeaning() {
        return cnMeaning;
    }

    public void setCnMeaning(String cnMeaning) {
        this.cnMeaning = cnMeaning;
    }

    public String getEnMeaning() {
        return enMeaning;
    }

    public void setEnMeaning(String enMeaning) {
        this.enMeaning = enMeaning;
    }

    public Integer getTarotSeat() {
        return tarotSeat;
    }

    public void setTarotSeat(Integer tarotSeat) {
        this.tarotSeat = tarotSeat;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }
}
