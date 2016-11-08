package actions;

import java.util.Date;
import java.util.List;

import method.GodnessMethod;
import model.Godness;

public class GodnessAction {
	
	public static void main(String[] args) throws Exception {
		
		queryMode();//��ѯ������¼
		
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
	private static void queryMode() throws Exception{
		GodnessMethod gm = new GodnessMethod();
		List<Godness> queryGodness = gm.queryGodness();
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