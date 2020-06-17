package com.maven.springboot.demo.control;

import com.maven.springboot.demo.config.BusinessException;
import com.maven.springboot.demo.data.JsonResult;
import com.maven.springboot.demo.data.User;
import com.maven.springboot.demo.exception.ExceptionMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常测试
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {


    private static final Logger  logger  = LoggerFactory.getLogger(ExceptionController.class);


    /**
     * 模拟 缺少参数 
     * @param name
     * @param pass
     * @return
     */
    @PostMapping("/test")
    public JsonResult<User> test(@RequestParam(value = "name") String name,@RequestParam(value = "pass") String pass){
        logger.info("name :{}", name);
        logger.info("pass :{}", pass);
        return new JsonResult<>(new User(name));
    }

      /**
     * 模拟 空指针
     * @return
     */
    @PostMapping("/null/point")
    public JsonResult<User> nullPoint(){
       String ss = null;
       ss.length();
        return new JsonResult<>(new User());
    }


    /**
     * 捕获自定义异常 
     */
    @PostMapping("/catch/exception")
    public JsonResult<User> catchException(){
      try {
           double  dd  = 1 / 0;
       } catch (Exception e) {
          throw new BusinessException(ExceptionMsg.ORDER_ID_NOT_EXIST);
       }
        return new JsonResult<>(new User());
    }


   

  
    
}