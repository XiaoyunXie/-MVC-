package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * ��ȡ���ͷ����ݿ�����
 */
public class JDBCUtils {
	private static DataSource datasource = new ComboPooledDataSource("webDataSource");
	
	/*
	 * ��ȡ���ݿ�����
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
	 * �ͷ����ݿ�����
	 */
	public static void release(Connection con) {
		try {
			//connection����Ϊ��
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
