package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.AllergySource;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.AllergySourceTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("AllergySourceTransport")
@RequestMapping("/system/allergySource/transport")
public class AllergySourceTransportImpl implements AllergySourceTransport {
	@Resource(name = "allergySourceService")
	private DictionaryService<AllergySource> allergySourceService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<AllergySource> getPageListByQuery(@RequestBody PageQueryVO<AllergySource> queryVO) throws Exception{
		AllergySource query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return allergySourceService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<AllergySource> getListByQuery(@RequestBody AllergySource query) throws Exception{
		return allergySourceService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody AllergySource entity) throws Exception{
		return allergySourceService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody AllergySource entity) throws  Exception{
		return allergySourceService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public AllergySource getById(@RequestParam String id) throws Exception{
		return allergySourceService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public AllergySource getByCode(@RequestParam String code) throws Exception{
		return allergySourceService.getByCode(code);
	}

}

