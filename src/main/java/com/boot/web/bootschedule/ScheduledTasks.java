package com.boot.web.bootschedule;

import com.boot.web.defaultcontroller.DefaultController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: jack
 * @create: 2019-06-03
 * @description: boot定时器
 **/
@Component
public class ScheduledTasks {

    public static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @Date: 2019-06-03
     * @Description: 每隔30秒记录当前时间
     */
    @Scheduled(fixedRate = 30000)
    public void reportCurrentTime() {
        logger.info("Current Time：" + sdf.format(new Date()));
    }

}
