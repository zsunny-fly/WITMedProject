package ekgc.witmed.service.dictionary.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.system.dictionary.dao.MedicalInsuranceDao;
import ekgc.witmed.pojo.system.dictionary.entity.MedicalInsurance;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("medicalInsuranceService")
public class MedicalInsuranceServiceImpl extends IdService implements DictionaryService<MedicalInsurance> {

	@Autowired
	private MedicalInsuranceDao medicalInsuranceDao;


	/**
	 *  分页查询
	 * @param query
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<MedicalInsurance> getPageListByQuery(MedicalInsurance query, PageVO<MedicalInsurance> pageVO) throws Exception {
		// 使用 PageHelper 工具实现分页功能。
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<MedicalInsurance> list = medicalInsuranceDao.findListByQuery(query);
		// 通过 PageInfo 对象获取分页对象相关成员数据
		PageInfo<MedicalInsurance> pageInfo = new PageInfo<MedicalInsurance>(list);
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
	public List<MedicalInsurance> getListByQuery(MedicalInsurance query) throws Exception {
		return medicalInsuranceDao.findListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(MedicalInsurance entity) throws Exception {
		String id = idGenerator.createId();
		entity.setId(id);
		if(medicalInsuranceDao.save(entity) > 0){
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
	public boolean update(MedicalInsurance entity) throws Exception {
		String id = entity.getId();
		if(id != null){
			if(medicalInsuranceDao.update(entity) > 0 ){
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
	public MedicalInsurance getById(String id) throws Exception {
		MedicalInsurance idType = new MedicalInsurance();
		idType.setId(id);
		// 查询
		List<MedicalInsurance> list = medicalInsuranceDao.findListByQuery(idType);
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
	public MedicalInsurance getByCode(String code) throws Exception {
		MedicalInsurance idType = new MedicalInsurance();
		idType.setCode(code);
		// 查询
		List<MedicalInsurance> list = medicalInsuranceDao.findListByQuery(idType);
		if(list != null && !list.isEmpty()){
			return  list.get(0);
		}
		return null;

	}

}
