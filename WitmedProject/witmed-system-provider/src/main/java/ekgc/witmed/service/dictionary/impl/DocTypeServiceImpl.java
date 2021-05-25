package ekgc.witmed.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.system.dictionary.dao.DocTypeDao;
import ekgc.witmed.pojo.system.dictionary.entity.DocType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("docTypeService")
public class DocTypeServiceImpl implements DictionaryService<DocType> {
	@Autowired
	private DocTypeDao docTypeDao;
	@Autowired
	private IdGenerator idGenerator;

	@Override
	public PageVO<DocType> getPageListByQuery(DocType query, PageVO<DocType> pageVO) throws Exception {
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<DocType> list = docTypeDao.findListByQuery(query);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<DocType> pageInfo = new PageInfo<DocType>(list);
		pageVO.setList(pageInfo.getList());
		pageVO.setTotalPages(pageInfo.getPages());
		pageVO.setTotalRecords(pageInfo.getTotal());
		return pageVO;
	}

	@Override
	public List<DocType> getListByQuery(DocType query) throws Exception {
		return docTypeDao.findListByQuery(query);
	}

	@Override
	public boolean save(DocType entity) throws Exception {
		String id = idGenerator.createId();
		entity.setId(id);
		if(docTypeDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(DocType entity) throws Exception {
		String id = entity.getId();
		if(id != null){
			if(docTypeDao.update(entity) > 0 ){
				return  true;
			}
		}
		System.out.println("id为null");
		return false;
	}

	@Override
	public DocType getById(String id) throws Exception {
		DocType addressType = new DocType();
		addressType.setId(id);
		// 查询
		List<DocType> list = docTypeDao.findListByQuery(addressType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}

	@Override
	public DocType getByCode(String code) throws Exception {
		DocType addressType = new DocType();
		addressType.setCode(code);
		// 查询
		List<DocType> list = docTypeDao.findListByQuery(addressType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}
}
