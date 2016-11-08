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
	 * ����
	 */
	public void addGodness(Godness godness) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String SQL = "insert into godness (user_name,sex,age,mobile,birthday,create_user,"
				+ "create_date,update_user,update_date,isdel)" + "values(?,?,?,?,?,?,GETDATE(),?,GETDATE(),?)";
		PreparedStatement ppst = conn.prepareStatement(SQL);// Ԥִ��SQL���

		ppst.setString(1, godness.getUser_name());
		ppst.setInt(2, godness.getSex());
		ppst.setInt(3, godness.getAge());
		ppst.setInt(4, godness.getMobile());
		/*
		 * ����д�ᱨ����ΪsetDate()����Ҫ����java.sql.date���͵�ֵ��
		 * �����ﴫ���birthday��java.util.Date,������Ҫ�������µ�ת��
		 */
		// ppst.setDate(5, godness.getBirthday());
		ppst.setDate(5, new Date(godness.getBirthday().getTime()));
		ppst.setString(6, godness.getCreate_user());
		ppst.setString(7, godness.getUpdate_user());
		ppst.setInt(8, godness.getIsdel());

		ppst.execute();// ������ִ��SQL���(��ɾ�ģ�û�в�)
	}

	/*
	 * ɾ��
	 */
	public void delGodness(Integer id) throws Exception {// �����Ǹ���idɾ��������������ֻ��Ҫ������һ��id�����Ϳ�����
		Connection conn = DBUtils.getConnection();
		String SQL = "delete from godness where id=?";
		PreparedStatement ppst = conn.prepareStatement(SQL);// Ԥִ��SQL���

		ppst.setInt(1, id);
		ppst.execute();// ������ִ��SQL���(��ɾ�ģ�û�в�)
	}

	/*
	 * �޸�
	 */
	public void updateGodness(Godness godness) throws Exception {
		Connection conn = DBUtils.getConnection();
		String SQL = "update godness set user_name=?,sex=?,age=?,mobile=?,birthday=?,"
				+ "update_user=?,update_date=GETDATE(),isdel=? where id=?";

		PreparedStatement ppst = conn.prepareStatement(SQL);// Ԥִ��SQL���

		ppst.setString(1, godness.getUser_name());
		ppst.setInt(2, godness.getSex());
		ppst.setInt(3, godness.getAge());
		ppst.setInt(4, godness.getMobile());
		/*
		 * ����д�ᱨ����ΪsetDate()����Ҫ����java.sql.date���͵�ֵ��
		 * �����ﴫ���birthday��java.util.Date,������Ҫ�������µ�ת��
		 */
		// ppst.setDate(5, godness.getBirthday());
		ppst.setDate(5, new Date(godness.getBirthday().getTime()));
		ppst.setString(6, godness.getUpdate_user());
		ppst.setInt(7, godness.getIsdel());
		ppst.setInt(8, godness.getId());

		ppst.execute();// ������ִ��SQL���(��ɾ�ģ�û�в�)
	}

	/*
	 * ��ѯ(������¼)
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
	 * ��ѯ(������ѯ������¼)
	 */
	public List<Godness> queryGodness1(List<Map<String, Object>> params) throws Exception {
		Connection conn = DBUtils.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from godness where 1=1 ");
		if(params != null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map = params.get(i);
				/*
				 * ���൱����    user_name = С��(name,relationship,value�ֱ��Ӧ)
				 * */
				sb.append("and"+" "+map.get("name")+" "+map.get("relationship")+" "+map.get("value")+" ");
			}
		}
		System.out.println("SQL��䣺"+sb.toString());//��ӡ��ѯ���
		
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
	 * ��ѯ(������¼)
	 */
	public Godness getGodness(Integer id) throws Exception {// �������id����һ����¼����Ϣ���ʹ�һ�������Ϳ�����
		Godness godness = null;
		Connection conn = DBUtils.getConnection();
		String SQL = "select * from godness where id=?";

		PreparedStatement ppst = conn.prepareStatement(SQL);// Ԥִ��SQL���
		ppst.setInt(1, id);
		ResultSet rs = ppst.executeQuery();// ������ִ��SQL���
		while(rs.next()){
			godness = new Godness();
			
			godness.setId(rs.getInt("id"));
			godness.setUser_name(rs.getString("user_name"));
			godness.setSex(rs.getInt("sex"));
			godness.setAge(rs.getInt("age"));
			/*
			 * �����setBirthday()��java.util.Date����
			 * ��rs.getDate()���յ���java.sql.Date
			 * ���������util.date��sql.Date�ĸ��࣬����Ҫת��
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
