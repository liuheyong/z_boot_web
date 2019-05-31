package com.boot.web.globalexceptionhandler;

import com.boot.commons.constants.Constants;
import com.boot.commons.response.Result;
import com.boot.web.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: LiuHeYong
 * @create: 2019-05-31
 * @description: GlobalExceptionHandler
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @date: 2019/5/31
     * @param: [request, e]
     * @return: org.springframework.web.servlet.ModelAndView
     * @description: exceptionErrorHandler
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionErrorHandler(HttpServletRequest request, Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(Constants.DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
     * @date: 2019/5/31
     * @param: [request, e]
     * @return: org.springframework.web.servlet.ModelAndView
     * @description: nullPointerExceptionErrorHandler
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Result myExceptionErrorHandler(HttpServletRequest request, Exception e) {
        Result result = new Result();
        result.setResultMessage(e.getMessage());
        result.setResultCode(Constants.RESULT_FAIL);
        result.setResultData("MyException");
        result.setUrl(request.getRequestURL().toString());
        return result;
    }

}
