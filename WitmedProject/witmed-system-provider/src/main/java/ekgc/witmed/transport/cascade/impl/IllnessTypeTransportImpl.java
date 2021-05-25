package ekgc.witmed.transport.cascade.impl;

import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.pojo.system.cascade.entity.CascadeEntity;
import ekgc.witmed.service.CascadeEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("illnessTypeTransport")
@RequestMapping("/system/illnessType/transport")
public class IllnessTypeTransportImpl {
	@Autowired
	private CascadeEntityService illnessTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<CascadeEntity> getPageListByQuery(@RequestBody PageQueryVO<CascadeEntity> queryVO) throws Exception{
		CascadeEntity query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return illnessTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<CascadeEntity> getListByQuery(@RequestBody CascadeEntity query) throws Exception{
		return illnessTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody CascadeEntity entity) throws Exception{
		return illnessTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody CascadeEntity entity) throws  Exception{
		return illnessTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public CascadeEntity getById(@RequestParam String id) throws Exception{
		return illnessTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public CascadeEntity getByCode(@RequestParam String code) throws Exception{
		return illnessTypeService.getByCode(code);
	}
}
