package ekgc.witmed.system.dictionary.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TemplateDicDao {
	/**
	 * 根据查询对象查询数据库，返回 List
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List findListByQuery(Map map) throws Exception ;

	/**
	 * 保存对象信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	int save(Map map) throws Exception;

	/**
	 * 修改信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	int update(Map map) throws Exception;
}
