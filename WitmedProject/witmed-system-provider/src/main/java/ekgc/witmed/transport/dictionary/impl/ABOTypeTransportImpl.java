package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.ABOType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.ABOTypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("aboTypeTransport")
@RequestMapping("/system/aboType/transport")
public class ABOTypeTransportImpl implements ABOTypeTransport {
	@Autowired
	private DictionaryService<ABOType> aboTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<ABOType> getPageListByQuery(@RequestBody PageQueryVO<ABOType> queryVO) throws Exception{
		ABOType query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return aboTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<ABOType> getListByQuery(@RequestBody ABOType query) throws Exception{
		return aboTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody ABOType entity) throws Exception{
		return aboTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody ABOType entity) throws  Exception{
		return aboTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public ABOType getById(@RequestParam String id) throws Exception{
		return aboTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public ABOType getByCode(@RequestParam String code) throws Exception{
		return aboTypeService.getByCode(code);
	}

}
