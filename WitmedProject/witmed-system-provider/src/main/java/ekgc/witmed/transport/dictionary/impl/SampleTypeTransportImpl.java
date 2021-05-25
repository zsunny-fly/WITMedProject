package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.SampleType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.SampleTypeTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("SampleTypeTransport")
@RequestMapping("/system/sampleType/transport")
public class SampleTypeTransportImpl implements SampleTypeTransport {
	@Resource(name = "sampleTypeService")
	private DictionaryService<SampleType> sampleTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<SampleType> getPageListByQuery(@RequestBody PageQueryVO<SampleType> queryVO) throws Exception{
		SampleType query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return sampleTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<SampleType> getListByQuery(@RequestBody SampleType query) throws Exception{
		return sampleTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody SampleType entity) throws Exception{
		return sampleTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody SampleType entity) throws  Exception{
		return sampleTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public SampleType getById(@RequestParam String id) throws Exception{
		return sampleTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public SampleType getByCode(@RequestParam String code) throws Exception{
		return sampleTypeService.getByCode(code);
	}

}

