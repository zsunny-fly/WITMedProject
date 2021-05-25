package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.PhoneType;
import ekgc.witmed.service.DictionaryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("phoneTypeTransport")
@RequestMapping("/system/phoneType/transport")
public class PhoneTypeTransportImpl {
	@Resource(name = "phoneTypeService")
	private DictionaryService<PhoneType> phoneTypeService;


	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<PhoneType> getPageListByQuery(@RequestBody PageQueryVO<PhoneType> queryVO) throws Exception{
		PhoneType query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return phoneTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<PhoneType> getListByQuery(@RequestBody PhoneType query) throws Exception{
		return phoneTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody PhoneType entity) throws Exception{
		return phoneTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody PhoneType entity) throws  Exception{
		return phoneTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public PhoneType getById(@RequestParam String id) throws Exception{
		return phoneTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public PhoneType getByCode(@RequestParam String code) throws Exception{
		return phoneTypeService.getByCode(code);
	}
}
