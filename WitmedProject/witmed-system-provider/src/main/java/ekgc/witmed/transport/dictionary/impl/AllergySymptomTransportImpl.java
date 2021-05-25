package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.AllergySymptom;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.AllergySymptomTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("AllergySymptomTransport")
@RequestMapping("/system/allergySymptom/transport")
public class AllergySymptomTransportImpl implements AllergySymptomTransport {
	@Resource(name = "allergySymptomService")
	private DictionaryService<AllergySymptom> allergySymptomService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<AllergySymptom> getPageListByQuery(@RequestBody PageQueryVO<AllergySymptom> queryVO) throws Exception{
		AllergySymptom query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return allergySymptomService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<AllergySymptom> getListByQuery(@RequestBody AllergySymptom query) throws Exception{
		return allergySymptomService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody AllergySymptom entity) throws Exception{
		return allergySymptomService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody AllergySymptom entity) throws  Exception{
		return allergySymptomService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public AllergySymptom getById(@RequestParam String id) throws Exception{
		return allergySymptomService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public AllergySymptom getByCode(@RequestParam String code) throws Exception{
		return allergySymptomService.getByCode(code);
	}

}

