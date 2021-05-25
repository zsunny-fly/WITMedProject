package ekgc.witmed.service.dictionary.impl;

public class ModelSI {

//
//	@Autowired
//	private IdTypeDao idTypeDao;
//	@Autowired
//	private IdGenerator idGenerator;
//
//	/**
//	 *  分页查询
//	 * @param query
//	 * @param pageVO
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public PageVO<E> getPageListByQuery(E query, PageVO<E> pageVO) throws Exception {
//		// 使用 PageHelper 工具实现分页功能。
//		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
//		List<E> list = idTypeDao.findListByQuery(query);
//		// 通过 PageInfo 对象获取分页对象相关成员数据
//		PageInfo<E> pageInfo = new PageInfo<>(list);
//		pageVO.setList(pageInfo.getList());
//		pageVO.setTotalPages(pageInfo.getPages());
//		pageVO.setTotalRecords(pageInfo.getTotal());
//		return pageVO;
//	}
//
//	/**
//	 * 根据查询对象，查询数据库返回列表
//	 * @param query
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public List<E> getListByQuery(E query) throws Exception {
//		return idTypeDao.findListByQuery(query);
//	}
//
//	/**
//	 * 保存某类型的实体对象
//	 * @param entity
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public boolean save(E entity) throws Exception {
//		String id = idGenerator.createId();
//		entity.setId(id);
//		if(idTypeDao.save(entity) > 0){
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * 修改实体对象信息
//	 * @param entity
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public boolean update(E entity) throws Exception {
//		String id = entity.getId();
//		if(id != null){
//			if(idTypeDao.update(entity) > 0 ){
//				return  true;
//			}
//		}
//		System.out.println("id为null");
//		return false;
//	}
//
//	/**
//	 * 根据主键查询对象
//	 * @param id
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public E getById(String id) throws Exception {
//		E idObj = new E();
//		idObj.setId(id);
//		// 查询
//		List<E> list = idTypeDao.findListByQuery(idObj);
//		if(list != null && !list.isEmpty()){
//			return  list.get(0);
//		}
//		return null;
//	}
//
//	/**
//	 * 根据编码查询对象
//	 * @param code
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public E getByCode(String code) throws Exception {
//		E idObj = new E();
//		idObj.setCode(code);
//		// 查询
//		List<E> list = idTypeDao.findListByQuery(idObj);
//		if(list != null && !list.isEmpty()){
//			return  list.get(0);
//		}
//		return null;
//
//	}



}
