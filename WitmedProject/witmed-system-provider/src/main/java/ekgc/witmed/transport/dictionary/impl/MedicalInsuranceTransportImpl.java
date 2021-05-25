package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.MedicalInsurance;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.MedicalInsuranceTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("medicalInsuranceTransport")
@RequestMapping("/system/medicalInsurance/transport")
public class MedicalInsuranceTransportImpl implements MedicalInsuranceTransport {

	@Resource(name = "medicalInsuranceService")
	private DictionaryService<MedicalInsurance> medicalInsuranceService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<MedicalInsurance> getPageListByQuery(@RequestBody PageQueryVO<MedicalInsurance> queryVO) throws Exception{
		MedicalInsurance query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return medicalInsuranceService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<MedicalInsurance> getListByQuery(@RequestBody MedicalInsurance query) throws Exception{
		return medicalInsuranceService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody MedicalInsurance entity) throws Exception{
		return medicalInsuranceService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody MedicalInsurance entity) throws  Exception{
		return medicalInsuranceService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public MedicalInsurance getById(@RequestParam String id) throws Exception{
		return medicalInsuranceService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public MedicalInsurance getByCode(@RequestParam String code) throws Exception{
		return medicalInsuranceService.getByCode(code);
	}


}
