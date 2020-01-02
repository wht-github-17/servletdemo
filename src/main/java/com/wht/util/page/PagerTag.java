package com.wht.util.page;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PagerTag extends SimpleTagSupport {
	private static final String TAG = "{0}";// ����URL�е�ռλ������
	private int pageIndex;// ��ǰҳ��
	private int pageSize;// ÿҳ��¼��
	private int recordCount;// �ܼ�¼��
	private String submitUrl;// ����URL,page.action?pageIndex={0}
	private String style = "sabrosus";
	private int totalPage = 0;// ��ҳ��

	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder res = new StringBuilder();
		StringBuilder str = new StringBuilder();
		if (recordCount > 0) {
			totalPage = (this.recordCount - 1) / this.pageSize + 1;
			if (this.pageIndex == 1) {
				str.append("<span class='disabled'>上一页</span>");
				this.calcPage(str);
				if (this.pageIndex == totalPage) {
					str.append("<span class='disabled'>��һҳ</span>");
				} else {
					String tempUrl = this.submitUrl.replace(TAG,
							String.valueOf(pageIndex + 1));
					str.append("<a href='" + tempUrl + "'>��һҳ</a>");
				}
			} else if (this.pageIndex == totalPage) {
				String tempUrl = this.submitUrl.replace(TAG,
						String.valueOf(pageIndex - 1));
				str.append("<a href='" + tempUrl + "'>��һҳ</a>");
				this.calcPage(str);
				str.append("<span class='disabled'>��һҳ</span>");
			} else {
				String tempUrl = this.submitUrl.replace(TAG,
						String.valueOf(pageIndex - 1));
				str.append("<a href='" + tempUrl + "'>��һҳ</a>");
				this.calcPage(str);
				tempUrl = this.submitUrl.replace(TAG,
						String.valueOf(pageIndex + 1));
				str.append("<a href='" + tempUrl + "'>��һҳ</a>");
			}
			// ƴ����������Ϣ
			res.append("<table width='100%' align='center' style='font-size:13px;' class='"
					+ style + "'>");
			res.append("<tr><td style='color:#0061de;margin-right: 3px;padding-top: 2px;text-decoration: none'>"
					+ str.toString());
			res.append("&nbsp;��ת��&nbsp;&nbsp;<input style='text-align:center;border:#aaaadd 1px solid;padding:2px 5px 2px 5px;margin:2px;color:#000099;text-decoration:none' type='text' size='2' id='pager_jump_page_size'/>");
			res.append("&nbsp;<input type='button' style='text-align: center;border:#dedfde 1px solid;padding:2px 6px 2px 6px;background-position: 50%bottom;color:#0061de;margin-right: 3px;text-decoration: none' value='ȷ��' id='pager_jump_btn'/>");
			res.append("</td></tr>");
			res.append("<tr align='center'><td style='font-size: 13px;color:#0061de;margin-bottom: 3px;padding-top: 2px;text-decoration: none'>");
			int startNum = (this.pageIndex - 1) * this.pageSize + 1;
			int endNum = (this.pageIndex == this.totalPage ? this.recordCount
					: this.pageIndex * this.pageSize);
			res.append("�ܹ�<font color='red'>" + this.recordCount
					+ "</font>����¼����ǰ��ʾ" + startNum + "-" + endNum + "����¼��");
			res.append("</td></tr></table>");
			res.append("<script type='text/javascript'>");
			res.append("document.getElementById('pager_jump_btn').onclick=function(){");
			res.append("var page_size=document.getElementById('pager_jump_page_size').value;");
			res.append("if(!/^[1-9]\\d*$/.test(page_size)||page_size<1||page_size>"
					+ this.totalPage + "){");
			res.append("alert('������[1-" + this.totalPage + "]֮���ҳ�룡');");
			res.append("}else{");
			res.append("var submit_url='" + this.submitUrl + "';");
			res.append("window.location=submit_url.replace('" + TAG
					+ "',page_size);");
			res.append("}");
			res.append("}");
			res.append("</script>");
		} else {
			res.append("<table align='center' style='font-size: 13px;'><tr><td style='color:#0061de;margin-right:3px;padding-top:2px;text-decoration:none'>总共<font color='red'>0</font>条记录，当前显示0-0条记录。</td></tr></table>");
		}
		this.getJspContext().getOut().print(res.toString());
	}

	private void calcPage(StringBuilder str) {
		if (this.totalPage <= 11) {
			for (int i = 1; i < this.totalPage; i++) {
				if (this.pageIndex == i) {
					str.append("<span class='current'>" + i + "</span>");
				} else {
					String tempUrl = this.submitUrl.replace(TAG,
							String.valueOf(i));
					str.append("<a href='" + tempUrl + "'>" + i + "</a>");
				}
			}
		} else {
			if (this.pageIndex <= 8) {
				for (int i = 1; i <= 10; i++) {
					if (this.pageIndex == i) {
						str.append("<span class='current'" + i + "</span>");
					} else {
						String tempUrl = this.submitUrl.replace(TAG,
								String.valueOf(i));
						str.append("<a href='" + tempUrl + "'>" + i + "</a>");
					}
				}
				str.append("...");
				String tempUrl = this.submitUrl.replace(TAG,
						String.valueOf(this.totalPage));
				str.append("<a href='" + tempUrl + "'>" + this.totalPage
						+ "</a>");
			} else if (this.pageIndex + 8 >= this.totalPage) {
				String tempUrl = this.submitUrl.replace(TAG, String.valueOf(1));
				str.append("<a href='" + tempUrl + "'>1</a>");
				str.append("...");
				for (int i = this.totalPage - 10; i <= this.totalPage; i++) {
					if (this.pageIndex == i) {
						str.append("<span class='current'>" + i + "</span>");
					} else {
						tempUrl = this.submitUrl
								.replace(TAG, String.valueOf(i));
						str.append("<a href='" + tempUrl + "'>" + i + "</a>");
					}
				}
			} else {
				String tempUrl = this.submitUrl.replace(TAG, String.valueOf(1));
				str.append("<a href='" + tempUrl + "'>1</a>");
				str.append("...");
				for (int i = this.pageIndex - 4; i <= this.pageIndex + 4; i++) {
					if (this.pageIndex == i) {
						str.append("<span class='current'>" + i + "</span>");
					} else {
						tempUrl = this.submitUrl
								.replace(TAG, String.valueOf(i));
						str.append("<a href='" + tempUrl + "'>" + i + "</a>");
					}
				}
				str.append("...");
				tempUrl = this.submitUrl.replace(TAG,
						String.valueOf(this.totalPage));
				str.append("<a href='" + tempUrl + "'>" + this.totalPage
						+ "</a>");

			}

		}

	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public String getSubmitUrl() {
		return submitUrl;
	}

	public void setSubmitUrl(String submitUrl) {
		this.submitUrl = submitUrl;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
