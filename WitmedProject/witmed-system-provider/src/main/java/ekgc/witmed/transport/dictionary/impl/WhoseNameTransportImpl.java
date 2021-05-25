package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.WhoseName;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.WhoseNameTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("WhoseNameTransport")
@RequestMapping("/system/whoseName/transport")
public class WhoseNameTransportImpl implements WhoseNameTransport {
	@Resource(name = "whoseNameService")
	private DictionaryService<WhoseName> whoseNameService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<WhoseName> getPageListByQuery(@RequestBody PageQueryVO<WhoseName> queryVO) throws Exception{
		WhoseName query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return whoseNameService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<WhoseName> getListByQuery(@RequestBody WhoseName query) throws Exception{
		return whoseNameService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody WhoseName entity) throws Exception{
		return whoseNameService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody WhoseName entity) throws  Exception{
		return whoseNameService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public WhoseName getById(@RequestParam String id) throws Exception{
		return whoseNameService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public WhoseName getByCode(@RequestParam String code) throws Exception{
		return whoseNameService.getByCode(code);
	}

}
