package ekgc.witmed.service;


import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.util.IdGenerator;

import java.util.List;

public interface DictionaryService<E> {

	/**
	 * 分页查询
	 * @param query
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	PageVO<E> getPageListByQuery(E query, PageVO<E> pageVO) throws Exception;

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<E> getListByQuery(E query) throws Exception;

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	boolean  save(E entity) throws Exception;

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	boolean update(E entity) throws  Exception;

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	E getById(String id) throws Exception;

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	E getByCode(String code) throws Exception;
}
