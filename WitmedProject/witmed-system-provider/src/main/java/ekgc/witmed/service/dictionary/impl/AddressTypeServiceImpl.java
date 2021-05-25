package ekgc.witmed.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.system.dictionary.dao.AddressTypeDao;
import ekgc.witmed.pojo.system.dictionary.entity.AddressType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addressTypeService")
public class AddressTypeServiceImpl implements DictionaryService<AddressType> {
	@Autowired
	private AddressTypeDao addressTypeDao;
	@Autowired
	private IdGenerator idGenerator;

	@Override
	public PageVO<AddressType> getPageListByQuery(AddressType query, PageVO<AddressType> pageVO) throws Exception {
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<AddressType> list = addressTypeDao.findListByQuery(query);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<AddressType> pageInfo = new PageInfo<AddressType>(list);
		pageVO.setList(pageInfo.getList());
		pageVO.setTotalPages(pageInfo.getPages());
		pageVO.setTotalRecords(pageInfo.getTotal());
		return pageVO;
	}

	@Override
	public List<AddressType> getListByQuery(AddressType query) throws Exception {
		return addressTypeDao.findListByQuery(query);
	}

	@Override
	public boolean save(AddressType entity) throws Exception {
		String id = idGenerator.createId();
		entity.setId(id);
		if(addressTypeDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(AddressType entity) throws Exception {
		String id = entity.getId();
		if(id != null){
			if(addressTypeDao.update(entity) > 0 ){
				return  true;
			}
		}
		System.out.println("id为null");
		return false;
	}

	@Override
	public AddressType getById(String id) throws Exception {
		AddressType addressType = new AddressType();
		addressType.setId(id);
		// 查询
		List<AddressType> list = addressTypeDao.findListByQuery(addressType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}

	@Override
	public AddressType getByCode(String code) throws Exception {
		AddressType addressType = new AddressType();
		addressType.setCode(code);
		// 查询
		List<AddressType> list = addressTypeDao.findListByQuery(addressType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}
}
