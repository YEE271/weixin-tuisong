package ydzhao.weixin.tuisong.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName CaiHongPi
 * @Description TODO
 * @Author ydzhao
 * @Date 2022/8/2 17:26
 */
public class CaiHongPi {
    private static String key = "fb4e50af7f42eb3a396d9040ebadca22";
    private static String taiCiKey = "fb4e50af7f42eb3a396d9040ebadca22";
    private static String url = "http://apis.tianapi.com/caihongpi/index?key=";
    private static String taiCiUrl = "http://apis.tianapi.com/dialogue/index?key=";
    private static String zhongyao = "https://apis.tianapi.com/zhongyao/index?key=";
    private static String tuwei = "https://apis.tianapi.com/zhongyao/saylove?key=";
    private static List<String> jinJuList = new ArrayList<>();
    private static String name = "宝宝";
//    private static String name = "傻狗";

    public static String getCaiHongPi() {
        //默认彩虹屁
        String str = "阳光落在屋里，爱你藏在心里";
        try {
            JSONObject jsonObject = JSONObject.parseObject(HttpUtil.getUrl(url + key).replace("XXX", name));
            if (jsonObject.getIntValue("code") == 200) {
                str = jsonObject.getJSONObject("result").getString("content");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getJingDianTaiCi() {
        //默认彩虹屁
        String str = "说好是一辈子就是一辈子，差一年一个月一天一个时辰都不行。";
        try {
            JSONObject jsonObject = JSONObject.parseObject(HttpUtil.getUrl(taiCiUrl + taiCiKey).replace("XXX", name));
            if (jsonObject.getIntValue("code") == 200) {
                str = jsonObject.getJSONObject("result").getString("dialogue");
                str = str + "出处:" + jsonObject.getJSONObject("result").getString("source");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getZhongYao() {
        String all = "巴豆霜,巴戟天,白扁豆,白矾,白附子,白果,白花蛇舌草,白及,白蒺藜,白芥子,白僵蚕,白蔹,白茅根,白前,白芍,白晒参,白术,白头翁,白薇,白鲜皮,白芷,百部,百合,柏子仁,败酱草,斑蝥,板蓝根,半边莲,半夏,半夏曲,半枝莲,北豆根,北沙参,荜茇,荜澄茄,萹蓄,鳖甲,槟榔,冰片,薄荷,薄荷脑,补骨脂,八角茴香,巴豆,苍耳子,苍术,草豆蔻,草果,草乌,草乌叶,侧柏叶,柴胡,炒白术,炒麦芽,炒谷芽,炒常山,炒牛蒡子,炒苏子,炒山甲,炒山楂,蝉蜕,蟾酥,蟾皮,常山,车前草,车前子,沉香,陈皮,柽柳,赤芍,赤石脂,赤小豆,臭梧桐,楮实子,茺蔚子,虫白蜡,川贝母,川楝子,川木通,川木香,川牛膝,川乌,川芎,川断,穿山甲,穿山龙,穿心莲,垂盆草,椿皮,椿白皮,磁石,刺蒺藜,刺猬皮,刺五加,葱白,苍耳草,蚕沙,苍耳子,苍术,草豆蔻,草果,草乌,草乌叶,侧柏叶,柴胡,炒白术,炒麦芽,炒谷芽,炒常山,炒牛蒡子,炒苏子,炒山甲,炒山楂,蝉蜕,蟾酥,蟾皮,常山,车前草,车前子,沉香,陈皮,柽柳,赤芍,赤石脂,赤小豆,臭梧桐,楮实子,茺蔚子,虫白蜡,川贝母,川楝子,川木通,川木香,川牛膝,川乌,川芎,川断,穿山甲,穿山龙,穿心莲,垂盆草,椿皮,椿白皮,磁石,刺蒺藜,刺猬皮,刺五加,葱白,苍耳草,蚕沙,大腹皮,大黄,大蓟,大青叶,大蒜,大血藤,大枣,代赭石,丹参,胆矾,胆南星,淡豆鼓,淡竹叶,当归,党参,刀豆,刀豆子,稻芽,灯心草,地耳草,地枫皮,地肤子,地骨皮,地黄,地锦草,地龙,地榆,地榆炭,颠茄草,丁公藤,丁香,冬虫夏草,冬瓜皮,冬瓜仁,冬葵子,豆蔻,豆蔻壳,独活,杜仲,煅石膏,煅瓦楞子,煅龙骨,煅牡蛎,煅自燃铜,大豆黄卷,鹅不食草,阿胶,阿胶珠莪术,儿茶,番红花,翻白草,防风,防己,榧子,枫香脂,粉萆薢,蜂房,蜂蜡,蜂蜜,佛手,茯苓,茯苓皮,茯神,浮萍,浮小麦,附子,覆盆子,法半夏,番泻叶,干漆,甘草,甘松,甘遂,高良姜,藁本,葛根,葛花,蛤蚧,蛤壳,隔山消,功劳木,钩藤,狗脊,枸骨叶,枸杞子,谷精草,谷芽,骨碎补,瓜蒂,瓜蒌,瓜蒌皮,瓜蒌子,关白附,关木通,贯众,广防己,广藿香,广金钱草,广木香,广枣,龟板,桂枝,干姜,干地黄,海金沙藤,海浮石,海蛤壳,海狗肾,海龙,海马,海螵蛸,海藻,海桐皮,寒水石,诃子,合欢花,合欢皮,何首乌,核桃仁,荷梗,荷叶,鹤草芽,鹤虱,黑芝麻,红豆蔻,红花,红景天,红芽大戟,红参,红大戟,厚朴,厚朴花,胡黄连,胡椒,葫芦巴,胡荽,红颓子叶,葫芦,虎杖,琥珀,花椒,花蕊石,华山参,滑石,化橘红,槐花,槐角,黄柏,黄狗肾,鹅不食草,阿胶,阿胶珠莪术,儿茶,番红花,翻白草,防风,防己,榧子,枫香脂,粉萆薢,蜂房,蜂蜡,蜂蜜,佛手,茯苓,茯苓皮,茯神,浮萍,浮小麦,附子,覆盆子,法半夏,番泻叶,干漆,甘草,甘松,甘遂,高良姜,藁本,葛根,葛花,蛤蚧,蛤壳,隔山消,功劳木,钩藤,狗脊,枸骨叶,枸杞子,谷精草,谷芽,骨碎补,瓜蒂,瓜蒌,瓜蒌皮,瓜蒌子,关白附,关木通,贯众,广防己,广藿香,广金钱草,广木香,广枣,龟板,桂枝,干姜,干地黄,海金沙藤,海浮石,海蛤壳,海狗肾,海龙,海马,海螵蛸,海藻,海桐皮,寒水石,诃子,合欢花,合欢皮,何首乌,核桃仁,荷梗,荷叶,鹤草芽,鹤虱,黑芝麻,红豆蔻,红花,红景天,红芽大戟,红参,红大戟,厚朴,厚朴花,胡黄连,胡椒,葫芦巴,胡荽,红颓子叶,葫芦,虎杖,琥珀,花椒,花蕊石,华山参,滑石,化橘红,槐花,槐角,黄柏,黄狗肾";
        //默认彩虹屁
        Random random = new Random();

        int i = random.nextInt(404-0+1)+0;
        String str = all.split(",")[i];

        try {
            JSONObject jsonObject = JSONObject.parseObject(HttpUtil.getUrl(zhongyao + key + "&word=" + str));
            if (jsonObject.getIntValue("code") == 200) {
                str = jsonObject.getJSONObject("result").getString("content");
                str = str + "草药名:" + jsonObject.getJSONObject("result").getString("title");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getSayLove() {
        //默认彩虹屁
        String str = "生蚝掉进泥土里，这就叫做蚝喜欢泥！";
        try {
            JSONObject jsonObject = JSONObject.parseObject(HttpUtil.getUrl(tuwei + key));
            if (jsonObject.getIntValue("code") == 200) {
                str = jsonObject.getJSONObject("result").getString("content");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 载入金句库
     */
    static {
        InputStream inputStream = CaiHongPi.class.getClassLoader().getResourceAsStream("jinju.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String str = "";
            String temp = "";
            while ((temp = br.readLine()) != null) {
                if (!StringUtils.isEmpty(temp)) {
                    str = str + "\r\n" + temp;
                } else {
                    jinJuList.add(str);
                    str = "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJinJu() {
        Random random = new Random();
        return jinJuList.get(random.nextInt(jinJuList.size()));
    }

    public static void main(String[] args) {
        System.out.println(getJinJu());
        System.out.println(getCaiHongPi());
        System.out.println(getJingDianTaiCi());
    }
}
