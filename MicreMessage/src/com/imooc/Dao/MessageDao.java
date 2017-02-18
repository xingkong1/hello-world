package com.imooc.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.imooc.bean.IMessage;
import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

public class MessageDao {

	public List<Message> queryMessageListByPage(Map<String, Object> map) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageListByPage(map);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	public List<Message> queryMessageList(String command,String description) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.find(command, description);

			return messageList;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	/*
	 * 根据条件查询条数
	 */
	public int count(Message message){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			int count = imessage.count(message);
			return count;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	/*
	 * 单条删除
	 */
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			sqlSession.delete("Message.deleteOne", id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

	}

	/*
	 * 批量删除
	 */

	public void deleteBatch(List<Integer> list) {

		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			sqlSession.delete("Message.deleteBatch", list);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

	}

	/*
	 * 添加单条数据
	 */
	public void add(Message message) {
		DBAccess dbAccess = new DBAccess();
		SqlSession session = null;
		try {
			session = dbAccess.getSqlSession();
			session.insert("Message.add", message);
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	/*
	 * 根据条件查询
	 */
	public String query(String command) {
		DBAccess dbAccess = new DBAccess();
		SqlSession session = null;
		try {
			session = dbAccess.getSqlSession();
			String content = session.selectOne("Message.query", command);
			session.commit();
			return content;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	/*
	 * //根据查询条件查询列表 public List<Message> queryMessageList(String command,String
	 * description) throws Exception{ Class.forName("com.mysql.jdbc.Driver");
	 * Connection conn=DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/test?useSSL=true","root","1234");
	 * StringBuilder sql=new
	 * StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1"
	 * ) ; List<String> paramList=new ArrayList<String>(); if(command!=null
	 * &&!"".equals(command.trim())){ sql.append(" and command=?");
	 * paramList.add(command); } if(description!=null
	 * &&!"".equals(description.trim())){
	 * sql.append(" and description like '%' ? '%'");
	 * paramList.add(description); } PreparedStatement
	 * statement=conn.prepareStatement(sql.toString()); if(paramList.size()>0){
	 * for(int i=0;i<paramList.size();i++){ statement.setString(i+1,
	 * paramList.get(i)); } } ResultSet rs=statement.executeQuery();
	 * List<Message> messageList=new ArrayList<Message>(); while(rs.next()){
	 * Message message=new Message(); message.setId(rs.getString("id"));
	 * message.setCommand(rs.getString("command"));
	 * message.setDescription(rs.getString("description"));
	 * message.setContent(rs.getString("content")); messageList.add(message); }
	 * return messageList; }
	 */

	public static void main(String[] args) {
		new MessageDao().queryMessageList("", "");

	}
}
