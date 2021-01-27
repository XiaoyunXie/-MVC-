package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * 获取和释放数据库连接
 */
public class JDBCUtils {
	private static DataSource datasource = new ComboPooledDataSource("webDataSource");
	
	/*
	 * 获取数据库连接
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/*
	 * 释放数据库连接
	 */
	public static void release(Connection con) {
		try {
			//connection可能为空
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
