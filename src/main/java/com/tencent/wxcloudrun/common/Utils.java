package com.tencent.wxcloudrun.common;

import java.util.List;

public class Utils {

    public static final String finalMapRoom = "9";
    public static final String captainName = "船长";

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

    public static String getCurrentTime(Integer timeNum){

        StringBuilder res = new StringBuilder();
        if (timeNum==60 || timeNum==55) {
            return "9:00";
        } else {
            Integer afterExploreTime = timeNum+5;
            res.append("8:");
            if (afterExploreTime<10){
                res.append("0").append(afterExploreTime);
            } else{
                res.append(afterExploreTime);
            }

            return res.toString();
        }
    }

    public static int getToolRoleNo(List<Integer> arrivedTimeSortedList){
        for (int i=1; i<=arrivedTimeSortedList.size(); i++) {
            Integer arrivedTime = arrivedTimeSortedList.get(i-1);
            if (arrivedTimeSortedList.stream().filter(e->e.equals(arrivedTime)).count()==1) {
                return i;
            }
        }
        return 0;
    }
}
