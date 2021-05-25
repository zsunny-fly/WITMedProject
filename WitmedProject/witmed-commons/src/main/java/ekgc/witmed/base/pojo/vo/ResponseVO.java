package ekgc.witmed.base.pojo.vo;

import ekgc.witmed.base.pojo.enums.ResponseCodeEnum;

import java.io.Serializable;

public class ResponseVO<E> implements Serializable {
	private static final long serialVersionUID = 6230966324422227857L;
	private Integer code;               // 系统返回响应码
	private E  data;                    // 系统返回数据

	// 构造方法
	private ResponseVO(Integer code){
		this.code = code;
	}

	private ResponseVO(Integer code, E data) {
		this.code = code;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	/**
	 * 获得系统响应成功视图, 不返回数据
	 */
	public static ResponseVO getSuccessResponseVO(){
		return new  ResponseVO(ResponseCodeEnum.RESPONSE_SUCCESS_CODE.getCode());
	}
	/**
	 * 获得系统响应成功视图，并携带数据。方法重载
	 */
	public static ResponseVO getSuccessResponseVO(Object data){
		return new ResponseVO(ResponseCodeEnum.RESPONSE_SUCCESS_CODE.getCode(),data);
	}

	/**
	 * 获得系统业务处理错误视图，并将错误内容携带返回
	 */
	public static ResponseVO getErrorResponseVO(Object data){
		return new ResponseVO(ResponseCodeEnum.RESPONSE_ERROR_CODE.getCode(),data);
	}

	/**
	 * 获得 响应异常视图，并将携带的数据返回
	 */
	public static ResponseVO getExceptionResponseVO(Object data){
		return new ResponseVO(ResponseCodeEnum.RESPONSE_EXCEPTION_CODE.getCode(),data);
	}

	/**
	 * 获得 用户未认证 视图
	 */
	public static  ResponseVO getUnAuthResponseVO(){
		return new ResponseVO(ResponseCodeEnum.RESPONSE_UNAUTH_CODE.getCode());
	}



}
