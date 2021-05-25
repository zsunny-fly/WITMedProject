package ekgc.witmed.util;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@Component("redisUtil")
public class RedisUtil {
	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * 将数据存储的Redis中
	 * @param key
	 * @param data
	 * @param expireTime
	 * @throws Exception
	 */
	public void saveToRedis(String key, Object data, Long expireTime) throws Exception{
		// 创建 JsonMapper 对象
		JsonMapper jsonMapper = new JsonMapper();
		// 将参数中的对象数据变为 json 格式的字符串，并将其中的 " 变为 ',否则存入Redis时，
		// redis会将 " 用 \ 转义并保存
		String jsonStr = jsonMapper.writeValueAsString(data).replace("\"","'");
		// 将数据保存到 Redis中
		redisTemplate.opsForValue().set(key,jsonStr);
		// 设定存储到Redis中的数据有效时间
		if(expireTime != null && expireTime > 0){
			redisTemplate.expire(key, expireTime, TimeUnit.MILLISECONDS);
		} else{
			redisTemplate.expire(key, ConstantUtil.REDIS_EXPIRE_MILLIS,TimeUnit.MILLISECONDS);
		}

	}


	public Object findFromRedis(String key, Class objType) throws  Exception{
		// 根据 key 获取对应数据字符串
		String dataStr = redisTemplate.opsForValue().get(key).replace("'","\"");
		if(dataStr != null){
			// 使用 JsonMapper 对象，将字符串变为响应的对象信息
			JsonMapper jsonMapper = new JsonMapper();
			return jsonMapper.readValue(dataStr,objType);
		}
		return null;
	}

}
