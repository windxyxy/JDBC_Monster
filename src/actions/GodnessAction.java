package actions;

import java.util.List;
import java.util.Map;

import method.GodnessMethod;
import model.Godness;
/**
 * @author ���� : Monster
 * @version ����ʱ�䣺2016��11��7�� ����4:25:42
 * ��˵�������Ʋ㣨�����ṩ�������ã�
 */

public class GodnessAction {

	/*
	 * ��ѯ����
	 */
	public List<Godness> queryMode() throws Exception {
		GodnessMethod gm = new GodnessMethod();
		return gm.queryGodness();

	}

	/*
	 * ��ѯ���ܣ�������ѯ��
	 */
	public List<Godness> queryMode(List<Map<String, Object>> params) throws Exception {
		GodnessMethod gm = new GodnessMethod();
		return gm.queryGodness(params);

	}

	/*
	 * ��ѯһ����¼
	 */
	public Godness queryOneMode(Integer id) throws Exception {
		GodnessMethod gm = new GodnessMethod();
		return gm.getGodness(id);

	}

	/*
	 * ���ӹ���
	 */
	public void addMode(Godness godness) throws Exception {
		GodnessMethod gm = new GodnessMethod();

		gm.addGodness(godness);

	}

	/*
	 * ɾ������
	 */
	public void delMode(Integer id) throws Exception {
		GodnessMethod gm = new GodnessMethod();

		gm.delGodness(id);
	}

	/*
	 * ���¹���
	 */
	public void updateMode(Godness godness) throws Exception {
		GodnessMethod gm = new GodnessMethod();
		gm.updateGodness(godness);

	}

}