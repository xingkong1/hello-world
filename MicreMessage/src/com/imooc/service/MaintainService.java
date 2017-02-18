package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.Dao.MessageDao;

/*
 * 维护
 */
public class MaintainService {

	/*
	 * 单条删除
	 */
	public void deleteOne(String id){
		if(id!=null&&!"".equals(id)){
		MessageDao messageDao=new MessageDao();
		messageDao.deleteOne(Integer.valueOf(id));
		}
	}
	
	/*
	 * 批量删除
	 */
	public void deleteBatch(String[] list){
		
		if(list!=null&&list.length>0){
			List<Integer> list2=new ArrayList<>();
			for(String id:list){
				list2.add(Integer.valueOf(id));
			}
			MessageDao messageDao=new MessageDao();
			messageDao.deleteBatch(list2);
		}
	}
}
