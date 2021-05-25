package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.ICDType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.ICDTypeTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("ICDTypeTransport")
@RequestMapping("/system/iCDType/transport")
public class ICDTypeTransportImpl implements ICDTypeTransport {
	@Resource(name = "iCDTypeService")
	private DictionaryService<ICDType> iCDTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<ICDType> getPageListByQuery(@RequestBody PageQueryVO<ICDType> queryVO) throws Exception{
		ICDType query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return iCDTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<ICDType> getListByQuery(@RequestBody ICDType query) throws Exception{
		return iCDTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody ICDType entity) throws Exception{
		return iCDTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody ICDType entity) throws  Exception{
		return iCDTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public ICDType getById(@RequestParam String id) throws Exception{
		return iCDTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public ICDType getByCode(@RequestParam String code) throws Exception{
		return iCDTypeService.getByCode(code);
	}

}

