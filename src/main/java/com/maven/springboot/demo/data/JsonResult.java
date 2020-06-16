package com.maven.springboot.demo.data;


public class JsonResult<T>{

    private T data;
    private int code;
    private String msg;


    /**
     * 如果没有数据返回，则默认返回信息
     */
    public JsonResult(){
        this.code = 0;
        this.msg = "操作成功";
    }

       /**
     * 如果没有数据返回，可以人为指定返回码和信息
     */
    public JsonResult(int code,String msg){
        this.code = code;
        this.msg = msg;
    }



    /**
     * 有数据则返回数据
     */
    public JsonResult(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

     /**
     * 有数据则返回数据
     */
    public JsonResult(T data){
        this.code = 0;
        this.msg = "操作成功";
        this.data = data;
    }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
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