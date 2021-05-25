package ekgc.witmed.pojo.vo;

import java.io.Serializable;

public class RedisVO implements Serializable {
	private static final long serialVersionUID = -4978010850085697857L;
	private String key;             // key值
	private String value;           // value值

	public RedisVO() {}

	public RedisVO(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
