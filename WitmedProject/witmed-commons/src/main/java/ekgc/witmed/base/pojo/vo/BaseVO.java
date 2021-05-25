package ekgc.witmed.base.pojo.vo;

import java.io.Serializable;
import java.util.Date;

public class BaseVO implements Serializable {
	private static final long serialVersionUID = 8155096418995920142L;
	private String status;                    // 系统状态
	private String createUser;                // 创建人
	private Date createTime;                  // 创建时间
	private String updateUser;                // 创建人

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}
