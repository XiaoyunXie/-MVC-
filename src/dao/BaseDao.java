package dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utils.JDBCUtils;

/**
 * 数据库基本操作的封装
 * @author 11361
 * @param <T>
 */
public class BaseDao<T> {
	//Apache Commons DbUtils -- QueryRunner
	private QueryRunner runner = new QueryRunner();
	private Class<T> type;
	
	/*
	 * 获取泛型类型值T
	 */
	public BaseDao() {
		ParameterizedType superClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		type = (Class<T>) superClass.getActualTypeArguments()[0];
		System.out.println(type);
		
	}
	/*
	 * 获取一个对象
	 */
	public T getBean(String sql,Object...params) {
		Connection con = JDBCUtils.getConnection();
		T query = null;
		try {
			query = runner.query(con, sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(con);
		}
		return query;
	}
	
	/*
	 * 获取对象的集合
	 */
	public List<T> getBeans(String sql,Object...params){
		Connection con = JDBCUtils.getConnection();
		List<T> query = null;
		try {
			query = runner.query(con, sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(con);
		}
		return query;
	}
	/*
	 * 执行增删改
	 */
	public int update(String sql,Object...params) {
		int count = 0;
		Connection con = JDBCUtils.getConnection();
		try {
			count = runner.update(con, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(con);
		}
		return count;
	}
	
	/**
	 * 查询单个值
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object getSingleValue(String sql,Object...params) {
		Object query = null;
		Connection con = JDBCUtils.getConnection();
		try {
			query = runner.query(con, sql, new ScalarHandler(),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(con);
		}
		return query;
	}
	
	/**
	 * 批量执行sql的方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public int batch(String sql,Object[][] params) {
		Connection connection = JDBCUtils.getConnection();
		try {
			runner.batch(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(connection);
		}
		return 0;
	}
}
