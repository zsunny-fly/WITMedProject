package ekgc.witmed.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.system.dictionary.dao.PayTypeDao;
import ekgc.witmed.pojo.system.dictionary.entity.PayType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("payTypeService")
public class PayTypeServiceImpl implements DictionaryService<PayType> {
	@Autowired
	private PayTypeDao payTypeDao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 	 *  分页查询
	 	 * @param query
	 	 * @param pageVO
	 	 * @return
	 	 * @throws Exception
	 	 */
	@Override
	public PageVO<PayType> getPageListByQuery(PayType query, PageVO<PayType> pageVO) throws Exception {
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<PayType> list = payTypeDao.findListByQuery(query);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<PayType> pageInfo = new PageInfo<PayType>(list);
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
	public List<PayType> getListByQuery(PayType query) throws Exception {
		return payTypeDao.findListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(PayType entity) throws Exception {
		String id = idGenerator.createId();
		entity.setId(id);
		if(payTypeDao.save(entity) > 0){
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
	public boolean update(PayType entity) throws Exception {
		String id = entity.getId();
		if(id != null){
			if(payTypeDao.update(entity) > 0 ){
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
	public PayType getById(String id) throws Exception {
		PayType idType = new PayType();
		idType.setId(id);
		// 查询
		List<PayType> list = payTypeDao.findListByQuery(idType);
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
	public PayType getByCode(String code) throws Exception {
		PayType idType = new PayType();
		idType.setCode(code);
		// 查询
		List<PayType> list = payTypeDao.findListByQuery(idType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}

}
