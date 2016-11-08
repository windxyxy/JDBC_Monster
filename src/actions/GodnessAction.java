package actions;

import java.util.List;
import java.util.Map;

import method.GodnessMethod;
import model.Godness;
/**
 * @author 作者 : Monster
 * @version 创建时间：2016年11月7日 下午4:25:42
 * 类说明：控制层（对外提供方法调用）
 */

public class GodnessAction {

	/*
	 * 查询功能
	 */
	public List<Godness> queryMode() throws Exception {
		GodnessMethod gm = new GodnessMethod();
		return gm.queryGodness();

	}

	/*
	 * 查询功能（条件查询）
	 */
	public List<Godness> queryMode(List<Map<String, Object>> params) throws Exception {
		GodnessMethod gm = new GodnessMethod();
		return gm.queryGodness(params);

	}

	/*
	 * 查询一条记录
	 */
	public Godness queryOneMode(Integer id) throws Exception {
		GodnessMethod gm = new GodnessMethod();
		return gm.getGodness(id);

	}

	/*
	 * 增加功能
	 */
	public void addMode(Godness godness) throws Exception {
		GodnessMethod gm = new GodnessMethod();

		gm.addGodness(godness);

	}

	/*
	 * 删除功能
	 */
	public void delMode(Integer id) throws Exception {
		GodnessMethod gm = new GodnessMethod();

		gm.delGodness(id);
	}

	/*
	 * 更新功能
	 */
	public void updateMode(Godness godness) throws Exception {
		GodnessMethod gm = new GodnessMethod();
		gm.updateGodness(godness);

	}

}