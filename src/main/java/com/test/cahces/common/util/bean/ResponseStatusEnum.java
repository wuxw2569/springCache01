package com.test.cahces.common.util.bean;

/**
 * 活动类型\上下架枚举
 * 
 * @author dmw
 *
 */
public enum ResponseStatusEnum {

	OK(200, "请求处理成功"), 
	ERROR(500, "请求处理失败，请稍后再试"), 
	NOTALLOWED(405, "无权限访问"),
	UNAUTHORIZED(401,"无法获取用户状态信息"), 
	BADREQUEST(400, "参数语法错误"),
	NOTSERVICE(404, "资源不存在");

	private Integer value;

	private String name;

	// 构造函数定义每个枚举的构造方式，枚举类型构造方法只能为私有
	private ResponseStatusEnum(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	public Integer getValue() {
		return this.value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}

	public static String getMsg(int code) {
		String msg = "";
		switch (code)

		{
		case 500:
			msg = "请求处理失败，请稍后再试";
			break;
		case 200:
			msg = "请求处理成功";
			break;
		case 405:
			msg = "无权限访问";
			break;
		case 401:
			msg = "无法获取用户状态信息";
			break;
		case 400:
			msg = "参数语法错误";
			break;
		case 404:
			msg = "资源不存在";
			break;
		default:
			msg = "未知错误";
			break;
		}
		return msg;
	}
}
