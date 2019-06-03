package com.boot.web.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.boot.commons.constants.Constants;
import com.boot.commons.dto.ECooperateMer;
import com.boot.commons.response.Result;
import com.boot.commons.service.ECooperateMerService;
import com.boot.web.defaultcontroller.DefaultController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: LiuHeYong
 * @create: 2019-05-22
 * @description:
 **/
@RestController
public class ECooperateMerController extends DefaultController {

    @Reference(check = false, version = "1.0.0", timeout = 60000)
    ECooperateMerService eCooperateMerService;

    /**
     * @date: 2019/5/24
     * @param: [eCooperateMer]
     * @return: Result
     * @description: 详情
     */
    @RequestMapping(value = Constants.BOOT + "/queryECooperateMerInfo")
    public Result queryECooperateMerInfo(ECooperateMer eCooperateMer) {
        Result result = new Result();
        Map<String, Object> model = new HashMap<String, Object>(4);
        try {
            Optional<ECooperateMer> optDto = Optional.ofNullable(eCooperateMerService.queryECooperateMerInfo(eCooperateMer));
            if (optDto.isPresent()) {
                model.put("eCooperateMer", optDto.get());
                result.setResultData(model);
                result.setResultCode(Constants.RESULT_SUCCESS);
                return result;
            } else {
                throw new Exception("该eCooperateMer不存在");
            }
        } catch (Exception e) {
            logger.error("系统异常", e);
            result.setResultCode(Constants.RESULT_FAIL);
            result.setResultMessage("系统异常");
        }
        return result;
    }

    /**
     * @date: 2019/5/27
     * @param: [eCooperateMer]
     * @return: com.boot.commons.response.Result
     * @description: 创建线程查询列表
     */
    @RequestMapping(value = Constants.BOOT + "/queryECooperateMerListPage")
    public Result queryECooperateMerListPage(ECooperateMer eCooperateMer) {
        Result result = new Result();
        Map<String, Object> model = new HashMap<String, Object>(4);
        try {
            //创建线程执行任务
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        eCooperateMerService.queryECooperateMerListPage(eCooperateMer);
                    } catch (Exception e) {
                        logger.error("系统异常", e);
                        return;
                    }
                }
            };
            //创建线程池
            ExecutorService executorService = Executors.newFixedThreadPool(25);
            for (int i = 0; i < 100; i++) {
                executorService.submit(runnable);
            }
            List<ECooperateMer> list = eCooperateMerService.queryECooperateMerListPage(eCooperateMer);
            model.put("eCooperateMerList", list);
            result.setResultCode(Constants.RESULT_SUCCESS);
            result.setResultData(model);
        } catch (Exception e) {
            logger.error("系统异常", e);
            result.setResultCode(Constants.RESULT_FAIL);
            result.setResultMessage("系统异常");
        }
        return result;

    }

}
