package ekgc.witmed.pojo.system.dictionary.entity;

import ekgc.witmed.base.pojo.entity.BaseEntity;

/**
 * 智慧医疗-系统功能-字典表 统一实体类
 */
public class DictionaryEntity extends BaseEntity {
	private static final long serialVersionUID = 1281160392538467077L;
	private String id;              // 主键
	private String text;            // 文本名称
	private String code;            // 编码

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
}
