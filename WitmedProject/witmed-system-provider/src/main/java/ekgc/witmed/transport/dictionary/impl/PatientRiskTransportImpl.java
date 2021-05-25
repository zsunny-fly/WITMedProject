package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.PatientRisk;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.PatientRiskTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("PatientRiskTransport")
@RequestMapping("/system/patientRisk/transport")
public class PatientRiskTransportImpl implements PatientRiskTransport {
	@Resource(name = "patientRiskService")
	private DictionaryService<PatientRisk> patientRiskService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<PatientRisk> getPageListByQuery(@RequestBody PageQueryVO<PatientRisk> queryVO) throws Exception{
		PatientRisk query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return patientRiskService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<PatientRisk> getListByQuery(@RequestBody PatientRisk query) throws Exception{
		return patientRiskService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody PatientRisk entity) throws Exception{
		return patientRiskService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody PatientRisk entity) throws  Exception{
		return patientRiskService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public PatientRisk getById(@RequestParam String id) throws Exception{
		return patientRiskService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public PatientRisk getByCode(@RequestParam String code) throws Exception{
		return patientRiskService.getByCode(code);
	}

}

