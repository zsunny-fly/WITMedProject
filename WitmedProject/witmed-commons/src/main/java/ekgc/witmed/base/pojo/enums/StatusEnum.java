package ekgc.witmed.base.pojo.enums;

public enum StatusEnum {
	STATUS_ENABLE_CODE(EnumConstants.STATUS_ENABLE,"启用"),
	STATUS_DISABLE_CODE(EnumConstants.STATUS_DISABLE,"禁用")
	;
	private String code;        // 状态码
	private String remark;      // 说明

	private StatusEnum(String code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
