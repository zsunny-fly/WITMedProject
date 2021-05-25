package ekgc.witmed.system.dictionary.dao;

import ekgc.witmed.pojo.patient.role.entity.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientDao {
	/**
	 * 根据查询对象查询数据库，返回 List
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Patient> findListByQuery(Patient query) throws Exception ;

	/**
	 * 保存对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(Patient entity) throws Exception;

	/**
	 * 修改信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(Patient entity) throws Exception;
}
