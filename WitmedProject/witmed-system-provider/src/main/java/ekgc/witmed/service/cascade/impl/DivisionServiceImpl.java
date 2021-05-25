package ekgc.witmed.service.cascade.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.pojo.system.cascade.entity.Division;
import ekgc.witmed.service.DivisionService;
import ekgc.witmed.system.cascade.dao.DivisionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("divisionServiceImpl")
public class DivisionServiceImpl implements DivisionService {
	@Autowired
	private DivisionDao dao;

	@Override
	public PageVO<Division> getPageListByQuery(PageVO<Division> pageVO, Division division) throws Exception {
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		List<Division> list = dao.findListByQuery(division);
		PageInfo<Division> pageInfo = new PageInfo<>(list);
		pageVO.setList(pageInfo.getList());
		pageVO.setTotalPages(pageInfo.getPages());
		pageVO.setTotalRecords(pageInfo.getTotal());
		return pageVO;
	}
}
