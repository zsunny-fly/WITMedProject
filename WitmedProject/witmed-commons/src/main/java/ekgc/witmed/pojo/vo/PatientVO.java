package ekgc.witmed.pojo.vo;

import java.io.Serializable;

public class PatientVO implements Serializable {
	private static final long serialVersionUID = -5700144068210807102L;

	private String name;            // 姓名
	private String cellphone;       // 手机号码
	private String code;            // 验证码
	private String password;        // 密码


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
