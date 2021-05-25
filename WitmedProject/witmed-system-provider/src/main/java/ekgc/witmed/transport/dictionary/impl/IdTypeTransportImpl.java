package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.IdType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.IdTypeTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 智慧医疗-系统功能-证件类型传输层接口实现了
 */
@RestController("idTypeTransport")
@RequestMapping("/system/idType/transport")
public class IdTypeTransportImpl implements IdTypeTransport {
	@Resource(name = "nameTypeService")
	private DictionaryService<IdType> nameTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<IdType> getPageListByQuery(@RequestBody PageQueryVO<IdType> queryVO) throws Exception{
		IdType query = queryVO.getQuery();
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
	public List<IdType> getListByQuery(@RequestBody IdType query) throws Exception{
		return nameTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody IdType entity) throws Exception{
		return nameTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody IdType entity) throws  Exception{
		return nameTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public IdType getById(@RequestParam String id) throws Exception{
		return nameTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public IdType getByCode(@RequestParam String code) throws Exception{
		return nameTypeService.getByCode(code);
	}

}
