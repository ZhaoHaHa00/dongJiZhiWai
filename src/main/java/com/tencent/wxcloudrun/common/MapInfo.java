package com.tencent.wxcloudrun.common;

import lombok.Data;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapInfo {

    public static final HashMap<String, String> roleInfo = new HashMap<String, String>(){
        {
            put("1", "露西亚");
            put("2", "迪伦");
            put("3", "白茗");
            put("4", "罗德里克");
            put("5", "森");
            put("6", "卡尔");
        }
    };

    public static final HashMap<String, String> mapRoomNum = new HashMap<String, String>(){
        {
            put("1", "杂物间");
            put("2", "锚链舱");
            put("3", "电力间");
            put("4", "休息室");
            put("5", "餐厅");
            put("6", "厨房");
            put("7", "储藏室1");
            put("8", "货仓1");
            put("9", "货仓2");
            put("10", "燃油舱");
            put("11", "备用清水仓");
            put("12", "压载水舱");
            put("13", "舵机舱");
            put("14", "储藏室2");
        }
    };

    public static final HashMap<String, List<String>> mapRoom = new HashMap<String, List<String>>(){
        {
            put("mapRoom1_1", new ArrayList<String>(){
                {
                    add("有一些凌乱的杂物，一个维修工具箱，有一卷鱼线");
                    add("有一些凌乱的杂物，一个维修工具箱，有一卷鱼线，工具箱和鱼线有被翻动的痕迹，地面上有一串脚印");
                    add("有一些凌乱的杂物，一个维修工具箱，有一卷鱼线，工具箱和鱼线有被翻动的痕迹，地面上有混乱的脚印");
                    add("有一些凌乱的杂物，一个维修工具箱，有一卷鱼线，工具箱和鱼线有被翻动的痕迹，地面上有混乱的脚印");
                }
            });
            put("mapRoom2_1", new ArrayList<String>(){
                {
                    add("设施完好，设备能够正常工作，舱室角落地面有一根撬棍");
                    add("设施完好，设备能够正常工作，舱室角落地面灰尘中，有条状物品的痕迹，地面上有一串脚印");
                    add("设施完好，设备能够正常工作，舱室角落地面灰尘中，有条状物品的痕迹，地面上有混乱的脚印");
                    add("设施完好，设备能够正常工作，舱室角落地面灰尘中，有条状物品的痕迹，地面上有混乱的脚印");
                }
            });
            put("mapRoom3_1", new ArrayList<String>(){
                {
                    add("线路不稳定只能维持30分钟，经检查后有多次电路修复记录，电力间线路散乱在地上，电力间的线路有人为破坏的痕迹，地面上有凌乱的脚印");
                    add("线路不稳定只能维持30分钟，经检查后有多次电路修复记录，电力间线路散乱在地上，电力间的线路有人为破坏的痕迹，地面上有凌乱的脚印");
                    add("线路不稳定只能维持30分钟，经检查后有多次电路修复记录，电力间线路散乱在地上，电力间的线路有人为破坏的痕迹，地面上有凌乱的脚印");
                    add("线路不稳定只能维持30分钟，经检查后有多次电路修复记录，电力间线路散乱在地上，电力间的线路有人为破坏的痕迹，地面上有凌乱的脚印");
                }
            });
            put("mapRoom4_1", new ArrayList<String>(){
                {
                    add("当中有一个上锁的房间，有些已经开封了的变质食物和水，地面上有一些烟头，桌子上有一盒香烟");
                    add("当中有一个上锁的房间，有些已经开封了的变质食物和水，地面上有一些烟头和几根散乱的香烟，地面上有一串脚印");
                    add("当中有一个上锁的房间，有些已经开封了的变质食物和水，地面上有一些烟头和几根散乱的香烟，地面上有混乱的脚印");
                    add("当中有一个上锁的房间，有些已经开封了的变质食物和水，地面上有一些烟头和几根散乱的香烟，地面上有混乱的脚印");
                }
            });
            put("mapRoom5_1", new ArrayList<String>(){
                {
                    add("餐桌上有大量的食物残留，是罐头一类的物品，看样子有很长时间了，桌椅散乱的摆放着，桌面上有七份使用过的餐具");
                    add("餐桌上有大量的食物残留，是罐头一类的物品，看样子有很长时间了，桌椅散乱的摆放着，桌面上有七份使用过的餐具，地面上有一串脚印");
                    add("餐桌上有大量的食物残留，是罐头一类的物品，看样子有很长时间了，桌椅散乱的摆放着，桌面上有七份使用过的餐具，地面上有混乱的脚印");
                    add("餐桌上有大量的食物残留，是罐头一类的物品，看样子有很长时间了，桌椅散乱的摆放着，桌面上有七份使用过的餐具，地面上有混乱的脚印");
                }
            });
            put("mapRoom6_1", new ArrayList<String>(){
                {
                    add("一套完整的刀具中少了一把剔骨刀，有少量的食物");
                    add("一套完整的刀具中少了一把剔骨刀，有少量的食物，地面上有一串脚印");
                    add("一套完整的刀具中少了一把剔骨刀，有少量的食物，地面上有混乱的脚印");
                    add("一套完整的刀具中少了一把剔骨刀，有少量的食物，地面上有混乱的脚印");
                }
            });
            put("mapRoom7_1", new ArrayList<String>(){
                {
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印");
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印");
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印");
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印");
                }
            });
            put("mapRoom8_1", new ArrayList<String>(){
                {
                    add("地面上的灰尘中有些杂乱的脚印有些散乱的空箱子，消防设备的位置有一把斧子");
                    add("地面上的灰尘中有些杂乱的脚印有些散乱的空箱子，消防设备的位置少了一把斧子，地面上有一串脚印");
                    add("地面上的灰尘中有些杂乱的脚印有些散乱的空箱子，消防设备的位置少了一把斧子，地面上有混乱脚印");
                    add("地面上的灰尘中有些杂乱的脚印有些散乱的空箱子，消防设备的位置少了一把斧子，地面上有混乱脚印");
                }
            });
            put("mapRoom9_1", new ArrayList<String>(){
                {
                    add("有燃尽的灯芯，有一些杂物箱");
                    add("有燃尽的灯芯，有一些杂物箱，地面上有一串脚印");
                    add("有燃尽的灯芯，有一些杂物箱，地面上有混乱的脚印");
                    add("有燃尽的灯芯，有一些杂物箱，地面上有混乱的脚印");
                }
            });
            put("mapRoom10_1", new ArrayList<String>(){
                {
                    add("燃油舱室已经被锁定");
                    add("燃油舱室已经被锁定，地面上有一串脚印");
                    add("燃油舱室已经被锁定，地面上有混乱的脚印");
                    add("燃油舱室已经被锁定，地面上有混乱的脚印");
                }
            });
            put("mapRoom11_1", new ArrayList<String>(){
                {
                    add("角落处地面上有一把锤子，清水仓水位较低");
                    add("角落处地面的灰尘上有像是钝器拖动地面的痕迹，清水仓水位较低，地面上有一串脚印");
                    add("角落处地面的灰尘上有像是钝器拖动地面的痕迹，清水仓水位较低，地面上有混乱的脚印");
                    add("角落处地面的灰尘上有像是钝器拖动地面的痕迹，清水仓水位较低，地面上有混乱的脚印");
                }
            });
            put("mapRoom12_1", new ArrayList<String>(){
                {
                    add("最近有多次加压记录，有一把剔骨刀");
                    add("最近有多次加压记录，角落的地面上有尖锐划痕，地面上有一串脚印");
                    add("最近有多次加压记录，角落的地面上有尖锐划痕，地面上有混乱的脚印");
                    add("最近有多次加压记录，角落的地面上有尖锐划痕，地面上有混乱的脚印");
                }
            });
            put("mapRoom13_1", new ArrayList<String>(){
                {
                    add("涡轮机组工作状态正常，燃气发生器工作状态正常，记录显示设备工作量位于超标状态");
                    add("涡轮机组工作状态正常，燃气发生器工作状态正常，记录显示设备工作量位于超标状态，地面上有一串脚印");
                    add("涡轮机组工作状态正常，燃气发生器工作状态正常，记录显示设备工作量位于超标状态，地面上有混乱的脚印");
                    add("涡轮机组工作状态正常，燃气发生器工作状态正常，记录显示设备工作量位于超标状态，地面上有混乱的脚印");
                }
            });
            put("mapRoom14_1", new ArrayList<String>(){
                {
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印");
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印");
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印");
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印");
                }
            });
            put("mapRoom1_2", new ArrayList<String>(){
                {
                    add("有一些凌乱的杂物，一个维修工具箱，有一卷鱼线");
                    add("有一些凌乱的杂物，一个维修工具箱，有一卷鱼线，工具箱和鱼线有被翻动的痕迹，地面上有一串脚印");
                    add("有一些凌乱的杂物，一个维修工具箱，有一卷鱼线，工具箱和鱼线有被翻动的痕迹，地面上有混乱的脚印");
                    add("有一些凌乱的杂物，一个维修工具箱，有一卷鱼线，工具箱和鱼线有被翻动的痕迹，地面上有混乱的脚印");
                }
            });
            put("mapRoom2_2", new ArrayList<String>(){
                {
                    add("设施完好，设备能够正常工作，舱室角落地面有一根撬棍");
                    add("设施完好，设备能够正常工作，舱室角落地面灰尘中，有条状物品的痕迹，地面上有一串脚印");
                    add("设施完好，设备能够正常工作，舱室角落地面灰尘中，有条状物品的痕迹，地面上有混乱的脚印");
                    add("设施完好，设备能够正常工作，舱室角落地面灰尘中，有条状物品的痕迹，地面上有混乱的脚印");
                }
            });
            put("mapRoom3_2", new ArrayList<String>(){
                {
                    add("线路不稳定只能维持30分钟，经检查后有多次电路修复记录，电力间线路散乱在地上，电力间的线路有人为破坏的痕迹，地面上有凌乱的脚印，角落处有红色发夹");
                    add("线路不稳定只能维持30分钟，经检查后有多次电路修复记录，电力间线路散乱在地上，电力间的线路有人为破坏的痕迹，地面上有凌乱的脚印，角落处有红色发夹");
                    add("线路不稳定只能维持30分钟，经检查后有多次电路修复记录，电力间线路散乱在地上，电力间的线路有人为破坏的痕迹，地面上有凌乱的脚印，角落处有红色发夹");
                    add("线路不稳定只能维持30分钟，经检查后有多次电路修复记录，电力间线路散乱在地上，电力间的线路有人为破坏的痕迹，地面上有凌乱的脚印，角落处有红色发夹");
                }
            });
            put("mapRoom4_2", new ArrayList<String>(){
                {
                    add("当中有一个上锁的房间，有些已经开封了的变质食物和水，地面上有一些烟头，桌子上有一盒香烟");
                    add("当中有一个上锁的房间，有些已经开封了的变质食物和水，地面上有一些烟头和几根散乱的香烟，地面上有一串脚印");
                    add("当中有一个上锁的房间，有些已经开封了的变质食物和水，地面上有一些烟头和几根散乱的香烟，地面上有混乱的脚印");
                    add("当中有一个上锁的房间，有些已经开封了的变质食物和水，地面上有一些烟头和几根散乱的香烟，地面上有混乱的脚印");
                }
            });
            put("mapRoom5_2", new ArrayList<String>(){
                {
                    add("餐桌上有大量的食物残留，是罐头一类的物品，看样子有很长时间了，桌椅散乱的摆放着，桌面上很整洁");
                    add("餐桌上有大量的食物残留，是罐头一类的物品，看样子有很长时间了，桌椅散乱的摆放着，桌面上很整洁，地面上有一串脚印");
                    add("餐桌上有大量的食物残留，是罐头一类的物品，看样子有很长时间了，桌椅散乱的摆放着，桌面上很整洁，地面上有混乱的脚印");
                    add("餐桌上有大量的食物残留，是罐头一类的物品，看样子有很长时间了，桌椅散乱的摆放着，桌面上很整洁，地面上有混乱的脚印");
                }
            });
            put("mapRoom6_2", new ArrayList<String>(){
                {
                    add("一套完整的刀具，有少量的食物");
                    add("一套完整的刀具，地面上有一串脚印");
                    add("一套完整的刀具，地面上有混乱的脚印");
                    add("一套完整的刀具，地面上有混乱的脚印");
                }
            });
            put("mapRoom7_2", new ArrayList<String>(){
                {
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印，在资源箱的缝隙中夹着一份写着露西亚名字的记者证");
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印，在资源箱的缝隙中夹着一份写着露西亚名字的记者证");
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印，在资源箱的缝隙中夹着一份写着露西亚名字的记者证");
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印，在资源箱的缝隙中夹着一份写着露西亚名字的记者证");
                }
            });
            put("mapRoom8_2", new ArrayList<String>(){
                {
                    add("地面上的灰尘中有些杂乱的脚印有些散乱的空箱子，消防设备中固定着一把消防斧");
                    add("地面上的灰尘中有些杂乱的脚印有些散乱的空箱子，消防设备中固定着一把消防斧，地面上有一串脚印");
                    add("地面上的灰尘中有些杂乱的脚印有些散乱的空箱子，消防设备中固定着一把消防斧，地面上有混乱脚印");
                    add("地面上的灰尘中有些杂乱的脚印有些散乱的空箱子，消防设备中固定着一把消防斧，地面上有混乱脚印");
                }
            });
            put("mapRoom9_2", new ArrayList<String>(){
                {
                    add("有燃尽的灯芯，有一些杂物箱");
                    add("有燃尽的灯芯，有一些杂物箱，地面上有一串脚印");
                    add("有燃尽的灯芯，有一些杂物箱，地面上有混乱的脚印");
                    add("有燃尽的灯芯，有一些杂物箱，地面上有混乱的脚印");
                }
            });
            put("mapRoom10_2", new ArrayList<String>(){
                {
                    add("燃油舱室已经被锁定");
                    add("燃油舱室已经被锁定，地面上有一串脚印");
                    add("燃油舱室已经被锁定，地面上有混乱的脚印");
                    add("燃油舱室已经被锁定，地面上有混乱的脚印");
                }
            });
            put("mapRoom11_2", new ArrayList<String>(){
                {
                    add("角落处地面上有一把锤子，清水仓水位较低");
                    add("角落处地面的灰尘上有像是钝器拖动地面的痕迹，清水仓水位较低，地面上有一串脚印");
                    add("角落处地面的灰尘上有像是钝器拖动地面的痕迹，清水仓水位较低，地面上有混乱的脚印");
                    add("角落处地面的灰尘上有像是钝器拖动地面的痕迹，清水仓水位较低，地面上有混乱的脚印");
                }
            });
            put("mapRoom12_2", new ArrayList<String>(){
                {
                    add("最近有多次加压记录");
                    add("最近有多次加压记录，地面上有一串脚印");
                    add("最近有多次加压记录，地面上有混乱的脚印");
                    add("最近有多次加压记录，地面上有混乱的脚印");
                }
            });
            put("mapRoom13_2", new ArrayList<String>(){
                {
                    add("涡轮机组工作状态正常，燃气发生器工作状态正常，记录显示设备工作量位于超标状态");
                    add("涡轮机组工作状态正常，燃气发生器工作状态正常，记录显示设备工作量位于超标状态，地面上有一串脚印");
                    add("涡轮机组工作状态正常，燃气发生器工作状态正常，记录显示设备工作量位于超标状态，地面上有混乱的脚印");
                    add("涡轮机组工作状态正常，燃气发生器工作状态正常，记录显示设备工作量位于超标状态，地面上有混乱的脚印");
                }
            });
            put("mapRoom14_2", new ArrayList<String>(){
                {
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印");
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印");
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印");
                    add("少量的资源储备，有一些标记着爆破物的箱子，已经上锁了，地面上有凌乱的脚印");
                }
            });
        }
    };

    public static final HashMap<String, String> mapRoomClue = new HashMap<String, String>(){
        {
            put("mapRoomClue1_1","鱼线，维修工具");
            put("mapRoomClue1_2","鱼线，维修工具");
            put("mapRoomClue2_1","撬棍");
            put("mapRoomClue2_2","撬棍");
            put("mapRoomClue4_1","香烟");
            put("mapRoomClue4_2","香烟");
            put("mapRoomClue8_1","消防斧");
            put("mapRoomClue8_2","消防斧");
            put("mapRoomClue11_1","锤子");
            put("mapRoomClue11_2","锤子");
            put("mapRoomClue12_1","剔骨刀");
        }

    };

    public static final HashMap<String, String> roleStartPosition = new HashMap<String, String>(){
        {
            put("1","7");
            put("2","14");
            put("3","3");
            put("4","4");
            put("5","6");
            put("6","10");
        }
    };

}
