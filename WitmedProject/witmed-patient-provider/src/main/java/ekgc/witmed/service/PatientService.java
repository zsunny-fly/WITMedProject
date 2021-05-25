package ekgc.witmed.service;

import ekgc.witmed.pojo.patient.role.entity.Patient;
import ekgc.witmed.pojo.vo.PatientVO;

public interface PatientService {
	/**
	 * 通过手机号码获取对象
	 * @param cellphone
	 * @return
	 */
	Patient getByCellphone(String cellphone) throws Exception;

	/**
	 * 添加患者信息
	 * @param patientVO
	 * @return
	 */
	boolean addPatient(PatientVO patientVO) throws  Exception;

}
