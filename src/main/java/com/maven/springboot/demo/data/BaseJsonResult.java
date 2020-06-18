package com.maven.springboot.demo.data;


/**
 * 无数据返回模板
 */
public class BaseJsonResult{

    protected int code;
    protected String msg;


    /**
     * 如果没有数据返回，则默认返回信息
     */
    public BaseJsonResult(){
        this.code = 0;
        this.msg = "操作成功";
    }

       /**
     * 如果没有数据返回，可以人为指定返回码和信息
     */
    public BaseJsonResult(int code,String msg){
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