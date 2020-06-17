package com.maven.springboot.demo.exception;

/**
 * 自定义异常
 */
public enum ExceptionMsg{

    ORDER_ID_NOT_EXIST(100010,"订单不存在"),
    ORDER_HAS_EXPERID(100011,"订单已超时");



    private int code;
    private String msg;
	private ExceptionMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
    }
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
    
    




}