package com.imooc.bean;

import java.util.List;
import java.util.Map;

/*
 * ��MESSAGE�����ļ����Ӧ�Ľӿ�
 */
public interface IMessage {

	public List<Message> queryMessageList(Map<String, Object> map);
	public List<Message> find(String command,String description);
	public int count(Message message);
	public List<Message> queryMessageListByPage(Map<String, Object> map);
}
