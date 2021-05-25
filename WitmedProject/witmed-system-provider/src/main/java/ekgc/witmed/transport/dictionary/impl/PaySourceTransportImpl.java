package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.PaySource;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.PaySourceTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("paySourceTransport")
@RequestMapping("/system/paySource/transport")
public class PaySourceTransportImpl implements PaySourceTransport {

	@Autowired
	private DictionaryService<PaySource> priceTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<PaySource> getPageListByQuery(@RequestBody PageQueryVO<PaySource> queryVO) throws Exception{
		PaySource query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return priceTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<PaySource> getListByQuery(@RequestBody PaySource query) throws Exception{
		return priceTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody PaySource entity) throws Exception{
		return priceTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody PaySource entity) throws  Exception{
		return priceTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public PaySource getById(@RequestParam String id) throws Exception{
		return priceTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public PaySource getByCode(@RequestParam String code) throws Exception{
		return priceTypeService.getByCode(code);
	}
}
