package ekgc.witmed.pojo.system.cascade.entity;

import ekgc.witmed.base.pojo.entity.BaseEntity;

public class CascadeEntity extends BaseEntity {
	private static final long serialVersionUID = -1311768583593824560L;
	private String id;                  // 主键
	private String text;                // 文本
	private String code;                // 编码
//	private CascadeEntity parent;                   // 父级类型
	private String parentCode;          // 上级编码
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
}
