package ekgc.witmed.util;

import java.util.Random;

/**
 * 生成验证码工具类
 */
public class VerificationCodeUtil {
	public  static String getVerificationCode() {
		StringBuilder builder = new StringBuilder();
		while (builder.length() < 4) {
			builder.append(new Random().nextInt(10));
		}
		return builder.toString();
	}
}
