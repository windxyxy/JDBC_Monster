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
		
//		queryMode();//查询多条记录
		
		List<Map<String, Object>> list =new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "user_name");
		map.put("relationship", "like");
		map.put("value", "'%小%'");
		list.add(map);
		map = new HashMap<>();
		map.put("name", "age");
		map.put("relationship", ">");
		map.put("value", "'24'");
		list.add(map);
		queryMode1(list);//查询多条记录
		
//		queryOneMode();//查询单条记录
//		
//		addMode();//增加一条记录
//		
//		delMode();//删除一条记录
//		
//		updateMode();//更新一条记录
		
	}
	
	/*
	 * 测试查询功能
	 * */
	public static void queryMode() throws Exception{
		GodnessMethod gm = new GodnessMethod();
		List<Godness> queryGodness = gm.queryGodness();
		for (Godness godness : queryGodness) {
			System.out.println(godness.toString());
		}
	}
	/*
	 * 测试查询功能
	 * */
	private static void queryMode1(List<Map<String, Object>> params) throws Exception{
		GodnessMethod gm = new GodnessMethod();
		List<Godness> queryGodness = gm.queryGodness1(params);
		for (Godness godness : queryGodness) {
			System.out.println(godness.toString());
		}
	}
	
	/*
	 * 测试查询一条记录
	 * */
	private static void queryOneMode() throws Exception{
		GodnessMethod gm = new GodnessMethod();
		
		Godness gs = gm.getGodness(2);
		System.out.println(gs.toString());
	}
	
	/*
	 * 测试增加功能
	 * */
	private static void addMode() throws Exception{
		GodnessMethod gm = new GodnessMethod();
	
		Godness gs = new Godness();
		gs.setUser_name("小慧");
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
	 * 测试删除功能
	 * */
	private static void delMode() throws Exception {
		GodnessMethod gm = new GodnessMethod();

		gm.delGodness(5);
	}
	
	/*
	 * 测试更新功能
	 * */
	private static void updateMode() throws Exception{
		GodnessMethod gm = new GodnessMethod();
		
		Godness gs = new Godness();
		gs.setUser_name("小夏");
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