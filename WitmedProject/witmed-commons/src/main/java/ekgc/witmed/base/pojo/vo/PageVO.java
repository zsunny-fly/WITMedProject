package ekgc.witmed.base.pojo.vo;

import ekgc.witmed.util.ConstantUtil;

import java.io.Serializable;
import java.util.List;

public class PageVO<E> implements Serializable {
	private static final long serialVersionUID = 8567677844770078747L;
	private Integer pageNum;            // 当前页码
	private Integer pageSize;           // 每页显示数量
	private List<E> list;               // 分页列表
	private Long totalRecords;          // 总记录条数
	private Integer totalPages;         // 总页数

	public PageVO(){}

	public PageVO(Integer pageNum, Integer pageSize) {
		if(pageNum != null && pageNum > 0){
			this.pageNum = pageNum;
		} else {
			this.pageNum = ConstantUtil.PAGE_NUM;
		}
		if(pageSize != null && pageSize > 0){
			this.pageSize = pageSize;
		} else {
			this.pageSize = ConstantUtil.PAGE_SIZE;
		}
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
}
