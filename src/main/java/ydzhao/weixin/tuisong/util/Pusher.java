package ydzhao.weixin.tuisong.util;

import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.time.LocalDate;

import static ydzhao.weixin.tuisong.common.ValCommons.bxlTemplate;
import static ydzhao.weixin.tuisong.common.ValCommons.sltTemplate;

/**
 * @ClassName Pusher
 * @Description TODO
 * @Author ydzhao
 * @Date 2022/8/2 16:03
 */
public class Pusher {
    /**
     * 测试号的appId和secret
     */
    private static String appId = "wx8e3f00ec14ef8f2e";
    private static String secret = "abbedd7f9228e178c4cd9959737cf0f5";

    public static void push(String openId) throws Exception {
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
//            .templateId(bxlTemplate)
                .templateId(bxlTemplate)
                //.url("https://30paotui.com/")//点击模版消息要访问的网址
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        //        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));
        //填写变量信息，比如天气之类的
        JSONObject todayWeather = Tianqi.getNanjiTianqi();
        templateMessage.addData(new WxMpTemplateData("riqi", todayWeather.getString("date") + "  " + todayWeather.getString("week"), "#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("tianqi", todayWeather.getString("text_day"), "#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("low", todayWeather.getString("low") + "", "#173177"));
        templateMessage.addData(new WxMpTemplateData("high", todayWeather.getString("high") + "", "#FF6347"));
        templateMessage.addData(new WxMpTemplateData("caihongpi", CaiHongPi.getCaiHongPi(), "#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("lianai", JiNianRi.getLianAi() + "", "#FF1493"));
//        templateMessage.addData(new WxMpTemplateData("shengri",JiNianRi.getShengRi()+"","#FFA500"));
        try {
            templateMessage.addData(new WxMpTemplateData("shengri", JiNianRi.getNongLiShengRi() + "", "#FFA500"));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        templateMessage.addData(new WxMpTemplateData("jingdiantaici",CaiHongPi.getJingDianTaiCi()+"","#FFA500"));
        templateMessage.addData(new WxMpTemplateData("jinju", CaiHongPi.getJinJu() + "", "#C71585"));
        //templateMessage.addData(new WxMpTemplateData("jiehun",JiNianRi.getJieHun()+""));
//        templateMessage.addData(new WxMpTemplateData("linzhen",JiNianRi.getLinZhen()+"","#FF6347"));
        String beizhu = "猪猪机器人为最爱的宝宝带来今天的最新消息";
//        String beizhu = "嘿嘿嘿，恁爹来咯";
        if (JiNianRi.getLianAi() % 365 == 0) {
            beizhu = "今天是恋爱纪念日！";
        }
        if (JiNianRi.getNongLiShengRi() == 0) {
            beizhu = "今天是亲亲宝宝的生日！";
        }
        templateMessage.addData(new WxMpTemplateData("beizhu", beizhu, "#FF0000"));


        try {
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void push(String openId, String templateId) throws Exception {
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(templateId)
                //.url("https://30paotui.com/")//点击模版消息要访问的网址
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        //        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));
        //填写变量信息，比如天气之类的
        JSONObject todayWeather = Tianqi.getNanjiTianqi();
        String riqi = todayWeather.getString("date") + "  " + todayWeather.getString("week");
        if (CalendarUtil.isTodaySpecifiedDate(5, 21)) {
            riqi = riqi + "," + (LocalDate.now().getYear() - 2021) + "年前的今天,我们在一起啦😘~~";
        }
        templateMessage.addData(new WxMpTemplateData("riqi", riqi, "#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("tianqi", todayWeather.getString("text_day"), "#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("low", todayWeather.getString("low") + "", "#173177"));
        templateMessage.addData(new WxMpTemplateData("high", todayWeather.getString("high") + "", "#FF6347"));
        templateMessage.addData(new WxMpTemplateData("caihongpi", CaiHongPi.getCaiHongPi(), "#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("lianai", JiNianRi.getLianAi() + "", "#FF1493"));
//        templateMessage.addData(new WxMpTemplateData("shengri",JiNianRi.getShengRi()+"","#FFA500"));
        try {
            templateMessage.addData(new WxMpTemplateData("shengri", JiNianRi.getNongLiShengRi() + "", "#FFA500"));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        templateMessage.addData(new WxMpTemplateData("jingdiantaici",CaiHongPi.getJingDianTaiCi()+"","#FFA500"));
        templateMessage.addData(new WxMpTemplateData("jinju", CaiHongPi.getJinJu() + "", "#C71585"));
        //templateMessage.addData(new WxMpTemplateData("jiehun",JiNianRi.getJieHun()+""));
//        templateMessage.addData(new WxMpTemplateData("linzhen",JiNianRi.getLinZhen()+"","#FF6347"));
        String beizhu = "猪猪机器人为最爱的宝宝带来今天的最新消息🌹🌹";
        if (!templateId.equals(bxlTemplate)) {
            beizhu = "查收宝宝最新城市情况";
        }
        if (JiNianRi.getLianAi() % 365 == 0) {
            beizhu = "今天是恋爱纪念日！ 我们已经在一起" + JiNianRi.getLianAi() / 365 + "周年啦。";

        }
        if (JiNianRi.getNongLiShengRi() == 0) {
            beizhu = "宝宝，祝你生日快乐~🎂🎂";
        }
        templateMessage.addData(new WxMpTemplateData("beizhu", beizhu, "#FF0000"));


        try {
            System.out.println();
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void pushAfternoon(String openId, String templateId) throws Exception {
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(templateId)
                //.url("https://30paotui.com/")//点击模版消息要访问的网址
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        //        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));
        //填写变量信息，比如天气之类的
        JSONObject todayWeather = Tianqi.getNanjiTianqi();
        String riqi = todayWeather.getString("date") + "  " + todayWeather.getString("week");
        if (CalendarUtil.isTodaySpecifiedDate(5, 21)) {
            riqi = riqi + "," + (LocalDate.now().getYear() - 2021) + "年前的今天,我们在一起啦😘~~";
        }
        templateMessage.addData(new WxMpTemplateData("riqi", riqi, "#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("tianqi", todayWeather.getString("text_day"), "#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("low", todayWeather.getString("low") + "", "#173177"));
        templateMessage.addData(new WxMpTemplateData("high", todayWeather.getString("high") + "", "#FF6347"));
        templateMessage.addData(new WxMpTemplateData("caihongpi", CaiHongPi.getCaiHongPi(), "#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("lianai", JiNianRi.getLianAi() + "", "#FF1493"));
//        templateMessage.addData(new WxMpTemplateData("shengri",JiNianRi.getShengRi()+"","#FFA500"));
        try {
            templateMessage.addData(new WxMpTemplateData("shengri", JiNianRi.getNongLiShengRi() + "", "#FFA500"));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        templateMessage.addData(new WxMpTemplateData("jingdiantaici",CaiHongPi.getJingDianTaiCi()+"","#FFA500"));
        templateMessage.addData(new WxMpTemplateData("jinju", CaiHongPi.getSayLove() + "", "#C71585"));
        //templateMessage.addData(new WxMpTemplateData("jiehun",JiNianRi.getJieHun()+""));
//        templateMessage.addData(new WxMpTemplateData("linzhen",JiNianRi.getLinZhen()+"","#FF6347"));
        String beizhu = "每日对宝宝表达的情话~";
        if (!templateId.equals(bxlTemplate)) {
            beizhu = "查收宝宝最新城市情况";
        }
        if (JiNianRi.getLianAi() % 365 == 0) {
            beizhu = "今天是恋爱纪念日！ 我们已经在一起" + JiNianRi.getLianAi() / 365 + "周年啦。";

        }
        if (JiNianRi.getNongLiShengRi() == 0) {
            beizhu = "宝宝，祝你生日快乐~🎂🎂";
        }
        templateMessage.addData(new WxMpTemplateData("beizhu", beizhu, "#FF0000"));


        try {
            System.out.println();
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }


    public static void pushEvening(String openId, String templateId) throws Exception {
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(templateId)
                //.url("https://30paotui.com/")//点击模版消息要访问的网址
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        //        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));
        //填写变量信息，比如天气之类的
        JSONObject todayWeather = Tianqi.getNanjiTianqi();
        String riqi = todayWeather.getString("date") + "  " + todayWeather.getString("week");
        if (CalendarUtil.isTodaySpecifiedDate(5, 21)) {
            riqi = riqi + "," + (LocalDate.now().getYear() - 2021) + "年前的今天,我们在一起啦😘~~";
        }
        templateMessage.addData(new WxMpTemplateData("riqi", riqi, "#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("tianqi", todayWeather.getString("text_day"), "#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("low", todayWeather.getString("low") + "", "#173177"));
        templateMessage.addData(new WxMpTemplateData("high", todayWeather.getString("high") + "", "#FF6347"));
        templateMessage.addData(new WxMpTemplateData("caihongpi", CaiHongPi.getCaiHongPi(), "#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("lianai", JiNianRi.getLianAi() + "", "#FF1493"));
//        templateMessage.addData(new WxMpTemplateData("shengri",JiNianRi.getShengRi()+"","#FFA500"));
        try {
            templateMessage.addData(new WxMpTemplateData("shengri", JiNianRi.getNongLiShengRi() + "", "#FFA500"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        templateMessage.addData(new WxMpTemplateData("jinju", CaiHongPi.getZhongYao() + "", "#C71585"));
        String beizhu = "猪猪机器人今日晚上为宝宝带来中药小知识！";
        if (!templateId.equals(bxlTemplate)) {
            beizhu = "查收宝宝最新城市情况";
        }
        if (JiNianRi.getLianAi() % 365 == 0) {
            beizhu = "今天是恋爱纪念日！ 我们已经在一起" + JiNianRi.getLianAi() / 365 + "周年啦。";

        }
        if (JiNianRi.getNongLiShengRi() == 0) {
            beizhu = "宝宝，祝你生日快乐~🎂🎂";
        }
        templateMessage.addData(new WxMpTemplateData("beizhu", beizhu, "#FF0000"));


        try {
            System.out.println();
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
