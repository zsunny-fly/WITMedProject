package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.Country;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.CountryTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("countryTransport")
@RequestMapping("/system/country/transport")
public class CountryTransportImpl implements CountryTransport {
	@Resource(name = "countryService")
	private DictionaryService<Country> countryService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<Country> getPageListByQuery(@RequestBody PageQueryVO<Country> queryVO) throws Exception{
		Country query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return countryService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<Country> getListByQuery(@RequestBody Country query) throws Exception{
		return countryService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody Country entity) throws Exception{
		return countryService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody Country entity) throws  Exception{
		return countryService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public Country getById(@RequestParam String id) throws Exception{
		return countryService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public Country getByCode(@RequestParam String code) throws Exception{
		return countryService.getByCode(code);
	}

}

