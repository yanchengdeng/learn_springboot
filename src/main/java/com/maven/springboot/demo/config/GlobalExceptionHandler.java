package com.maven.springboot.demo.config;

import com.maven.springboot.demo.data.BaseJsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理
 */

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    
    /**
     * 缺省参数异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public BaseJsonResult handExceptionMissParamResult(MissingServletRequestParameterException exception){
        logger.error("缺少参数{}", exception.getMessage());
        return new BaseJsonResult(400, "缺省参数");

    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseJsonResult handNullPointException(NullPointerException exception){
        logger.error("空指针了{}", exception.getMessage());
        return new BaseJsonResult(500, "空指针了");

    }


     /**
     * 自定义异常（业务）
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseJsonResult handBusinessException(BusinessException exception){
        logger.error("自定义异常{}", exception.getMessage());
        return new BaseJsonResult(exception.getCode(), exception.getMessage());

    }




    
}