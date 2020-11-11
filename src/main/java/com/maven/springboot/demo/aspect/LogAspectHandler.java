package com.maven.springboot.demo.aspect;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 处理  打印日志的 切面处理
 */

 @Aspect  //`@Aspect` 注解用来描述一个切面类
 @Component    //`@Component` 注解让该类交给 Spring 来管理
public class LogAspectHandler {

    private static final Logger logger = LoggerFactory.getLogger(LogAspectHandler.class);

    /**
     * .@Pointcut：定义一个切面，即上面所描述的关注的某件事入口。  主要两种表达方式：一个是使用 `execution()`，另一个是使用 `annotation()`
2.@Before：在做某件事之前做的事。  
3.@After：在做某件事之后做的事。  
4.@AfterReturning：在做某件事之后，对其返回值做增强处理。  
5.@AfterThrowing：在做某件事抛出异常时，处理。
     */


     
      //`@Pointcut` 注解指定一个切面
    @Pointcut("execution(* com.maven.springboot.demo.control..*.*(..))")
    public void pointCut(){

         logger.info("========执行==pointCut()============");

     }


      //  `annotation()` 方式是针对某个注解来定义切面，比如我们对具有`@GetMapping`注解的方法做切面，
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void annotationCut() {
        logger.info("========执行==annotationCut()============");
    }




     /**
      * 
      * 
      * `execution(* com.itcodai.course09.controller..*.*(..)))` 表达式为例，语法如下
      `execution()` 为表达式主体  
第一个 `*` 号的位置：表示返回值类型，`*` 表示所有类型  
包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，`com.itcodai.course09.controller` 包、子包下所有类的方法  
第二个 `*` 号的位置：表示类名，`*` 表示所有类  
`*(..)` ：这个星号表示方法名，`*` 表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
      */


    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("==========doBefore====");
        //获取签名
        Signature signature = joinPoint.getSignature();
        //获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        //获取即将执行的方法名
        String funName = signature.getName();
        logger.info("即将执行的方法{},属于包名{}",funName,declaringTypeName);



        //记录一些请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取请求url
        String url = request.getRequestURL().toString();
        //获取请求ip
        String ip = request.getRemoteAddr();
        logger.info("=======================请求地址url:{},请求ip:{}",url,ip);

    }  

    
    @Before("annotationCut()")
    public void doBeforeAnnotation(JoinPoint joinPoint){
        logger.info("==========doBefore==doBeforeAnnotation==");
        //获取签名
        Signature signature = joinPoint.getSignature();
        //获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        //获取即将执行的方法名
        String funName = signature.getName();
        logger.info("即将执行的方法{},属于包名{}",funName,declaringTypeName);



        //记录一些请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取请求url
        String url = request.getRequestURL().toString();
        //获取请求ip
        String ip = request.getRemoteAddr();
        logger.info("=======================请求地址url:{},请求ip:{}",url,ip);

    }  



    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
        logger.info("===================annotationCut()---> doAfter()=");
        //获取签名
        Signature signature = joinPoint.getSignature();
        //获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        //获取即将执行的方法名
        String funName = signature.getName();
        logger.info("即将执行的方法{},属于包名{}",funName,declaringTypeName);


         //记录一些请求信息
         ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
         HttpServletResponse response = attributes.getResponse();
         logger.info("=======================响应数据:{},响应状态:{}",response.getHeaderNames(),response.getStatus());

    }

 


    @After("annotationCut()")
    public void doAfterAnnotation(JoinPoint jsonPointer){
        logger.info("===================annotation()---> doAfterAnnotation()=");
             //记录一些请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        logger.info("=======================响应数据:{},响应状态:{}",response.getHeaderNames(),response.getStatus());
    }


    //返回结果处理
    /**
     * 
     * @param jPoint
     * @param result
     * 
     * 注意：  返回值的 名称 要和方法名称保持一致
     */
    @AfterReturning(pointcut = "annotationCut()",returning = "result")
    public void doAfterReturn(JoinPoint jPoint,Object result){
        logger.info("返回数据为{}",result+"增强版");

    }


    //异常拦截
    @AfterThrowing(pointcut = "pointCut()",throwing = "ex")
    public void doHandlerEexception(JoinPoint jPoint,Throwable ex){
        //TODO 

        logger.warn("aop=================发现异常错误{}===", ex.getMessage());

    }





    
}