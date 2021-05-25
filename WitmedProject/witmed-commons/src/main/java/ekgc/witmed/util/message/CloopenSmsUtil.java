package ekgc.witmed.util.message;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import ekgc.witmed.pojo.vo.RedisVO;
import ekgc.witmed.util.ConstantUtil;

import java.util.HashMap;

public class CloopenSmsUtil {

	public static boolean sendValidationSms(RedisVO redisVO){
		HashMap<String, Object> result = null;
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		restAPI.init(ConstantUtil.CLOOPEN_SERVER_URL, ConstantUtil.CLOOPEN_SERVER_PORT);
		// 初始化服务器地址和端口，生产环境配置成app.cloopen.com，端口是8883.
		restAPI.setAccount(ConstantUtil.CLOOPEN_ACCOUNT_ID, ConstantUtil.CLOOPEN_ACCOUNT_TOKEN);
		// 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在控制首页中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
		restAPI.setAppId(ConstantUtil.CLOOPEN_API_ID);
		// 请使用管理控制台中已创建应用的APPID。
		// 为了以防万一，将 cellphone 所代表的的参数用常量控制
		result = restAPI.sendTemplateSMS("15114832864",ConstantUtil.CLOOPEN_TEMPLATE_ID,
				new String[]{redisVO.getValue(),String.valueOf(Integer.valueOf(ConstantUtil.CLOOPEN_REDIS_VALIDATE_EXPIRE))});
		// result 为发送短信验证码申请后返回的信息。
		System.out.println("SDKTestGetSubAccounts result=" + result);
		if("000000".equals(result.get("statusCode"))){
			// 此时短信验证码发送正常，
			return true;
			//正常返回，输出data包体信息（map）
//			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
//			Set<String> keySet = data.keySet();
//			for(String key:keySet){
//				Object object = data.get(key);
//				System.out.println(key +" = "+object);
//			}
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
			return  false;
		}
	}

}
