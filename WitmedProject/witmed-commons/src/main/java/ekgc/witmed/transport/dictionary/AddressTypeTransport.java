package ekgc.witmed.transport.dictionary;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.AddressType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "witmed-system-provider")
@RequestMapping("/system/addressType/transport")
public interface AddressTypeTransport{

	@PostMapping("/page")
	PageVO<AddressType> getPageListByQuery(PageQueryVO<AddressType> queryVO) throws Exception ;


	@PostMapping("/list")
	public List<AddressType> getListByQuery(@RequestBody AddressType query) throws Exception ;


	@PostMapping("/save")
	public boolean save(AddressType entity) throws Exception;


	@PostMapping("/update")
	public boolean update(AddressType entity) throws Exception ;


	@PostMapping("/id")
	public AddressType getById(String id) throws Exception ;

	@PostMapping("/code")
	public AddressType getByCode(@RequestParam String code) throws Exception ;

}
