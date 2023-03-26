package com.collisto.card.enums;

public enum CardArrays {

    NUN(0, "无", 1),
    // 把握未来
    FUTURE(1, "把握未来", 1),
    // 是或否
    YES_OR_NO(2, "YES OR NO", 1),
    // 得失
    GAIN_AND_LOSS(3, "得失", 2),
    // 活力
    ENERGY(4, "活力", 2),
    // 星期
    WEEK(5, "星期", 2),
    // 每天
    DAY(6, "每天", 2),
    // 时间流
    TIME(7, "时间流", 3);

    private int code;
    private String name;
    private int cardSums;

    CardArrays(int code, String name, int cardSums) {
        this.code = code;
        this.name = name;
        this.cardSums = cardSums;
    }

    // 根据code获取name
    public static CardArrays getCardArraysByCode(int code) {
        for (CardArrays cardArrays : CardArrays.values()) {
            if (cardArrays.code == code) {
                return cardArrays;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCardSums() {
        return cardSums;
    }
}
