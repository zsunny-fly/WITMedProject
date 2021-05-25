package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.AllergyState;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.AllergyStateTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("AllergyStateTransport")
@RequestMapping("/system/allergyState/transport")
public class AllergyStateTransportImpl implements AllergyStateTransport {
	@Resource(name = "allergyStateService")
	private DictionaryService<AllergyState> allergyStateService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<AllergyState> getPageListByQuery(@RequestBody PageQueryVO<AllergyState> queryVO) throws Exception{
		AllergyState query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return allergyStateService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<AllergyState> getListByQuery(@RequestBody AllergyState query) throws Exception{
		return allergyStateService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody AllergyState entity) throws Exception{
		return allergyStateService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody AllergyState entity) throws  Exception{
		return allergyStateService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public AllergyState getById(@RequestParam String id) throws Exception{
		return allergyStateService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public AllergyState getByCode(@RequestParam String code) throws Exception{
		return allergyStateService.getByCode(code);
	}

}

