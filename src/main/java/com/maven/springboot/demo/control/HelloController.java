package com.maven.springboot.demo.control;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;
import com.maven.springboot.demo.data.Greeting;
import com.maven.springboot.demo.config.ApplicationValues;
import com.maven.springboot.demo.data.JsonResult;
import com.maven.springboot.demo.data.User;
import com.maven.springboot.demo.server.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    //标记 @value  可以获取applicaiton.yml中的配置信息
    @Value("${url.masterUrl}")
    private String  orderUrl;
    
    @Resource
    private TestService testService;
    @Resource
    private ApplicationValues applicationValues;

    @RequestMapping("/hello")
    public String hello(){
        return "say hello world";
    }


    /**
     * 携带参数的 请求
     * @param id
     * @return
     */
    @RequestMapping(path = "/delete", method = {RequestMethod.GET, RequestMethod.POST},produces = "application/json; charset=UTF-8") 
    public String delete(@RequestParam("id") String id) {
        return "Hello from delete";
    }

    /**
     * 携带默认参数值
     * @param name
     * 如：http://localhost:8080/demo/greeting?name=xyz
     * @return 返回一个  默认对象 对外输出 为json 格式
     */
    @GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    /**
     * 
     *如果携带的参数 比较多 ，这时候  我们可以定义一个类来作为参数  比如提交一个用户form表单
     *  使用实体类  接受参数 不用加  @RequestParam 注解了
     */
    @RequestMapping("/submit")
    public User submitUserInfo(User user){
        return user;
    }



    /**
     * 以上说的都是 携带参数 ，下面是提交表单  在body里提交 
     * 这时候  需要 @RequestBody 来接收
     */

     @RequestMapping("/submit/body")
     public User submitUserInfoFromBody(@RequestBody User user){
         return user;

     }



      /**
       * restful Api  格式，获取携带参数
       * greeing
     * 携带默认参数值
     * 如：http://localhost:8080/demo/user/wide_animals/3
     *
     */
    @GetMapping("/user/{type}/{id}")
	public Greeting greeting1(@PathVariable String type,@PathVariable int id) {

		return new Greeting(counter.incrementAndGet(), String.format(template, String.format("type 为：%s id为：%d的用户", type,id)));
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
     * 使用config  和bean配置,可以使得 bean 和 对应的已配置的config 在spring 容器中，提供对外服务
     */

     @GetMapping(path = "test/server")
     public String getTestService(@RequestParam(value = "name",defaultValue = "dyc",required = false) String name){

        return testService.say(name);
     }


     /**
      * 使用 slf4j 日志，其他详细使用 可以在 application.yml 中配置 日志使用方式
      */
     @GetMapping("/printlog")
     public void printLog(){
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息
        String str1 = "blog.itcodai.com";
        String str2 = "blog.csdn.net/eson_15";
        logger.info("======倪升武的个人博客：{}；倪升武的CSDN博客：{}", str1, str2);
     }



     /**
      *获取application.yml 单个value值方式  ，直接注解@Value()
      * @return
      */
     @GetMapping("/application/url")
     public String userApplicationValue(){
       return String.format("获取applicaiton.yml中的配置订单地址：%s", orderUrl);
     }


      /**
      *获取application.yml 多个值  我们可以定义一个 类专门来管理
      * @return
      */
      @GetMapping("/application/urls")
      public Map<String,String> userApplicationValues(){
          Map<String,String> maps = new HashMap<>();
          maps.put("masterUrl", applicationValues.getMasterUrl());
          maps.put("userUrl", applicationValues.getUserUrl());
          maps.put("shopUrl", applicationValues.getShopUrl());
          maps.put("orderUrl", applicationValues.getOrderUrl());
        return maps;
      }



}