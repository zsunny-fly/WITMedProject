package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.MedicalCheckType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.MedicalCheckTypeTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("medicalCheckTypeTransport")
@RequestMapping("/system/medicalCheckType/transport")
public class MedicalCheckTypeTransportImpl implements MedicalCheckTypeTransport {


	@Resource(name = "medicalCheckTypeService")
	private DictionaryService<MedicalCheckType> medicalCheckTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<MedicalCheckType> getPageListByQuery(@RequestBody PageQueryVO<MedicalCheckType> queryVO) throws Exception{
		MedicalCheckType query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return medicalCheckTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<MedicalCheckType> getListByQuery(@RequestBody MedicalCheckType query) throws Exception{
		return medicalCheckTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody MedicalCheckType entity) throws Exception{
		return medicalCheckTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody MedicalCheckType entity) throws  Exception{
		return medicalCheckTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public MedicalCheckType getById(@RequestParam String id) throws Exception{
		return medicalCheckTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public MedicalCheckType getByCode(@RequestParam String code) throws Exception{
		return medicalCheckTypeService.getByCode(code);
	}


}
