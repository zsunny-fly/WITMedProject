package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.NameType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.NameTypeTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("nameTypeTransport")
@RequestMapping("/system/nameType/transport")
public class NameTypeTransportImpl implements NameTypeTransport {

	@Resource(name = "nameTypeService")
	private DictionaryService<NameType> nameTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<NameType> getPageListByQuery(@RequestBody PageQueryVO<NameType> queryVO) throws Exception{
		NameType query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return nameTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<NameType> getListByQuery(@RequestBody NameType query) throws Exception{
		return nameTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody NameType entity) throws Exception{
		return nameTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody NameType entity) throws  Exception{
		return nameTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public NameType getById(@RequestParam String id) throws Exception{
		return nameTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public NameType getByCode(@RequestParam String code) throws Exception{
		return nameTypeService.getByCode(code);
	}

}
