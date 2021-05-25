package ekgc.witmed.util;


import java.util.Properties;

public class ConstantUtil {
	private static Properties props = new Properties();
	static {
		try {
			props.load(ConstantUtil.class.getClassLoader().getResourceAsStream("props/witmed.properties"));
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 分页查询参数
	 */
	public static final Integer PAGE_NUM = Integer.parseInt(props.getProperty("page.num"));
	public static final Integer PAGE_SIZE = Integer.parseInt(props.getProperty("page.size"));

	/**
	 * Redis 过期时间 参数信息
	 */
	public static final Long REDIS_EXPIRE_MILLIS = Long.parseLong(props.getProperty("redis.expire.millis"));

	/**
	 * Token 密钥 与 过期时间参数
	 */
	public static  final String  TOKEN_SECRET_KEY = props.getProperty("token.secret.key");
	public static final Long TOKEN_EXPIRE_MILLIS = Long.parseLong(props.getProperty("token.expire.millis"));

	/**
	 * 字符串的正则表达式
	 */
	public static final String  STRING_REGEX = props.getProperty("string.regex");

	/**
	 * 荣联云 短信验证 参数
	 */
	public static final String CLOOPEN_SERVER_URL = props.getProperty("cloopen.server.url");
	public static final String CLOOPEN_SERVER_PORT = props.getProperty("cloopen.server.port");
	public static final String CLOOPEN_ACCOUNT_ID = props.getProperty("cloopen.account.id");
	public static final String CLOOPEN_ACCOUNT_TOKEN = props.getProperty("cloopen.account.token");
	public static final String CLOOPEN_API_ID = props.getProperty("cloopen.api.id");
	public static final String CLOOPEN_TEMPLATE_ID = props.getProperty("cloopen.template.id");
	public static final String CLOOPEN_REDIS_VALIDATE_EXPIRE = props.getProperty("cloopen.redis.validate.expire.millis");
}
