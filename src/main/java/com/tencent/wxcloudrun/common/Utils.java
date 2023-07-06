package com.tencent.wxcloudrun.common;

public class Utils {

    public static String getExploreTimeStr(Integer timeNum){
        int finalTimeNum = timeNum+5;
        StringBuilder res = new StringBuilder();
        if (timeNum==60) {
            return "9:00";
        } else {
            res.append("8:");
            if (timeNum<10){
                res.append("0").append(timeNum);
            } else{
                res.append(timeNum);
            }

            res.append("-");
            if (finalTimeNum==60) {
                res.append("9:00");
            } else {
                res.append("8:");
                if (finalTimeNum<10){
                    res.append("0").append(finalTimeNum);
                } else{
                    res.append(finalTimeNum);
                }
            }
            return res.toString();
        }
    }
}
