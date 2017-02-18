package com.imooc.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imooc.Dao.MessageDao;
import com.imooc.bean.Message;
import com.imooc.entity.Page;

public class QueryService {

	public String queryByCommand(String command){
		
		if(command!=null&&!"".equals(command)){
		MessageDao messageDao=new MessageDao();
		List<Message> list=messageDao.queryMessageList(command, "");
		if(list.size()>0){
		return list.get(0).getContent();
		}else{
			return "����û�������";
		}
		}
		return "��Ҫ������ҵ����ݰ���";
	}
	
	public List<Message>  queryMessageList(String command,String description,Page page){
		MessageDao messageDao=new MessageDao();
		Message message=new Message();
		message.setCommand(command);
		message.setDescription(description);
		int totalNumber=messageDao.count(message);
		page.setTotalNumber(totalNumber);
		page.count();
		Map<String,Object> parameter=new HashMap<String,Object>();
		parameter.put("message", message);
		parameter.put("page", page);
		return messageDao.queryMessageListByPage(parameter);
	}
}
