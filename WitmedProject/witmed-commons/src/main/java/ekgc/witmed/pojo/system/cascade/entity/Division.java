package ekgc.witmed.pojo.system.cascade.entity;

import ekgc.witmed.base.pojo.entity.BaseEntity;

public class Division extends BaseEntity {
	private static final long serialVersionUID = -8186339682760317268L;
	private String id;                  // 主键
	private String text;                // 文本
	private String code;                // 编码
	private Division parent;                   // 父级类型

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

	public Division getParent() {
		return parent;
	}

	public void setParent(Division parent) {
		this.parent = parent;
	}
}
