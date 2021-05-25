package ekgc.witmed.pojo.patient.role.entity;

import ekgc.witmed.base.pojo.entity.BaseUser;

public class Patient extends BaseUser {
	private static final long serialVersionUID = -2449178911154448043L;

	private String name;            // 姓名

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
