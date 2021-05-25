package ekgc.witmed.transport.cascade.impl;

import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.pojo.system.cascade.entity.Division;
import ekgc.witmed.service.DivisionService;
import ekgc.witmed.transport.cascade.DivisionTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("divisionTransportImpl")
@RequestMapping("/system/transport/division")
public class DivisionTransportImpl implements DivisionTransport {
	@Autowired
	private DivisionService service;

	@Override
	@PostMapping("/page")
	public PageVO<Division> getPageListByQuery(@RequestBody PageQueryVO<Division> pageQueryVO) throws Exception{
		PageVO<Division> pageVO = pageQueryVO.getPageVO();
		Division division = pageQueryVO.getQuery();
		return service.getPageListByQuery(pageVO, division);
	}
}
