package com.imooc.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.imooc.entity.Page;


/**
 * ��ҳ������
 *
 */
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class PageInterceptor implements Interceptor{

	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler=(StatementHandler)invocation.getTarget();
		MetaObject metaObject=SystemMetaObject.forObject(statementHandler);
		MappedStatement mappedStatement=(MappedStatement)metaObject.getValue("delegate.mappedStatement");
		String id=mappedStatement.getId();
		if(id.matches(".+ByPage$")){
			BoundSql boundSql=statementHandler.getBoundSql();
			String sql=boundSql.getSql();
			String countSql="select count(*) from ("+sql+")a";
			Connection connection=(Connection)invocation.getArgs()[0];
			PreparedStatement preparedStatement=connection.prepareStatement(countSql);
			ParameterHandler parameterHandler=(ParameterHandler)metaObject.getValue("delegate.parameterHandler");
			parameterHandler.setParameters(preparedStatement);
			ResultSet rs=preparedStatement.executeQuery();
			
			Map<String, Object> parameter=(Map<String, Object>)boundSql.getParameterObject();
			Page page=(Page)parameter.get("page");
			if(rs.next()){
				page.setTotalNumber(rs.getInt(1));
				
			}
			String pageSql=sql+" limit "+page.getDbIndex()+","+page.getDbNumber();
			metaObject.setValue("delegate.boundSql.sql", pageSql);
			
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return Plugin.wrap(target,this);
	}

	@Override
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		
	}

}
