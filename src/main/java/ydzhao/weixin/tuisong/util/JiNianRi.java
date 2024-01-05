package ydzhao.weixin.tuisong.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;



/**
 * @ClassName JiNianRi
 * @Description TODO
 * @Author ydzhao
 * @Date 2022/8/2 17:32
 */
public class JiNianRi {
    /**
     * 恋爱
     */
    static String lianAi = "2022-05-21";

    /**
     * 生日
     */
    static String shengRi = "1998-11-21";

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 距离date还有多少天
     * @param date
     * @return
     */
    public static int before(String date) {
        int day = 0;
        try {

            LocalDate today = LocalDate.now();
            ZonedDateTime zonedDateTime = today.atStartOfDay(ZoneId.systemDefault());
            long timestamp = zonedDateTime.toInstant().toEpochMilli();
            long time =timestamp - simpleDateFormat.parse(date).getTime() ;
            day = (int) (time / 86400000L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    /**
     * 已经过去date多少天
     * @param date
     * @return
     */
    public static int after(String date) {
        int day = 0;
        try {
            LocalDate today = LocalDate.now();
            ZonedDateTime zonedDateTime = today.atStartOfDay(ZoneId.systemDefault());
            long timestamp = zonedDateTime.toInstant().toEpochMilli();
            long time = simpleDateFormat.parse(date).getTime()-timestamp  ;
//            long time = simpleDateFormat.parse(date).getTime()-1704124800000L  ;
            day = (int) (time / 86400000L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

//    public static int getJieHun() {
//        return before(jieHun);
//    }
//
//    public static int getLinZhen() {
//        return before(linZheng);
//    }

    public static int getLianAi() {
        return before(lianAi);
    }

    public static int getShengRi(){
        return after(shengRi);
    }

    public static int getNongLiShengRi() throws Exception {
        return after(CalendarUtil
                .getNextLunarDate("11-21", false));
    }

    public static void main(String[] args) throws Exception {

        System.out.println(getNongLiShengRi());
        System.out.println(getLianAi());

    }


}
