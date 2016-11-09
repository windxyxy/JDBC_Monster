package testpac;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import actions.GodnessAction;
import model.Godness;

/**
 * @author 作者 : Monster
 * @version 创建时间：2016年11月8日 下午5:47:57 类说明 :编写测试类
 */
public class test {

	public static void main(String[] args) throws Exception {
		GodnessAction gsAction = new GodnessAction();

		/*
		 * 查询（无参查询）
		 */
		List<Godness> listGod = gsAction.queryMode();
		for (Godness godness : listGod) {
			System.out.println(godness.getUser_name() + "\n" + godness.getBirthday());
		}
		/*
		 * 有参查询
		 */
		List<Map<String, Object>> param = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "user_name");
		map.put("relationship", "like");
		map.put("value", "'%小%'");
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
		 * id单个查询
		 * */
		Godness godness3 = new Godness();
		godness3 = gsAction.queryOneMode(3);
		System.out.println(godness3.toString());
		
		/*
		 * 新增
		 */
		 Godness godness = new Godness();
		 godness.setUser_name("小青");
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
		 * 更新
		 */
		 Godness godness1 = new Godness();
		 godness1.setUser_name("小青青");
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
		 * 删除
		 */
		gsAction.delMode(6);
	}

}
