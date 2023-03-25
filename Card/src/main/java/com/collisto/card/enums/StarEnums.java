package com.collisto.card.enums;

// 星象枚举类
public enum StarEnums {

    Uranus(1, "天王星"),
    Neptune(2, "海王星"),
    Pluto(3, "冥王星"),
    Mercury(4, "水星"),
    Venus(5, "金星"),
    Mars(6, "火星"),
    Jupiter(7, "木星"),
    Saturn(8, "土星"),
    Sun(9, "太阳"),
    Moon(10, "月亮"),
    Aries(11, "白羊座"),
    Taurus(12, "金牛座"),
    Gemini(13, "双子座"),
    Cancer(14, "巨蟹座"),
    Leo(15, "狮子座"),
    Virgo(16, "处女座"),
    Libra(17, "天秤座"),
    Scorpio(18, "天蝎座"),
    Sagittarius(19, "射手座"),
    Capricorn(20, "摩羯座"),
    Aquarius(21, "水瓶座"),
    Pisces(22, "双鱼座");


    private int code;
    private String name;

    StarEnums(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // 根据code获取name
    public static String getStarNameByCode(int code) {
        for (StarEnums star : StarEnums.values()) {
            if (star.code == code) {
                return star.name;
            }
        }
        return null;
    }

}
