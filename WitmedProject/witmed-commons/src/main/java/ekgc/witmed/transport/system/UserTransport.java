package ekgc.witmed.transport.system;

import ekgc.witmed.base.pojo.entity.BaseUser;
import ekgc.witmed.pojo.vo.RedisVO;
import ekgc.witmed.pojo.vo.RegisterVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "witmed-system-provider")
@RequestMapping("/user/transport")
public interface UserTransport {
	/**
	 * 通过手机号码获取用户
	 * @return
	 */
	@PostMapping("/cellphone")
	BaseUser getUserByCellphone(@RequestParam String cellphone) throws Exception;

	/**
	 * 将token保存到redis中
	 * @param redisVO
	 * @param expireTime
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/addToRedis")
	boolean addToRedis(@RequestBody RedisVO redisVO, @RequestParam Long expireTime) throws Exception;

	/**
	 *  根据key值取出对应的value值
	 * @param cellphone
	 * @return
	 */
	@PostMapping("/getFromRedis")
	String getFromRedis(@RequestParam String cellphone) throws Exception;

	/**
	 * 添加注册用户
	 * @param registerVO
	 * @return
	 */
	@PostMapping("/addUser")
	boolean addUser(@RequestBody RegisterVO registerVO) throws Exception;
}
