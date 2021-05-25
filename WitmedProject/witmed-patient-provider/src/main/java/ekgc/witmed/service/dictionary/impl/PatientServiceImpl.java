package ekgc.witmed.service.dictionary.impl;

import ekgc.witmed.system.dictionary.dao.PatientDao;
import ekgc.witmed.pojo.patient.role.entity.Patient;
import ekgc.witmed.pojo.vo.PatientVO;
import ekgc.witmed.service.PatientService;
import ekgc.witmed.util.IdGenerator;
import ekgc.witmed.util.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private IdGenerator idGenerator ;

	/**
	 * 通过手机号码获取对象
	 * @param cellphone
	 * @return
	 */
	@Override
	public Patient getByCellphone(String cellphone) throws Exception {
		// 封装查询对象
		Patient query = new Patient();
		query.setCellphone(cellphone);
		List<Patient> list = patientDao.findListByQuery(query);
		if(list != null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 添加患者信息
	 * @param patientVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean addPatient(PatientVO patientVO) throws  Exception{
		Patient patient = new Patient();
		// 通过 BeanUtils 将 patientVO 对象中属性数据 复制 到 patient
		BeanUtils.copyProperties(patientVO,patient);
		patient.setId(idGenerator.createId());
		int count = patientDao.save(patient);
		if(count > 0 ){
			return true;
		}else{
			return false;
		}
	}


}
