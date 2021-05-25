package ekgc.witmed.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.system.dictionary.dao.IdTypeDao;
import ekgc.witmed.pojo.system.dictionary.entity.IdType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("idTypeService")
public class IdTypeServiceImpl extends IdService implements DictionaryService<IdType> {
	@Autowired
	private IdTypeDao idTypeDao;


	/**
	 *  分页查询
	 * @param query
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<IdType> getPageListByQuery(IdType query, PageVO<IdType> pageVO) throws Exception {
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<IdType> list = idTypeDao.findListByQuery(query);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<IdType> pageInfo = new PageInfo<IdType>(list);
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
	public List<IdType> getListByQuery(IdType query) throws Exception {
		return idTypeDao.findListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(IdType entity) throws Exception {
		String id = idGenerator.createId();
		entity.setId(id);
		if(idTypeDao.save(entity) > 0){
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
	public boolean update(IdType entity) throws Exception {
		String id = entity.getId();
		if(id != null){
			if(idTypeDao.update(entity) > 0 ){
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
	public IdType getById(String id) throws Exception {
		IdType idType = new IdType();
		idType.setId(id);
		// 查询
		List<IdType> list = idTypeDao.findListByQuery(idType);
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
	public IdType getByCode(String code) throws Exception {
		IdType idType = new IdType();
		idType.setCode(code);
		// 查询
		List<IdType> list = idTypeDao.findListByQuery(idType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;

	}
}
