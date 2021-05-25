package ekgc.witmed.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.system.dictionary.dao.PaySourceDao;
import ekgc.witmed.pojo.system.dictionary.entity.PaySource;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("paySourceService")
public class PaySourceServiceImpl extends IdService implements DictionaryService<PaySource> {
	@Autowired
	private PaySourceDao paySourceDao;

	@Override
	public PageVO<PaySource> getPageListByQuery(PaySource query, PageVO<PaySource> pageVO) throws Exception {
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<PaySource> list = paySourceDao.findListByQuery(query);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<PaySource> pageInfo = new PageInfo<PaySource>(list);
		pageVO.setList(pageInfo.getList());
		pageVO.setTotalPages(pageInfo.getPages());
		pageVO.setTotalRecords(pageInfo.getTotal());
		return pageVO;
	}

	@Override
	public List<PaySource> getListByQuery(PaySource query) throws Exception {
		return paySourceDao.findListByQuery(query);
	}

	@Override
	public boolean save(PaySource entity) throws Exception {
		String id = idGenerator.createId();
		entity.setId(id);
		if(paySourceDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(PaySource entity) throws Exception {
		String id = entity.getId();
		if(id != null){
			if(paySourceDao.update(entity) > 0 ){
				return  true;
			}
		}
		System.out.println("id为null");
		return false;
	}

	@Override
	public PaySource getById(String id) throws Exception {
		PaySource idType = new PaySource();
		idType.setId(id);
		// 查询
		List<PaySource> list = paySourceDao.findListByQuery(idType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}

	@Override
	public PaySource getByCode(String code) throws Exception {
		PaySource idType = new PaySource();
		idType.setCode(code);
		// 查询
		List<PaySource> list = paySourceDao.findListByQuery(idType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;

	}
}
