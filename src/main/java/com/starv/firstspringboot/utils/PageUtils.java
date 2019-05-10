package com.starv.firstspringboot.utils;

public class PageUtils {

	private Integer cpage;//当前页
	private Integer pageSize = 3;//每页最大展示条数
	private Integer count;
	private Integer totalPage;//总页数(末页)
	private String mohu;
	private Integer prevPage;//上一页
	private Integer nextPage;//下一页
	private String url;//列表访问路径
	private Integer startIndex;
	private String page;//分页前台代码
	private String mohuPage;//模糊前台代码
	public PageUtils(Integer cpage, Integer count, String mohu, String url) {
		this.count = count;
		colTotalPage();
		if(cpage==null || cpage<1){
			cpage = 1;
		}else if(cpage>this.totalPage){
			cpage = this.totalPage;
		}
		this.url = url;
		this.cpage = cpage;
		this.mohu = mohu;
		colStartIndex();
		colPrevPage();
		colNextPage();
		setPage();
		setMohuPage();
	}
	private void colNextPage() {//计算下一页
		this.nextPage = cpage>=totalPage?totalPage:(cpage+1);
	}
	private void colPrevPage() {//计算上一页
		this.prevPage = cpage<=1?1:(cpage-1);
	}
	private void colStartIndex() {//计算起始下标
		this.startIndex = (cpage-1)*pageSize;
	}
	private void colTotalPage() {//计算总页数
		this.totalPage = count/pageSize + (count%pageSize==0?0:1);
	}
	private void setPage() {
		this.page = "<script type='text/javascript'>";
		this.page += "function goPage(cpage){";
		this.page += "var mohu = '';";
		this.page += "var target = document.getElementById('mohu');";
		this.page += "if(target!=null){";
		this.page += "mohu = document.getElementById('mohu').value;";
		this.page += "}";
		this.page += "location = '"+url+"?cpage='+cpage+'&mohu='+mohu";
		this.page += "}";
		this.page += "</script>";
		this.page += "<tr><th colspan='666'>";
		this.page += "<input type='button' value='首页' onclick='goPage(1)'/>";
		this.page += "<input type='button' value='上一页' onclick='goPage("+this.prevPage+")'/>";
		this.page += "<input type='button' value='下一页' onclick='goPage("+this.nextPage+")'/>";
		this.page += "<input type='button' value='末页' onclick='goPage("+this.totalPage+")'/>";
		this.page += "\t"+cpage+"/"+totalPage+"页"+"\t"+"共条"+count+"数据";
		this.page += "</th></tr>";
	}
	private void setMohuPage() {
		this.mohuPage = "<script type='text/javascript'>";
		this.mohuPage += "function mohu(){";
		this.mohuPage += "var mohu = document.getElementById('mohu').value;";
		this.mohuPage += "location = '"+url+"?&mohu='+mohu";
		this.mohuPage += "}";
		this.mohuPage += "</script>";
		this.mohuPage += "<tr><th colspan='666'>";
		this.mohuPage += "<input type='text' value='"+(mohu==null?"":mohu)+"' id='mohu'/>";
		this.mohuPage += "<input type='button' value='搜索' onclick='mohu()'/>";
		this.mohuPage += "</th></tr>";
	}
	public Integer getCpage() {
		return cpage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public Integer getCount() {
		return count;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public String getMohu() {
		return mohu;
	}
	public Integer getPrevPage() {
		return prevPage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public String getPage() {
		return page;
	}
	public String getMohuPage() {
		return mohuPage;
	}
}