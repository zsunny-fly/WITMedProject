package ekgc.witmed.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.system.dictionary.dao.PriceTypeDao;
import ekgc.witmed.pojo.system.dictionary.entity.PriceType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("priceTypeService")
public class PriceTypeServiceImpl extends IdService implements DictionaryService<PriceType> {
	@Autowired
	private PriceTypeDao priceTypeDao;

	@Override
	public PageVO<PriceType> getPageListByQuery(PriceType query, PageVO<PriceType> pageVO) throws Exception {
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<PriceType> list = priceTypeDao.findListByQuery(query);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<PriceType> pageInfo = new PageInfo<PriceType>(list);
		pageVO.setList(pageInfo.getList());
		pageVO.setTotalPages(pageInfo.getPages());
		pageVO.setTotalRecords(pageInfo.getTotal());
		return pageVO;
	}

	@Override
	public List<PriceType> getListByQuery(PriceType query) throws Exception {
		return priceTypeDao.findListByQuery(query);
	}

	@Override
	public boolean save(PriceType entity) throws Exception {
		String id = idGenerator.createId();
		entity.setId(id);
		if(priceTypeDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(PriceType entity) throws Exception {
		String id = entity.getId();
		if(id != null){
			if(priceTypeDao.update(entity) > 0 ){
				return  true;
			}
		}
		System.out.println("id为null");
		return false;
	}

	@Override
	public PriceType getById(String id) throws Exception {
		PriceType idType = new PriceType();
		idType.setId(id);
		// 查询
		List<PriceType> list = priceTypeDao.findListByQuery(idType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}

	@Override
	public PriceType getByCode(String code) throws Exception {
		PriceType idType = new PriceType();
		idType.setCode(code);
		// 查询
		List<PriceType> list = priceTypeDao.findListByQuery(idType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;

	}
}
