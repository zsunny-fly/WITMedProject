package ekgc.witmed.util;

public class StringUtil {
	/**
	 * 判断手机号码是否为空
	 * @param str
	 * @return
	 */
	public static boolean isStringForm(String str) {
		if(str != null && !"".equals(str.trim())){
			return true;
		}
		return false;
	}

	public static boolean isCellphoneMatches(String cellphone){
		if(isStringForm(cellphone)){
			if(cellphone.matches(ConstantUtil.STRING_REGEX)){
				return true;
			}
		}
		return false;
	}

}
