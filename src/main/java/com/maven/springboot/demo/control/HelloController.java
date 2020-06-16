package com.maven.springboot.demo.control;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;
import com.maven.springboot.demo.Greeting;
import com.maven.springboot.demo.data.JsonResult;
import com.maven.springboot.demo.server.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * @RequestMapping  可以全局控制url 路径
 * 如 ： http://localhost:8080/start/test/server?name=hahh
 * 
 */
// @RequestMapping("/start")
public class HelloController{
    private String template = "Hello, %s!  hot reload ";
    private AtomicLong counter = new AtomicLong();
    // 日志打印
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class.getName());
    
    @Resource
    private TestService testService;

    @RequestMapping("/hello")
    public String hello(){
        logger.warn("这是一段 slf4j的日志");
        return "say hello world";
    }


    /**
     * 携带参数的 请求
     * @param id
     * @return
     */
    @RequestMapping(path = "/delete", method = {RequestMethod.GET, RequestMethod.POST}) 
    public String delete(@RequestParam("id") String id) {
        return "Hello from delete";
    }

    /**
     * 携带默认参数值
     * @param name
     * @return 返回一个  默认对象 对外输出 为json 格式
     */
    @GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    
    /**
     * 携带默认参数值
     * @param name
     * @return 返回一个  默认对象 对外输出 为json 格式
     */
    @GetMapping("/greeting/list")
	public List<Greeting> greetingList(@RequestParam(value = "name", defaultValue = "World") String name) {
        List<Greeting> list = new LinkedList<>();
        list.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
        list.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
        list.add(new Greeting());
		return list;
    }


     /**
     * 携带默认参数值
     * @param name
     * @return 返回一个  默认对象 对外输出 为json 格式
     */
    @GetMapping("/greeting/list4fastjson")
	public JsonResult<List<Greeting>> greetingListFastJson(@RequestParam(value = "name", defaultValue = "World") String name) {
        List<Greeting> list = new LinkedList<>();
        list.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
        list.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
        list.add(new Greeting());
		return new JsonResult<>(list);
    }
    
    /**
     * 使用config  和bean配置
     */

     @GetMapping(path = "test/server")
     public String getTestService(@RequestParam(value = "name",defaultValue = "dyc",required = false) String name){

        return testService.say(name);
     }





}