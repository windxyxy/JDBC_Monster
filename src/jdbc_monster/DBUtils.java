package jdbc_monster;

import java.sql.Connection;
import java.sql.DriverManager;


/*
 * �������ݿ⹤����
 * */
public class DBUtils {
	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=JDBC_Monster";
	private static final String USER = "Monster";
	private static final String PASSWORD = "110838";
	private static Connection conn;

	// ��̬����飬����ʱ��������ִ��
	static {
		try {
			// 1���������ݿ���������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2���������ݿ�
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// �����ṩ����������������Ե����������ݿ�ķ���
	public static Connection getConnection() {
		return conn;
	}
}
