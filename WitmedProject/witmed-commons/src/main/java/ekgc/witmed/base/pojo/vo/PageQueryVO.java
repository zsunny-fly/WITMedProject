package ekgc.witmed.base.pojo.vo;

import java.io.Serializable;

public class PageQueryVO<E> implements Serializable {
	private static final long serialVersionUID = -5558348439701851987L;
	private E query;                    // 某个类型的查询对象
	private PageVO<E> pageVO;           // 对应类型的分页对象

	public PageQueryVO() {}

	public PageQueryVO(E query, PageVO<E> pageVO) {
		this.query = query;
		this.pageVO = pageVO;
	}

	public E getQuery() {
		return query;
	}

	public void setQuery(E query) {
		this.query = query;
	}

	public PageVO<E> getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO<E> pageVO) {
		this.pageVO = pageVO;
	}
}
