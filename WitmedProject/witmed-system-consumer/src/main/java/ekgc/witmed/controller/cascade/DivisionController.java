package ekgc.witmed.controller.cascade;

import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.ResponseVO;
import ekgc.witmed.pojo.system.cascade.entity.Division;
import ekgc.witmed.transport.cascade.DivisionTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("divisionController")
@RequestMapping("/system/division")
public class DivisionController {
	@Autowired
	private DivisionTransport transport;

	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO getPageByQuery(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                                 @RequestBody Division division) throws Exception{
		PageVO<Division> pageVO = new PageVO<Division>(pageNum,pageSize);
		PageQueryVO<Division> pageQueryVO = new PageQueryVO<Division>(division,pageVO);
		pageVO = transport.getPageListByQuery(pageQueryVO);
		if(pageVO.getList() != null){
			return ResponseVO.getSuccessResponseVO(pageVO);
		}
		return ResponseVO.getErrorResponseVO("查询失败");

	}


}
