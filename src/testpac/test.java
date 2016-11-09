package testpac;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import actions.GodnessAction;
import model.Godness;

/**
 * @author ���� : Monster
 * @version ����ʱ�䣺2016��11��8�� ����5:47:57 ��˵�� :��д������
 */
public class test {

	public static void main(String[] args) throws Exception {
		GodnessAction gsAction = new GodnessAction();

		/*
		 * ��ѯ���޲β�ѯ��
		 */
		List<Godness> listGod = gsAction.queryMode();
		for (Godness godness : listGod) {
			System.out.println(godness.getUser_name() + "\n" + godness.getBirthday());
		}
		/*
		 * �вβ�ѯ
		 */
		List<Map<String, Object>> param = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "user_name");
		map.put("relationship", "like");
		map.put("value", "'%С%'");
		param.add(map);
		Map<String, Object> map1 = new HashMap<>();
		map1.put("name", "age");
		map1.put("relationship", "=");
		map1.put("value", "25");
		param.add(map1);
		
		List<Godness> lists = gsAction.queryMode(param);
		for (Godness godness : lists) {
			System.out.println(godness.getUser_name()+"\n"+godness.getMobile());
		}
		
		/*
		 * id������ѯ
		 * */
		Godness godness3 = new Godness();
		godness3 = gsAction.queryOneMode(3);
		System.out.println(godness3.toString());
		
		/*
		 * ����
		 */
		 Godness godness = new Godness();
		 godness.setUser_name("С��");
		 godness.setAge(0);
		 godness.setBirthday(new Date());
		 godness.setMobile(5426548);
		 godness.setCreate_date(new Date());
		 godness.setCreate_user("Monster");
		 godness.setUpdate_user("Monster");
		 godness.setUpdate_date(new Date());
		 godness.setId(6);
		 gsAction.addMode(godness);

		/*
		 * ����
		 */
		 Godness godness1 = new Godness();
		 godness1.setUser_name("С����");
		 godness1.setSex(2);
		 godness1.setAge(0);
		 godness1.setBirthday(new Date());
		 godness1.setMobile(5426548);
		 godness1.setUpdate_user("Monster");
		 godness1.setUpdate_date(new Date());
		 godness1.setIsdel(2);
		 godness1.setId(6);
		 gsAction.updateMode(godness1);
		/*
		 * ɾ��
		 */
		gsAction.delMode(6);
	}

}
