package ekgc.witmed.pojo.vo;

import java.io.Serializable;

public class RegisterVO implements Serializable {
	private static final long serialVersionUID = -996563267437621302L;
	private String cellphone;           // 手机号码
	private String password;            // 密码
	private String code;                // 验证码

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
