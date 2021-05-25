package ekgc.witmed.pojo.vo;

import ekgc.witmed.base.pojo.vo.BaseVO;

public class CascadeVO<E> extends BaseVO {
	private static final long serialVersionUID = 3662545565390925779L;
	private String id;                  // 主键
	private String text;                // 文本
	private String code;                // 编码
	private E parent;                   // 父级类型

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

	public E getParent() {
		return parent;
	}

	public void setParent(E parent) {
		this.parent = parent;
	}
}
