package ekgc.witmed.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.system.dictionary.dao.HistoryObserveTypeDao;
import ekgc.witmed.pojo.system.dictionary.entity.HistoryObserveType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("historyObserveTypeService")
public class HistoryObserveTypeServiceImpl extends IdService implements DictionaryService<HistoryObserveType> {

	@Autowired
	private HistoryObserveTypeDao historyObserveTypeDao;

	/**
	 *  分页查询
	 * @param query
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<HistoryObserveType> getPageListByQuery(HistoryObserveType query, PageVO<HistoryObserveType> pageVO) throws Exception {
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<HistoryObserveType> list = historyObserveTypeDao.findListByQuery(query);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<HistoryObserveType> pageInfo = new PageInfo<>(list);
		pageVO.setList(pageInfo.getList());
		pageVO.setTotalPages(pageInfo.getPages());
		pageVO.setTotalRecords(pageInfo.getTotal());
		return pageVO;
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<HistoryObserveType> getListByQuery(HistoryObserveType query) throws Exception {
		return historyObserveTypeDao.findListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(HistoryObserveType entity) throws Exception {
		String id = idGenerator.createId();
		entity.setId(id);
		if(historyObserveTypeDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean update(HistoryObserveType entity) throws Exception {
		String id = entity.getId();
		if(id != null){
			if(historyObserveTypeDao.update(entity) > 0 ){
				return  true;
			}
		}
		System.out.println("id为null");
		return false;
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public HistoryObserveType getById(String id) throws Exception {
		HistoryObserveType idObj = new HistoryObserveType();
		idObj.setId(id);
		// 查询
		List<HistoryObserveType> list = historyObserveTypeDao.findListByQuery(idObj);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public HistoryObserveType getByCode(String code) throws Exception {
		HistoryObserveType idObj = new HistoryObserveType();
		idObj.setCode(code);
		// 查询
		List<HistoryObserveType> list = historyObserveTypeDao.findListByQuery(idObj);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;

	}

}
