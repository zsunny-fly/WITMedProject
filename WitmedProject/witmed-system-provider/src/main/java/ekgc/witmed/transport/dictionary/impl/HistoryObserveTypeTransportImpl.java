package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.HistoryObserveType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.HistoryObserveTypeTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("HistoryObserveTypeTransport")
@RequestMapping("/system/HistoryObserveType/transport")
public class HistoryObserveTypeTransportImpl implements HistoryObserveTypeTransport {
	@Resource(name = "historyObserveTypeService")
	private DictionaryService<HistoryObserveType> historyObserveTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<HistoryObserveType> getPageListByQuery(@RequestBody PageQueryVO<HistoryObserveType> queryVO) throws Exception{
		HistoryObserveType query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return historyObserveTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<HistoryObserveType> getListByQuery(@RequestBody HistoryObserveType query) throws Exception{
		return historyObserveTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody HistoryObserveType entity) throws Exception{
		return historyObserveTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody HistoryObserveType entity) throws  Exception{
		return historyObserveTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public HistoryObserveType getById(@RequestParam String id) throws Exception{
		return historyObserveTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public HistoryObserveType getByCode(@RequestParam String code) throws Exception{
		return historyObserveTypeService.getByCode(code);
	}

}
