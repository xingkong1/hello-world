package com.imooc.bean;

import java.util.List;
import java.util.Map;

/*
 * 与MESSAGE配置文件相对应的接口
 */
public interface IMessage {

	public List<Message> queryMessageList(Map<String, Object> map);
	public List<Message> find(String command,String description);
	public int count(Message message);
	public List<Message> queryMessageListByPage(Map<String, Object> map);
}
