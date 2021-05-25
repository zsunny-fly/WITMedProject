package ekgc.witmed.service.cascade.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.pojo.system.cascade.entity.CascadeEntity;
import ekgc.witmed.service.CascadeEntityService;
import ekgc.witmed.service.IdService;
import ekgc.witmed.system.cascade.dao.CascadeEntityDao;
import ekgc.witmed.util.QueryMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("illnessTypeService")
@Transactional
public class IllnessTypeServiceImpl extends IdService implements CascadeEntityService {
	@Autowired
	private CascadeEntityDao cascadeEntityDao;

	@Override
	public PageVO<CascadeEntity> getPageListByQuery(CascadeEntity query, PageVO<CascadeEntity> pageVO) throws Exception {
		// 封装 mapper 查询文件对象
		Map<String,Object> map = QueryMapUtil.getQueryMap("sys_illness",query);
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<CascadeEntity> list = cascadeEntityDao.findListByQuery(map);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<CascadeEntity> pageInfo = new PageInfo<CascadeEntity>(list);
		pageVO.setList(pageInfo.getList());
		pageVO.setTotalPages(pageInfo.getPages());
		pageVO.setTotalRecords(pageInfo.getTotal());
		return pageVO;
	}

	@Override
	public List<CascadeEntity> getListByQuery(CascadeEntity query) throws Exception {
		// 封装 mapper 查询文件对象
		Map<String,Object> map = QueryMapUtil.getQueryMap("sys_illness",query);
		return cascadeEntityDao.findListByQuery(map);
	}

	@Override
	public boolean save(CascadeEntity entity) throws Exception {
		// 封装 mapper 查询文件对象
		Map<String,Object> map = QueryMapUtil.getQueryMap("sys_illness",entity);
		String id = idGenerator.createId();
		entity.setId(id);
		if(cascadeEntityDao.save(map) > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(CascadeEntity entity) throws Exception {
		// 封装 mapper 查询文件对象
		Map<String,Object> map = QueryMapUtil.getQueryMap("sys_illness",entity);
		String id = entity.getId();
		if(id != null){
			if(cascadeEntityDao.update(map) > 0 ){
				return  true;
			}
		}
		System.out.println("id为null");
		return false;
	}

	@Override
	public CascadeEntity getById(String id) throws Exception {
		CascadeEntity CascadeEntity = new CascadeEntity();
		CascadeEntity.setId(id);
		// 封装 mapper 查询文件对象
		Map<String,Object> map = QueryMapUtil.getQueryMap("sys_illness",CascadeEntity);
		// 查询
		List list = cascadeEntityDao.findListByQuery(map);
		if(list != null && !list.isEmpty()){
			List<ekgc.witmed.pojo.system.cascade.entity.CascadeEntity> child = new ArrayList<>();
			child.add((CascadeEntity) list.get(0));
			return  child.get(0);
		}
		return null;
	}

	@Override
	public CascadeEntity getByCode(String code) throws Exception {
		CascadeEntity CascadeEntity = new CascadeEntity();
		CascadeEntity.setCode(code);
		// 封装 mapper 查询文件对象
		Map<String,Object> map = QueryMapUtil.getQueryMap("sys_illness",CascadeEntity);
		// 查询
		List<CascadeEntity> list = cascadeEntityDao.findListByQuery(map);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;
	}
}
