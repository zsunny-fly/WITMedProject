package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.MedicineType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.MedicineTypeTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("medicineTypeTransport")
@RequestMapping("/system/medicineType/transport")
public class MedicineTypeTransportImpl implements MedicineTypeTransport {
	@Resource(name = "medicineTypeService")
	private DictionaryService<MedicineType> medicineTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<MedicineType> getPageListByQuery(@RequestBody PageQueryVO<MedicineType> queryVO) throws Exception{
		MedicineType query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return medicineTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<MedicineType> getListByQuery(@RequestBody MedicineType query) throws Exception{
		return medicineTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody MedicineType entity) throws Exception{
		return medicineTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody MedicineType entity) throws  Exception{
		return medicineTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public MedicineType getById(@RequestParam String id) throws Exception{
		return medicineTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public MedicineType getByCode(@RequestParam String code) throws Exception{
		return medicineTypeService.getByCode(code);
	}

}
