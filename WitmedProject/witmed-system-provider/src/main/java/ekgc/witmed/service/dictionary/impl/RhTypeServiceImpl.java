package ekgc.witmed.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.system.dictionary.dao.RhTypeDao;
import ekgc.witmed.pojo.system.dictionary.entity.RhType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rhTypeService")
public class RhTypeServiceImpl extends IdService implements DictionaryService<RhType> {
	@Autowired
	private RhTypeDao rhTypeDao;

	@Override
	public PageVO<RhType> getPageListByQuery(RhType query, PageVO<RhType> pageVO) throws Exception {
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<RhType> list = rhTypeDao.findListByQuery(query);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<RhType> pageInfo = new PageInfo<RhType>(list);
		pageVO.setList(pageInfo.getList());
		pageVO.setTotalPages(pageInfo.getPages());
		pageVO.setTotalRecords(pageInfo.getTotal());
		return pageVO;
	}

	@Override
	public List<RhType> getListByQuery(RhType query) throws Exception {
		return rhTypeDao.findListByQuery(query);
	}

	@Override
	public boolean save(RhType entity) throws Exception {
		String id = idGenerator.createId();
		entity.setId(id);
		if(rhTypeDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(RhType entity) throws Exception {
		String id = entity.getId();
		if(id != null){
			if(rhTypeDao.update(entity) > 0 ){
				return  true;
			}
		}
		System.out.println("id为null");
		return false;
	}

	@Override
	public RhType getById(String id) throws Exception {
		RhType idType = new RhType();
		idType.setId(id);
		// 查询
		List<RhType> list = rhTypeDao.findListByQuery(idType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}

	@Override
	public RhType getByCode(String code) throws Exception {
		RhType idType = new RhType();
		idType.setCode(code);
		// 查询
		List<RhType> list = rhTypeDao.findListByQuery(idType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}
}
