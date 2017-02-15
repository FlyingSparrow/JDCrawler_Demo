package com.sparrow.base.controller;

import com.sparrow.framework.beans.AjaxResult;

/**
 * 
 * <p>Title: BaseController</p>
 * <p>Description: 提供公共接口方法的基础控制器类</p>
 * @author wjc
 * @date 2017年1月5日
 */
public abstract class BaseController {

	protected AjaxResult success(Object data){
		return AjaxResult.success(data);
	}
	
	protected AjaxResult fail(String message){
		return AjaxResult.fail(message);
	}
	
	protected AjaxResult fail(int status, String message){
		return AjaxResult.fail(status, message);
	}
	
}
