package ekgc.witmed.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.system.dictionary.dao.PatientRiskDao;
import ekgc.witmed.pojo.system.dictionary.entity.PatientRisk;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("patientRiskService")
public class PatientRiskServiceImpl extends IdService implements DictionaryService<PatientRisk> {
	@Autowired
	private PatientRiskDao patientRiskDao;


	/**
	 *  分页查询
	 * @param query
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<PatientRisk> getPageListByQuery(PatientRisk query, PageVO<PatientRisk> pageVO) throws Exception {
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<PatientRisk> list = patientRiskDao.findListByQuery(query);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<PatientRisk> pageInfo = new PageInfo<PatientRisk>(list);
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
	public List<PatientRisk> getListByQuery(PatientRisk query) throws Exception {
		return patientRiskDao.findListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(PatientRisk entity) throws Exception {
		String id = idGenerator.createId();
		entity.setId(id);
		if(patientRiskDao.save(entity) > 0){
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
	public boolean update(PatientRisk entity) throws Exception {
		String id = entity.getId();
		if(id != null){
			if(patientRiskDao.update(entity) > 0 ){
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
	public PatientRisk getById(String id) throws Exception {
		PatientRisk PatientRisk = new PatientRisk();
		PatientRisk.setId(id);
		// 查询
		List<PatientRisk> list = patientRiskDao.findListByQuery(PatientRisk);
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
	public PatientRisk getByCode(String code) throws Exception {
		PatientRisk PatientRisk = new PatientRisk();
		PatientRisk.setCode(code);
		// 查询
		List<PatientRisk> list = patientRiskDao.findListByQuery(PatientRisk);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;

	}
}

