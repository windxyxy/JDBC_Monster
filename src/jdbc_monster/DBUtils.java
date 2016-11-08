package jdbc_monster;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author 作者 : Monster
 * @version 创建时间：2016年11月7日 下午1:47:10
 * 类说明：连接数据库工具类
 */

public class DBUtils {
	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=JDBC_Monster";
	private static final String USER = "Monster";
	private static final String PASSWORD = "110838";
	private static Connection conn;

	// 静态代码块，加载时总是优先执行
	static {
		try {
			// 1、加载数据库驱动程序
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2、连接数据库
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 对外提供方法，让其他类可以调用连接数据库的方法
	public static Connection getConnection() {
		return conn;
	}
}
