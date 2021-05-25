package ekgc.witmed.service;


import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.pojo.system.cascade.entity.Division;

public interface DivisionService {


	PageVO<Division> getPageListByQuery(PageVO<Division> pageVO, Division division) throws Exception;
}
