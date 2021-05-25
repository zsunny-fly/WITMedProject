package ekgc.witmed.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.system.dictionary.dao.ABOTypeDao;
import ekgc.witmed.pojo.system.dictionary.entity.ABOType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("aboTypeService")
public class ABOTypeServiceImpl extends IdService implements DictionaryService<ABOType> {
	@Autowired
	private ABOTypeDao aboTypeDao;


	@Override
	public PageVO<ABOType> getPageListByQuery(ABOType query, PageVO<ABOType> pageVO) throws Exception {
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<ABOType> list = aboTypeDao.findListByQuery(query);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<ABOType> pageInfo = new PageInfo<ABOType>(list);
		pageVO.setList(pageInfo.getList());
		pageVO.setTotalPages(pageInfo.getPages());
		pageVO.setTotalRecords(pageInfo.getTotal());
		return pageVO;
	}

	@Override
	public List<ABOType> getListByQuery(ABOType query) throws Exception {
		return aboTypeDao.findListByQuery(query);
	}

	@Override
	public boolean save(ABOType entity) throws Exception {
		String id = idGenerator.createId();
		entity.setId(id);
		if(aboTypeDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(ABOType entity) throws Exception {
		String id = entity.getId();
		if(id != null){
			if(aboTypeDao.update(entity) > 0 ){
				return  true;
			}
		}
		System.out.println("id为null");
		return false;
	}

	@Override
	public ABOType getById(String id) throws Exception {
		ABOType idType = new ABOType();
		idType.setId(id);
		// 查询
		List<ABOType> list = aboTypeDao.findListByQuery(idType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}

	@Override
	public ABOType getByCode(String code) throws Exception {
		ABOType idType = new ABOType();
		idType.setCode(code);
		// 查询
		List<ABOType> list = aboTypeDao.findListByQuery(idType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}
}
