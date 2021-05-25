package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.PatientType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.PatientTypeTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("patientTypeTransport")
@RequestMapping("/system/patientType/transport")
public class PatientTypeTransportImpl implements PatientTypeTransport {
	@Resource(name = "patientTypeService")
	private DictionaryService<PatientType> patientTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<PatientType> getPageListByQuery(@RequestBody PageQueryVO<PatientType> queryVO) throws Exception{
		PatientType query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return patientTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<PatientType> getListByQuery(@RequestBody PatientType query) throws Exception{
		return patientTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody PatientType entity) throws Exception{
		return patientTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody PatientType entity) throws  Exception{
		return patientTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public PatientType getById(@RequestParam String id) throws Exception{
		return patientTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public PatientType getByCode(@RequestParam String code) throws Exception{
		return patientTypeService.getByCode(code);
	}

}

