package ekgc.witmed.transport.cascade;

import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.pojo.system.cascade.entity.Division;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "witmed-system-provider")
@RequestMapping("/system/transport/division")
public interface DivisionTransport {

	@PostMapping("/page")
	PageVO<Division> getPageListByQuery(@RequestBody PageQueryVO<Division> pageQueryVO)  throws Exception;
}
