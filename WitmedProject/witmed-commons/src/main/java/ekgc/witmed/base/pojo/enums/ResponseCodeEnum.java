package ekgc.witmed.base.pojo.enums;

public enum ResponseCodeEnum {
	RESPONSE_SUCCESS_CODE(EnumConstants.RESPONSE_SUCCESS,"响应成功"),
	RESPONSE_ERROR_CODE(EnumConstants.RESPONSE_ERROR,"系统业务处理错误"),
	RESPONSE_EXCEPTION_CODE(EnumConstants.RESPONSE_EXCEPTION,"系统抛出异常"),
	RESPONSE_UNAUTH_CODE(EnumConstants.RESPONSE_UNAUTH,"用户未认证")
	;
	private Integer code;                        // 系统响应编码
	private String remark;                       // 编码说明

	private ResponseCodeEnum(Integer code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
