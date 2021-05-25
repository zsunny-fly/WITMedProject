package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.MarryState;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.MarryStateTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("marryStateTransport")
@RequestMapping("/system/marryState/transport")
public class MarryStateTransportImpl implements MarryStateTransport {

	@Resource(name = "marryStateService")
	private DictionaryService<MarryState>  marryStateService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<MarryState> getPageListByQuery(@RequestBody PageQueryVO<MarryState> queryVO) throws Exception{
		MarryState query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return marryStateService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<MarryState> getListByQuery(@RequestBody MarryState query) throws Exception{
		return marryStateService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody MarryState entity) throws Exception{
		return marryStateService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody MarryState entity) throws  Exception{
		return marryStateService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public MarryState getById(@RequestParam String id) throws Exception{
		return marryStateService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public MarryState getByCode(@RequestParam String code) throws Exception{
		return marryStateService.getByCode(code);
	}


}
