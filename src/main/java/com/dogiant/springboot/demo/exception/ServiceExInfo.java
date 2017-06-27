package com.dogiant.springboot.demo.exception;

public enum ServiceExInfo implements ExceptionInfo {
	
	SUCCEED("1","Successful results"),
	NOT_LOGIN_EXCEPTION("2","Not logged in exception"),
	WECHAT_ALREADY_EXISTS("3","You wechat already exists"),
	NO_AUTH_EXCEPTION("4","No authorization exception"),
	PARAMETER_ERROR_EXCEPTION("5","Parameter error exception"),
	NO_SELECT_SWITCH_EXCEPTION("6","No select switch exception"),
	NOT_SWITCH_TO_YOUR_WECHAT_EXCEPTION("7","not switch to your WeChat"),
	EXCEL_FORMAT_IS_NOT_CORRECT_EXCEPTION("8","Excel format is not correct"),
	
	
	SYSTEM_ERROR("-1","System error"),
	NO_APPID_APPSECRET("-2","no registration appId or appScret"),
	GET_ACCESSTOKEN_ERROR("-3","get AccessToken return error"),
	USER_PASS_ERROR("-4", "username invalid or password error"),
	CREATE_MENU_ERROR("-100","create menu return error");
	

	private String code;
	private String message;

	private ServiceExInfo(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}


}
