package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.PayType;
import ekgc.witmed.service.DictionaryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("payTypeTransport")
@RequestMapping("/system/payType/transport")
public class PayTypeTransportImpl {
	@Resource(name = "payTypeService")
	private DictionaryService<PayType>  payTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<PayType> getPageListByQuery(@RequestBody PageQueryVO<PayType> queryVO) throws Exception{
		PayType query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return payTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<PayType> getListByQuery(@RequestBody PayType query) throws Exception{
		return payTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody PayType entity) throws Exception{
		return payTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody PayType entity) throws  Exception{
		return payTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public PayType getById(@RequestParam String id) throws Exception{
		return payTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public PayType getByCode(@RequestParam String code) throws Exception{
		return payTypeService.getByCode(code);
	}

}
