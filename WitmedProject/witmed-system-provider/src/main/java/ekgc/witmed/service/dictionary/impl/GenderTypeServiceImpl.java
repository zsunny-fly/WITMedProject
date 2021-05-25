package ekgc.witmed.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.pojo.system.dictionary.entity.DictionaryEntity;
import ekgc.witmed.service.IdService;
import ekgc.witmed.service.TemplateDicService;
import ekgc.witmed.system.dictionary.dao.TemplateDicDao;
import ekgc.witmed.util.QueryMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("genderTypeService")
@Transactional
public class GenderTypeServiceImpl extends IdService implements TemplateDicService {
	@Autowired
	private TemplateDicDao templateDicDao;
	
	@Override
	public PageVO<DictionaryEntity> getPageListByQuery(DictionaryEntity query, PageVO<DictionaryEntity> pageVO) throws Exception {
		// 封装 mapper 查询文件对象
		Map<String,Object> map = QueryMapUtil.getQueryMap("sys_gender",query);
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<DictionaryEntity> list = templateDicDao.findListByQuery(map);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<DictionaryEntity> pageInfo = new PageInfo<DictionaryEntity>(list);
		pageVO.setList(pageInfo.getList());
		pageVO.setTotalPages(pageInfo.getPages());
		pageVO.setTotalRecords(pageInfo.getTotal());
		return pageVO;
	}

	@Override
	public List<DictionaryEntity> getListByQuery(DictionaryEntity query) throws Exception {
		// 封装 mapper 查询文件对象
		Map<String,Object> map = QueryMapUtil.getQueryMap("sys_gender",query);
		return templateDicDao.findListByQuery(map);
	}

	@Override
	public boolean save(DictionaryEntity entity) throws Exception {
		// 封装 mapper 查询文件对象
		Map<String,Object> map = QueryMapUtil.getQueryMap("sys_gender",entity);
		String id = idGenerator.createId();
		entity.setId(id);
		if(templateDicDao.save(map) > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(DictionaryEntity entity) throws Exception {
		// 封装 mapper 查询文件对象
		Map<String,Object> map = QueryMapUtil.getQueryMap("sys_gender",entity);
		String id = entity.getId();
		if(id != null){
			if(templateDicDao.update(map) > 0 ){
				return  true;
			}
		}
		System.out.println("id为null");
		return false;
	}

	@Override
	public DictionaryEntity getById(String id) throws Exception {
		DictionaryEntity DictionaryEntity = new DictionaryEntity();
		DictionaryEntity.setId(id);
		// 封装 mapper 查询文件对象
		Map<String,Object> map = QueryMapUtil.getQueryMap("sys_gender",DictionaryEntity);
		// 查询
		List list = templateDicDao.findListByQuery(map);
		if(list != null && !list.isEmpty()){
			List<DictionaryEntity> child = new ArrayList<>();
			child.add((DictionaryEntity) list.get(0));
			return  child.get(0);
		}
		return null;
	}

	@Override
	public DictionaryEntity getByCode(String code) throws Exception {
		DictionaryEntity DictionaryEntity = new DictionaryEntity();
		DictionaryEntity.setCode(code);
		// 封装 mapper 查询文件对象
		Map<String,Object> map = QueryMapUtil.getQueryMap("sys_gender",DictionaryEntity);
		// 查询
		List<DictionaryEntity> list = templateDicDao.findListByQuery(map);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}
}
