package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.pojo.system.dictionary.entity.DictionaryEntity;
import ekgc.witmed.pojo.system.dictionary.entity.GenderType;
import ekgc.witmed.service.TemplateDicService;
import ekgc.witmed.transport.dictionary.GenderTypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("genderTypeTransport")
@RequestMapping("/system/genderType/transport")
public class GenderTypeTransportImpl implements GenderTypeTransport {
	@Autowired
	private TemplateDicService genderTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<DictionaryEntity> getPageListByQuery(@RequestBody PageQueryVO<DictionaryEntity> queryVO) throws Exception{
		DictionaryEntity query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return genderTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<DictionaryEntity> getListByQuery(@RequestBody DictionaryEntity query) throws Exception{
		return genderTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody DictionaryEntity entity) throws Exception{
		return genderTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody DictionaryEntity entity) throws  Exception{
		return genderTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public DictionaryEntity getById(@RequestParam String id) throws Exception{
		return genderTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public DictionaryEntity getByCode(@RequestParam String code) throws Exception{
		return genderTypeService.getByCode(code);
	}

}
