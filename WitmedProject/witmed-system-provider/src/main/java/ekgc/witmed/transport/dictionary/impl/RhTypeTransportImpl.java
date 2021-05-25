package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.RhType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.RhTypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("rhTypeTransport")
@RequestMapping("/system/rhType/transport")
public class RhTypeTransportImpl implements RhTypeTransport {
	@Autowired
	private DictionaryService<RhType> rhTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<RhType> getPageListByQuery(@RequestBody PageQueryVO<RhType> queryVO) throws Exception{
		RhType query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return rhTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<RhType> getListByQuery(@RequestBody RhType query) throws Exception{
		return rhTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody RhType entity) throws Exception{
		return rhTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody RhType entity) throws  Exception{
		return rhTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public RhType getById(@RequestParam String id) throws Exception{
		return rhTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public RhType getByCode(@RequestParam String code) throws Exception{
		return rhTypeService.getByCode(code);
	}

}
