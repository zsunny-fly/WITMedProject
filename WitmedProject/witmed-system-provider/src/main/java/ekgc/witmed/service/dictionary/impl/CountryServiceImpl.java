package ekgc.witmed.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.system.dictionary.dao.CountryDao;
import ekgc.witmed.pojo.system.dictionary.entity.Country;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("countryService")
public class CountryServiceImpl extends IdService implements DictionaryService<Country> {
	@Autowired
	private CountryDao countryDao;


	/**
	 *  分页查询
	 * @param query
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<Country> getPageListByQuery(Country query, PageVO<Country> pageVO) throws Exception {
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<Country> list = countryDao.findListByQuery(query);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<Country> pageInfo = new PageInfo<Country>(list);
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
	public List<Country> getListByQuery(Country query) throws Exception {
		return countryDao.findListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(Country entity) throws Exception {
		String id = idGenerator.createId();
		entity.setId(id);
		if(countryDao.save(entity) > 0){
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
	public boolean update(Country entity) throws Exception {
		String id = entity.getId();
		if(id != null){
			if(countryDao.update(entity) > 0 ){
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
	public Country getById(String id) throws Exception {
		Country Country = new Country();
		Country.setId(id);
		// 查询
		List<Country> list = countryDao.findListByQuery(Country);
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
	public Country getByCode(String code) throws Exception {
		Country Country = new Country();
		Country.setCode(code);
		// 查询
		List<Country> list = countryDao.findListByQuery(Country);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;

	}
}
