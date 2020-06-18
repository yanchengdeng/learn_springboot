package com.maven.springboot.demo.config;

import com.maven.springboot.demo.exception.ExceptionMsg;

/**
 * 自定义业务异常
 */
public class BusinessException extends RuntimeException{

	/**
	 *
	 */
    private static final long serialVersionUID = 1L;
    

    private int code;
    private String message;
	
    
    public BusinessException(ExceptionMsg exception) {
        this.code = exception.getCode();
        this.message = exception.getMsg();
        
    }

    public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
    }

    



    
}