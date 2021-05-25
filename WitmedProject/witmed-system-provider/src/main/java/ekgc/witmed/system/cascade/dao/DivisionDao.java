package ekgc.witmed.system.cascade.dao;

import ekgc.witmed.pojo.system.cascade.entity.Division;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DivisionDao {
	/**
	 * 根据查询对象查询数据库，返回 List
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Division> findListByQuery(Division query) throws Exception ;

	/**
	 * 保存对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(Division entity) throws Exception;

	/**
	 * 修改信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(Division entity) throws Exception;
}
