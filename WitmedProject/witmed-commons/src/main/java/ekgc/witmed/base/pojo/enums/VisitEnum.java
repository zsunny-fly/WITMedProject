package ekgc.witmed.base.pojo.enums;

public enum VisitEnum {
	VISIT_FIRST("1","初诊"),
	VISIT_AGAIN("2","复诊")
	;
	private String code;        // 性别编码
	private String remark;      // 说明

	private VisitEnum(String code, String remark) {
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
