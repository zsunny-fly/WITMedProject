package ekgc.witmed.transport.dictionary.impl;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.AddressType;
import ekgc.witmed.service.DictionaryService;
import ekgc.witmed.transport.dictionary.AddressTypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("addressTypeTransport")
@RequestMapping("/system/addressType/transport")
public class AddressTypeTransportImpl implements AddressTypeTransport {
	@Autowired
	private DictionaryService<AddressType> addressTypeService;

	@Override
	@PostMapping("/page")
	public PageVO<AddressType> getPageListByQuery(@RequestBody PageQueryVO<AddressType> queryVO) throws Exception {
		AddressType query = queryVO.getQuery();
		PageVO pageVO = queryVO.getPageVO();
		return addressTypeService.getPageListByQuery(query,pageVO);
	}

	@Override
	@PostMapping("/list")
	public List<AddressType> getListByQuery(@RequestBody AddressType query) throws Exception {
		return addressTypeService.getListByQuery(query);
	}

	@Override
	@PostMapping("/save")
	public boolean save(@RequestBody AddressType entity) throws Exception {
		return addressTypeService.save(entity);
	}

	@Override
	@PostMapping("/update")
	public boolean update(@RequestBody AddressType entity) throws Exception {
		return addressTypeService.update(entity);
	}

	@Override
	@PostMapping("/id")
	public AddressType getById(@RequestParam String id) throws Exception {
		return addressTypeService.getById(id);
	}

	@Override
	@PostMapping("/code")
	public AddressType getByCode(@RequestParam String code) throws Exception {
		return addressTypeService.getByCode(code);
	}
}
