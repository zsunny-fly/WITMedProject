package ekgc.witmed.base.pojo.enums;

import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;

import java.util.Properties;

/**
 * 智慧医疗-- 枚举参数的常量类
 * 访问权限为默认，即只是包内可见
 */
class EnumConstants {
	private static Properties props = new Properties();
	static {
		try {
			props.load(EnumConstants.class.getClassLoader().getResourceAsStream("props/enums.properties"));
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 系统状态 status 参数
	 */
	static final String STATUS_DISABLE = props.getProperty("enum.status.disable");
	static final String STATUS_ENABLE = props.getProperty("enum.status.enable");

	/**
	 * 系统返回状态编码
	 */
	static final Integer RESPONSE_SUCCESS = Integer.parseInt(props.getProperty("enum.response.success"));
	static final Integer RESPONSE_ERROR = Integer.parseInt(props.getProperty("enum.response.error"));
	static final Integer RESPONSE_EXCEPTION = Integer.parseInt(props.getProperty("enum.response.exception")) ;
	static final Integer RESPONSE_UNAUTH = Integer.parseInt(props.getProperty("enum.response.unauth")) ;
}
