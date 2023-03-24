package com.collisto.card.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName(value = "tarot_keyword")
public class TarotKeyWord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id; // 主键

    @TableField(value = "card_id")
    private String cardId; // 卡牌id

    @TableField (value = "cn_keyword")
    private String cnKeyword; // 中文关键词

    @TableField(value = "en_keyword")
    private String enKeyword; // 英文关键词

    @TableField(value = "tag")
    private Integer tag; // 标签

    @TableField(value = "type")
    private Integer type; // 类型

    @TableField(value = "extra")
    private Integer extra; // 额外信息

    @TableField(value = "extra_id")
    private Integer extraId; // 额外信息id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCnKeyword() {
        return cnKeyword;
    }

    public void setCnKeyword(String cnKeyword) {
        this.cnKeyword = cnKeyword;
    }

    public String getEnKeyword() {
        return enKeyword;
    }

    public void setEnKeyword(String enKeyword) {
        this.enKeyword = enKeyword;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getExtra() {
        return extra;
    }

    public void setExtra(Integer extra) {
        this.extra = extra;
    }

    public Integer getExtraId() {
        return extraId;
    }

    public void setExtraId(Integer extraId) {
        this.extraId = extraId;
    }

}
