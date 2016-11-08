package actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import method.GodnessMethod;
import model.Godness;

public class GodnessAction {
	
	public static void main(String[] args) throws Exception {
		
//		queryMode();//��ѯ������¼
		
		List<Map<String, Object>> list =new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "user_name");
		map.put("relationship", "like");
		map.put("value", "'%С%'");
		list.add(map);
		map = new HashMap<>();
		map.put("name", "age");
		map.put("relationship", ">");
		map.put("value", "'24'");
		list.add(map);
		queryMode1(list);//��ѯ������¼
		
//		queryOneMode();//��ѯ������¼
//		
//		addMode();//����һ����¼
//		
//		delMode();//ɾ��һ����¼
//		
//		updateMode();//����һ����¼
		
	}
	
	/*
	 * ���Բ�ѯ����
	 * */
	public static void queryMode() throws Exception{
		GodnessMethod gm = new GodnessMethod();
		List<Godness> queryGodness = gm.queryGodness();
		for (Godness godness : queryGodness) {
			System.out.println(godness.toString());
		}
	}
	/*
	 * ���Բ�ѯ����
	 * */
	private static void queryMode1(List<Map<String, Object>> params) throws Exception{
		GodnessMethod gm = new GodnessMethod();
		List<Godness> queryGodness = gm.queryGodness1(params);
		for (Godness godness : queryGodness) {
			System.out.println(godness.toString());
		}
	}
	
	/*
	 * ���Բ�ѯһ����¼
	 * */
	private static void queryOneMode() throws Exception{
		GodnessMethod gm = new GodnessMethod();
		
		Godness gs = gm.getGodness(2);
		System.out.println(gs.toString());
	}
	
	/*
	 * �������ӹ���
	 * */
	private static void addMode() throws Exception{
		GodnessMethod gm = new GodnessMethod();
	
		Godness gs = new Godness();
		gs.setUser_name("С��");
		gs.setSex(2);
		gs.setAge(20);
		gs.setBirthday(new Date());
		gs.setMobile(1542568);
		gs.setCreate_user("Monster");
		gs.setUpdate_user("Monster");
		gs.setIsdel(2);
		
		gm.addGodness(gs);
	}
	
	/*
	 * ����ɾ������
	 * */
	private static void delMode() throws Exception {
		GodnessMethod gm = new GodnessMethod();

		gm.delGodness(5);
	}
	
	/*
	 * ���Ը��¹���
	 * */
	private static void updateMode() throws Exception{
		GodnessMethod gm = new GodnessMethod();
		
		Godness gs = new Godness();
		gs.setUser_name("С��");
		gs.setSex(2);
		gs.setAge(25);
		gs.setBirthday(new Date());
		gs.setMobile(4224562);
		gs.setCreate_user("Monster");
		gs.setUpdate_user("Monster");
		gs.setIsdel(2);
		gs.setId(4);
		
		gm.updateGodness(gs);
	}

}