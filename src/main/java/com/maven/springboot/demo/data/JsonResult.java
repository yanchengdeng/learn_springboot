package com.maven.springboot.demo.data;


/**
 * 业务数据模板
 */
public class JsonResult<T> extends BaseJsonResult{

    private T data;

    

      /**
     * 默认成功
     */
    public JsonResult(T data){
        this.code = 0;
        this.msg = "操作成功";
        this.data = data;
    }


    /**
     * 有数据则返回数据
     */
    public JsonResult(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

   

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


    
}