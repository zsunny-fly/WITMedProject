package ekgc.witmed.system.dictionary.dao;


import java.util.List;

public interface DictionaryDao<E> {

	/**
	 * 根据查询对象查询数据库，返回 List
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<E> findListByQuery(E query) throws Exception ;

	/**
	 * 保存对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(E entity) throws Exception;

	/**
	 * 修改信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(E entity) throws Exception;
}
