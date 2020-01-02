package com.wht.util.page;


public class PageModel {
	private int recordCount;// 记录数
	private int pageIndex;// 页码
	private int pageSize = HrmConstants.PAGE_DEFAULT_SIZE;// 页容量
	private int totalSize;// 总页数
/*
* 每个get方法中要设置对应属性的取值范围
* */
	public int getRecordCount() {
		this.recordCount = this.recordCount <= 0 ? 0 : this.recordCount;
		return recordCount;
	}

	public void setRecordCount(int recordCount) {

		this.recordCount = recordCount;
	}

	public int getPageIndex() {
		this.pageIndex = this.pageIndex <= 0 ? 1 : this.pageIndex;
		this.pageIndex = this.pageIndex > this.getTotalSize() ? this
				.getTotalSize() : this.pageIndex;
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		this.pageSize = this.pageSize <= HrmConstants.PAGE_DEFAULT_SIZE ? HrmConstants.PAGE_DEFAULT_SIZE
				: this.pageSize;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		if (this.getRecordCount() <= 0) {
			this.totalSize = 0;
		} else {
			totalSize = (this.getRecordCount() - 1) / this.getPageSize() + 1;
		}
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	//取得每一页第一行记录的索引号，使用mysql数据库
	public int getFirstLimitParam(){
		return (this.getPageIndex()-1)*this.getPageSize();
	}

	@Override
	public String toString() {
		return "PageModel [recordCount=" + recordCount + ", pageIndex="
				+ pageIndex + ", pageSize=" + pageSize + ", totalSize="
				+ totalSize + "]";
	}

}
