package ydzhao.weixin.tuisong.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ydzhao.weixin.tuisong.util.Pusher;

import static ydzhao.weixin.tuisong.common.ValCommons.*;

/**
 *@ClassName JobWorker
 *@Description TODO
 *@Author ydzhao
 *@Date 2022/8/2 16:00
 */
@Component
public class JobWorker {

//每隔五秒运行一次，测试使用。
//    @Scheduled(cron = "*/5 * * * * ?")
    @Scheduled(cron = "0 40 6 * * ?")
    public void goodMorning() throws Exception {
        Pusher.push(bxl,bxlTemplate);
        Pusher.push(slt,sltTemplate);
    }

}
