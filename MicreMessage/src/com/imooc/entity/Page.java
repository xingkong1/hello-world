package com.imooc.entity;

/*
 * ��ҳ��Ӧ��ʵ����
 */
public class Page {

	/*
	 * ������
	 */
	private int totalNumber;
	/*
	 * ��ǰ�ڼ�ҳ
	 */
	private int currentPage;
	/*
	 * ��ҳ��
	 */
	private int totalPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/*
	 * ÿҳ��ʾ����
	 */
	private int pageNumber = 5;
	/*
	 * ���ݿ��е�limit�Ĳ������ӵڼ�����ʼ
	 */
	private int dbIndex;
	/*
	 * ���ݿ��е�limit�Ĳ�����һ��ȡ������
	 */
	private int dbNumber;

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getDbIndex() {
		return dbIndex;
	}

	public void setDbIndex(int dbindex) {
		this.dbIndex = dbindex;
	}

	public int getDbNumber() {
		return dbNumber;
	}

	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}

	/*
	 * ���ݵ�ǰ����������ֵ���㲢�����������ֵ
	 */
	public void count(){
		//������ҳ��
		int totalPageTemp=this.totalNumber/this.pageNumber;
		int plus=(this.totalNumber%this.pageNumber)==0?0:1;
		totalPageTemp=totalPageTemp+plus;
		if(totalPageTemp<=0){
			totalPageTemp=1;
		}
		this.totalPage=totalPageTemp;
		
		//��ǰҳ��
		//��ҳ��С�ڵ�ǰҳ����Ӧ����ǰҳ������Ϊ��ҳ��
		if(this.totalPage<this.currentPage){
			this.currentPage=this.totalPage;
		}
		//��ǰҳ��С��1����Ϊ1
		if(this.currentPage<1){
			this.currentPage=1;
		}
		
		//����limit�Ĳ���
		//this.dbIndex=(this.currentPage-1)*this.pageNumber;
		this.dbIndex=(this.currentPage-1)*this.pageNumber;
		this.dbNumber=this.pageNumber;
		
	}
}
