package com.fhr.musicstorerest.component;
/**
 * 错误消息实体
 * @author fhr
 * @date 2017/05/03
 */
public class Error {
	//错误消息编码
	private int code;
	//消息主题
	private String message;
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
	public Error(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
}
