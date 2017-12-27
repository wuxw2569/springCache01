package com.test.cahces.common.util.bean;

import java.io.Serializable;

/**
 * JSON数据返回封装类
 * 
 * @author dmw
 * @since 通用/帮助类
 */
public class ResponseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String msg="";
	private Object data="";
	private Integer code = ResponseStatusEnum.OK.getValue();

	public ResponseBean() {
		super();
	}

	public ResponseBean(Integer code) {
		super();
		this.code = code;
		this.msg=ResponseStatusEnum.getMsg(code);
	}

	public ResponseBean(Integer code, String msg) {
		super();
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public boolean isSuccess(){
		if(this.getCode().equals(ResponseStatusEnum.OK.getValue())){
			return true;
		}
		return false;
	}
}