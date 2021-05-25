package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.DocType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.DocTypeTransport;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("docTypeTransport")
@RequestMapping("/system/docType/transport")
public class DocTypeTransportImpl implements DocTypeTransport {
	@Resource(name = "docTypeService")
	private DictionaryService<DocType> docTypeService;

	/**
	 * 分页查询
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<DocType> getPageListByQuery(@RequestBody PageQueryVO<DocType> queryVO) throws Exception{
		DocType query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return docTypeService.getPageListByQuery(query,pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<DocType> getListByQuery(@RequestBody DocType query) throws Exception{
		return docTypeService.getListByQuery(query);
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean  save(@RequestBody DocType entity) throws Exception{
		return docTypeService.save(entity);
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody DocType entity) throws  Exception{
		return docTypeService.update(entity);
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public DocType getById(@RequestParam String id) throws Exception{
		return docTypeService.getById(id);
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public DocType getByCode(@RequestParam String code) throws Exception{
		return docTypeService.getByCode(code);
	}
}
