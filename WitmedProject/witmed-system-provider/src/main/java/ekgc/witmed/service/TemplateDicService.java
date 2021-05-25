package ekgc.witmed.service;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.pojo.system.dictionary.entity.DictionaryEntity;

import java.util.List;

public interface TemplateDicService {
	/**
	 * 分页查询
	 * @param query
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	PageVO<DictionaryEntity> getPageListByQuery(DictionaryEntity query, PageVO<DictionaryEntity> pageVO) throws Exception;

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<DictionaryEntity> getListByQuery(DictionaryEntity query) throws Exception;

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	boolean  save(DictionaryEntity entity) throws Exception;

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	boolean update(DictionaryEntity entity) throws  Exception;

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	DictionaryEntity getById(String id) throws Exception;

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	DictionaryEntity getByCode(String code) throws Exception;
}
