package com.maven.springboot.demo.control;

import com.maven.springboot.demo.data.JsonResult;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
     * 
     * @param name
     * @param pass
     * @return
     */
    @PostMapping("/test")
    public JsonResult test(@RequestParam(value = "name") String name,@RequestParam(value = "pass") String pass){
        logger.info("name :{}", name);
        logger.info("pass :{}", pass);
        return new JsonResult();
    }
    
}