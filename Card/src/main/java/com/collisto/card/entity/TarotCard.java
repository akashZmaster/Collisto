package com.collisto.card.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName(value = "tarot_card")
public class TarotCard implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id; // 主键

    @TableField(value = "cn_name")
    private String cnName; // 中文名

    @TableField(value = "en_name")
    private String enName; // 英文名

    @TableField(value = "surface_val")
    private Integer surfaceVal; // 表面值

    @TableField(value = "real_val")
    private Integer realVal; // 实际值

    @TableField(value = "relation_star")
    private Integer relationStar; // 关联星座

    @TableField(value = "positive_img")
    private String positiveImg; // 正位图片

    @TableField(value = "negative_img")
    private String negativeImg; // 逆位图片

    @TableField(value = "tarot_type")
    private Integer tarotType; // 卡牌类型

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public Integer getSurfaceVal() {
        return surfaceVal;
    }

    public void setSurfaceVal(Integer surfaceVal) {
        this.surfaceVal = surfaceVal;
    }

    public Integer getRealVal() {
        return realVal;
    }

    public void setRealVal(Integer realVal) {
        this.realVal = realVal;
    }

    public Integer getRelationStar() {
        return relationStar;
    }

    public void setRelationStar(Integer relationStar) {
        this.relationStar = relationStar;
    }

    public String getPositiveImg() {
        return positiveImg;
    }

    public void setPositiveImg(String positiveImg) {
        this.positiveImg = positiveImg;
    }

    public String getNegativeImg() {
        return negativeImg;
    }

    public void setNegativeImg(String negativeImg) {
        this.negativeImg = negativeImg;
    }

    public Integer getTarotType() {
        return tarotType;
    }

    public void setTarotType(Integer tarotType) {
        this.tarotType = tarotType;
    }

}
