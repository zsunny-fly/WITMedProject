package ekgc.witmed.base.pojo.entity;

public class BaseUser extends BaseEntity{
	private static final long serialVersionUID = 5314846067231751410L;
	private String id;                // 主键
	private String cellphone;         // 手机号码
	private String password;          // 密码

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
}
