package ekgc.witmed.base.pojo.enums;

public enum DegreeEnum {
	DEGREE_MILD("1","轻度"),
	DEGREE_MEDIUM("2","中度"),
	DEGREE_SERIOUS("3","重度")
	;
	private String  code;
	private String remark;
	private DegreeEnum(String code, String remark) {
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
