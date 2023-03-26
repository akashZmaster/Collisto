package com.collisto.card.enums;

import java.util.ArrayList;
import java.util.List;

public enum TarotCardEnums {

    Fool(0, 0, "愚者", "天王星"),
    Magician(1, 1, "魔术师", "水星"),
    HighPriestess(2, 2, "女祭司", "月亮"),
    Empress(3, 3, "女皇", "金星"),
    Emperor(4, 4, "皇帝", "白羊座"),
    Hierophant(5, 5, "教皇", "金牛座"),
    Lovers(6, 6, "恋人", "双子座"),
    Chariot(7, 7, "战车", "巨蟹座"),
    Strength(8, 8, "力量", "狮子座"),
    Hermit(9, 9, "隐者", "处女座"),
    WheelOfFortune(10, 10, "命运之轮", "木星"),
    Justice(11, 11, "正义", "天秤座"),
    HangedMan(12, 12, "倒吊人", "海王星"),
    Death(13, 13, "死神", "冥王星"),
    Temperance(14, 14, "节制", "射手座"),
    Devil(15, 15, "恶魔", "摩羯座"),
    Tower(16, 16, "塔", "火星"),
    Star(17, 17, "星星", "水瓶座"),
    Moon(18, 18, "月亮", "双鱼座"),
    Sun(19, 19, "太阳", "太阳"),
    Judgement(20, 20, "审判", "天蝎座"),
    World(21, 21, "世界", "土星"),
    ACEOFWANDS(22, 0, "权杖首牌", ""),
    TWOOFWANDS(23, 1, "权杖二", ""),
    THREEOFWANDS(24, 2, "权杖三", ""),
    FOUROFWANDS(25, 3, "权杖四", ""),
    FIVEOFWANDS(26, 4, "权杖五", ""),
    SIXOFWANDS(27, 5, "权杖六", ""),
    SEVENOFWANDS(28, 6, "权杖七", ""),
    EIGHTOFWANDS(29, 7, "权杖八", ""),
    NINEOFWANDS(30, 8, "权杖九", ""),
    TENOFWANDS(31, 9, "权杖十", ""),
    PAGEOFWANDS(32, 10, "权杖侍从", ""),
    KNIGHTOFWANDS(33, 11, "权杖骑士", ""),
    QUEENOFWANDS(34, 12, "权杖女王", ""),
    KINGOFWANDS(35, 13, "权杖国王", ""),
    ACEOFPENTACLES(36, 0, "星币首牌", ""),
    TWOOFPENTACLES(37, 1, "星币二", ""),
    THREEOFPENTACLES(38, 2, "星币三", ""),
    FOUROFPENTACLES(39, 3, "星币四", ""),
    FIVEOFPENTACLES(40, 4, "星币五", ""),
    SIXOFPENTACLES(41, 5, "星币六", ""),
    SEVENOFPENTACLES(42, 6, "星币七", ""),
    EIGHTOFPENTACLES(43, 7, "星币八", ""),
    NINEOFPENTACLES(44, 8, "星币九", ""),
    TENOFPENTACLES(45, 9, "星币十", ""),
    PAGEOFPENTACLES(46, 10, "星币侍从", ""),
    KNIGHTOFPENTACLES(47, 11, "星币骑士", ""),
    QUEENOFPENTACLES(48, 12, "星币女王", ""),
    KINGOFPENTACLES(49, 13, "星币国王", ""),
    ACEOFCUPS(50, 0, "圣杯首牌", ""),
    TWOOFCUPS(51, 1, "圣杯二", ""),
    THREEOFCUPS(52, 2, "圣杯三", ""),
    FOUROFCUPS(53, 3, "圣杯四", ""),
    FIVEOFCUPS(54, 4, "圣杯五", ""),
    SIXOFCUPS(55, 5, "圣杯六", ""),
    SEVENOFCUPS(56, 6, "圣杯七", ""),
    EIGHTOFCUPS(57, 7, "圣杯八", ""),
    NINEOFCUPS(58, 8, "圣杯九", ""),
    TENOFCUPS(59, 9, "圣杯十", ""),
    PAGEOFCUPS(60, 10, "圣杯侍从", ""),
    KNIGHTOFCUPS(61, 11, "圣杯骑士", ""),
    QUEENOFCUPS(62, 12, "圣杯女王", ""),
    KINGOFCUPS(63, 13, "圣杯国王", ""),
    ACEOFSWORDS(64, 0, "宝剑首牌", ""),
    TWOOFSWORDS(65, 1, "宝剑二", ""),
    THREEOFSWORDS(66, 2, "宝剑三", ""),
    FOUROFSWORDS(67, 3, "宝剑四", ""),
    FIVEOFSWORDS(68, 4, "宝剑五", ""),
    SIXOFSWORDS(69, 5, "宝剑六", ""),
    SEVENOFSWORDS(70, 6, "宝剑七", ""),
    EIGHTOFSWORDS(71, 7, "宝剑八", ""),
    NINEOFSWORDS(72, 8, "宝剑九", ""),
    TENOFSWORDS(73, 9, "宝剑十", ""),
    PAGEOFSWORDS(74, 10, "宝剑侍从", ""),
    KNIGHTOFSWORDS(75, 11, "宝剑骑士", ""),
    QUEENOFSWORDS(76, 12, "宝剑女王", ""),
    KINGOFSWORDS(77, 13, "宝剑国王", "");
    private int index;
    private int value;
    private String name;
    private String constellation;

    TarotCardEnums(int index, int value, String name, String constellation) {
        this.index = index;
        this.value = value;
        this.name = name;
        this.constellation = constellation;
    }

    public int getIndex() {
        return index;
    }


    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    public String getConstellation() {
        return constellation;
    }


    /**
     * 获取牌的索引
     *
     * @return
     */
    public static TarotCardEnums getTarotCardEnumsByIndex(int index) {
        for (TarotCardEnums tarotCardEnums : TarotCardEnums.values()) {
            if (tarotCardEnums.index == index) {
                return tarotCardEnums;
            }
        }
        return null;
    }

    /**
     * 获取主牌
     *
     * @return
     */
    public static final List<TarotCardEnums> getTarotCardEnumsPrimaryList() {
        List<TarotCardEnums> tarotCardEnumsList = new ArrayList<>();
        for (TarotCardEnums tarotCardEnums : TarotCardEnums.values()) {
            if (tarotCardEnums.index < 22) {
                tarotCardEnumsList.add(tarotCardEnums);
            }
        }
        return tarotCardEnumsList;
    }

    /**
     * 获取协助牌
     *
     * @return
     */
    public static final List<TarotCardEnums> getTarotCardEnumsAssistList() {
        List<TarotCardEnums> tarotCardEnumsList = new ArrayList<>();
        for (TarotCardEnums tarotCardEnums : TarotCardEnums.values()) {
            if (tarotCardEnums.index >= 22) {
                tarotCardEnumsList.add(tarotCardEnums);
            }
        }
        return tarotCardEnumsList;
    }

}
