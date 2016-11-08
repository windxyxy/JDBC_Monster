package method;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jdbc_monster.DBUtils;
import model.Godness;

public class GodnessMethod {
	/*
	 * 新增
	 */
	public void addGodness(Godness godness) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String SQL = "insert into godness (user_name,sex,age,mobile,birthday,create_user,"
				+ "create_date,update_user,update_date,isdel)" + "values(?,?,?,?,?,?,GETDATE(),?,GETDATE(),?)";
		PreparedStatement ppst = conn.prepareStatement(SQL);// 预执行SQL语句

		ppst.setString(1, godness.getUser_name());
		ppst.setInt(2, godness.getSex());
		ppst.setInt(3, godness.getAge());
		ppst.setInt(4, godness.getMobile());
		/*
		 * 这样写会报错：因为setDate()是需要传入java.sql.date类型的值，
		 * 而这里传入的birthday是java.util.Date,所以需要进行如下的转型
		 */
		// ppst.setDate(5, godness.getBirthday());
		ppst.setDate(5, new Date(godness.getBirthday().getTime()));
		ppst.setString(6, godness.getCreate_user());
		ppst.setString(7, godness.getUpdate_user());
		ppst.setInt(8, godness.getIsdel());

		ppst.execute();// 真正的执行SQL语句(增删改，没有查)
	}

	/*
	 * 删除
	 */
	public void delGodness(Integer id) throws Exception {// 由于是根据id删除对象，所以这里只需要传进来一个id参数就可以了
		Connection conn = DBUtils.getConnection();
		String SQL = "delete from godness where id=?";
		PreparedStatement ppst = conn.prepareStatement(SQL);// 预执行SQL语句

		ppst.setInt(1, id);
		ppst.execute();// 真正的执行SQL语句(增删改，没有查)
	}

	/*
	 * 修改
	 */
	public void updateGodness(Godness godness) throws Exception {
		Connection conn = DBUtils.getConnection();
		String SQL = "update godness set user_name=?,sex=?,age=?,mobile=?,birthday=?,"
				+ "update_user=?,update_date=GETDATE(),isdel=? where id=?";

		PreparedStatement ppst = conn.prepareStatement(SQL);// 预执行SQL语句

		ppst.setString(1, godness.getUser_name());
		ppst.setInt(2, godness.getSex());
		ppst.setInt(3, godness.getAge());
		ppst.setInt(4, godness.getMobile());
		/*
		 * 这样写会报错：因为setDate()是需要传入java.sql.date类型的值，
		 * 而这里传入的birthday是java.util.Date,所以需要进行如下的转型
		 */
		// ppst.setDate(5, godness.getBirthday());
		ppst.setDate(5, new Date(godness.getBirthday().getTime()));
		ppst.setString(6, godness.getUpdate_user());
		ppst.setInt(7, godness.getIsdel());
		ppst.setInt(8, godness.getId());

		ppst.execute();// 真正的执行SQL语句(增删改，没有查)
	}

	/*
	 * 查询(多条记录)
	 */
	public List<Godness> queryGodness() throws Exception {
		Connection conn = DBUtils.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from godness");
		PreparedStatement ppst = conn.prepareStatement(sb.toString());
		ResultSet result = ppst.executeQuery();
		
		List<Godness> listGod = new ArrayList<>();
		Godness godness = null;
		while (result.next()) {
			godness = new Godness();
			godness.setId(result.getInt("id"));
			godness.setUser_name(result.getString("user_name"));
			godness.setAge(result.getInt("age"));
			godness.setSex(result.getInt("sex"));
			godness.setMobile(result.getInt("mobile"));
			godness.setBirthday(result.getDate("birthday"));
			godness.setCreate_user(result.getString("create_user"));
			godness.setCreate_date(result.getDate("create_date"));
			godness.setUpdate_user(result.getString("update_user"));
			godness.setUpdate_date(result.getDate("update_date"));
			godness.setIsdel(result.getInt("isdel"));
			listGod.add(godness);
		}

		return listGod;
	}
	
	/*
	 * 查询(条件查询多条记录)
	 */
	public List<Godness> queryGodness1(List<Map<String, Object>> params) throws Exception {
		Connection conn = DBUtils.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from godness where 1=1 ");
		if(params != null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map = params.get(i);
				/*
				 * 这相当于是    user_name = 小美(name,relationship,value分别对应)
				 * */
				sb.append("and"+" "+map.get("name")+" "+map.get("relationship")+" "+map.get("value")+" ");
			}
		}
		System.out.println("SQL语句："+sb.toString());//打印查询语句
		
		PreparedStatement ppst = conn.prepareStatement(sb.toString());
		ResultSet result = ppst.executeQuery();
		
		List<Godness> listGod = new ArrayList<>();
		Godness godness = null;
		while (result.next()) {
			godness = new Godness();
			godness.setId(result.getInt("id"));
			godness.setUser_name(result.getString("user_name"));
			godness.setAge(result.getInt("age"));
			godness.setSex(result.getInt("sex"));
			godness.setMobile(result.getInt("mobile"));
			godness.setBirthday(result.getDate("birthday"));
			godness.setCreate_user(result.getString("create_user"));
			godness.setCreate_date(result.getDate("create_date"));
			godness.setUpdate_user(result.getString("update_user"));
			godness.setUpdate_date(result.getDate("update_date"));
			godness.setIsdel(result.getInt("isdel"));
			listGod.add(godness);
		}

		return listGod;
	}

	/*
	 * 查询(单条记录)
	 */
	public Godness getGodness(Integer id) throws Exception {// 如果根据id来查一条记录的信息，就传一个参数就可以了
		Godness godness = null;
		Connection conn = DBUtils.getConnection();
		String SQL = "select * from godness where id=?";

		PreparedStatement ppst = conn.prepareStatement(SQL);// 预执行SQL语句
		ppst.setInt(1, id);
		ResultSet rs = ppst.executeQuery();// 真正的执行SQL语句
		while(rs.next()){
			godness = new Godness();
			
			godness.setId(rs.getInt("id"));
			godness.setUser_name(rs.getString("user_name"));
			godness.setSex(rs.getInt("sex"));
			godness.setAge(rs.getInt("age"));
			/*
			 * 这里的setBirthday()是java.util.Date类型
			 * 而rs.getDate()接收的是java.sql.Date
			 * 但是在这里，util.date是sql.Date的父类，不需要转型
			 * */
			godness.setBirthday(rs.getDate("birthday"));
			godness.setMobile(rs.getInt("mobile"));
			godness.setCreate_user(rs.getString("create_user"));
			godness.setCreate_date(rs.getDate("create_date"));
			godness.setUpdate_user(rs.getString("update_user"));
			godness.setUpdate_date(rs.getDate("update_date"));
			godness.setIsdel(rs.getInt("isdel"));
			
		}
		return godness;
	}

}
