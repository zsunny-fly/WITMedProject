package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.Nation;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.NationTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("NationTransport")
@RequestMapping("/system/nation/transport")
public class NationTransportImpl implements NationTransport {
	@Resource(name = "nationService")
	private DictionaryService<Nation> nationService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<Nation> getPageListByQuery(@RequestBody PageQueryVO<Nation> queryVO) throws Exception{
		Nation query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return nationService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<Nation> getListByQuery(@RequestBody Nation query) throws Exception{
		return nationService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody Nation entity) throws Exception{
		return nationService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody Nation entity) throws  Exception{
		return nationService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public Nation getById(@RequestParam String id) throws Exception{
		return nationService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public Nation getByCode(@RequestParam String code) throws Exception{
		return nationService.getByCode(code);
	}

}

