package ekgc.witmed.base.pojo.enums;

public enum GenderEnum {
	GENDER_MALE("1","男性"),GENDER_FEMALE("2","女性")
	;
	private String code;        // 性别编码
	private String remark;      // 说明

	private GenderEnum(String code, String remark) {
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
