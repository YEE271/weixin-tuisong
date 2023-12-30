package ydzhao.weixin.tuisong.controller;

/**
 *@ClassName PushController
 *@Description TODO
 *@Author ydzhao
 *@Date 2022/8/2 15:48
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ydzhao.weixin.tuisong.util.Pusher;

import static ydzhao.weixin.tuisong.common.ValCommons.*;

@RestController
public class PushController {

    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/bxl")
    public void pushBxl() throws Exception {

        Pusher.push(bxl,bxlTemplate);
    }
    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/slt")
    public void pushSlt() throws Exception {

        Pusher.push(slt,sltTemplate);
    }

    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/{id}")
    public void pushId(@PathVariable("id") String id) throws Exception {
        Pusher.push(id);
    }
}