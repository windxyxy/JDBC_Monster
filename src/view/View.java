package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import actions.GodnessAction;
import model.Godness;

/**
 * @author ���� : Monster
 * @version ����ʱ�䣺2016��11��9�� ����9:47:12 ��˵�� :��ͼ��
 */
public class View {
	private static final String CONTEXT = "��ӭ����Ů�������\n" + "������Ů������Ĺ����б�\n" + "[MAIN/M]:���˵�\n" + "[QUERY/Q]:�鿴ȫ��Ů�����Ϣ\n"
			+ "[GET/G]:�鿴ĳλŮ�����ϸ��Ϣ\n" + "[ADD/A]:���Ů����Ϣ\n" + "[UPDATE/U]:����Ů����Ϣ\n" + "[DELETE/D]:ɾ��Ů����Ϣ\n"
			+ "[SEARCH/S]:��ѯŮ����Ϣ��������������������ѯ��\n" + "[EXIT/E]:�˳�Ů�����\n" + "[BREAK/B]:�˳���ǰ���ܣ��������˵�\n";

	private static final String OPERATION_MAIN = "MAIN";
	private static final String OPERATION_QUERY = "QUERY";
	private static final String OPERATION_GET = "GET";
	private static final String OPERATION_ADD = "ADD";
	private static final String OPERATION_UPDATE = "UPDATE";
	private static final String OPERATION_DELETE = "DELETE";
	private static final String OPERATION_SEARCH = "SEARCH";
	private static final String OPERATION_EXIT = "EXIT";
	private static final String OPERATION_BREAK = "BREAK";

	public static void main(String[] args) {
		System.out.println(CONTEXT);
		Scanner scan = new Scanner(System.in);// ����̨����

		GodnessAction gsAction = new GodnessAction();
		Godness godness = new Godness();
		String memory = null;// ���������Ŀ���Ǳ���סĳ������
		int step = 1;// ���裬���������е���һ��

		List<Map<String, Object>> params = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> map1 = new HashMap<>();

		while (scan.hasNext()) {// ������ֵ��ѭ����û������ֵ�Ͳ�ѭ��
			String textIn = scan.next().toString();
			if (OPERATION_EXIT.equals(textIn.toUpperCase())
					|| OPERATION_EXIT.substring(0, 1).equals(textIn.toUpperCase())) {
				System.out.println("���ѳɹ��˳�Ů�������");
				break;

			} else if (OPERATION_MAIN.equals(textIn.toUpperCase())
					|| OPERATION_MAIN.substring(0, 1).equals(textIn.toUpperCase())) {
				System.out.println(CONTEXT);

			} else if (OPERATION_QUERY.equals(textIn.toUpperCase())
					|| OPERATION_QUERY.substring(0, 1).equals(textIn.toUpperCase())) {
				try {
					List<Godness> listGod = gsAction.queryMode();
					for (Godness godness2 : listGod) {
						System.out.println("Ů��id��" + godness2.getId() + "  Ů��������" + godness2.getUser_name() + "  Ů�����䣺"
								+ godness2.getAge());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (OPERATION_GET.equals(textIn.toUpperCase())
					|| OPERATION_GET.substring(0, 1).equals(textIn.toUpperCase()) || OPERATION_GET.equals(memory)) {
				memory = OPERATION_GET;
				if (1 == step) {
					System.out.println("������Ů��id��");
					step = 2;
				} else if (2 == step) {
					try {
						godness = gsAction.queryOneMode(Integer.valueOf(textIn));
						System.out.println("Ů�����Ϣ��\n" + godness.toString() + "\n��ѯ��ɲ��������˵�");
						memory = null;
						step = 1;
					} catch (NumberFormatException e) {
						System.out.println("�����id��ʽ����ȷ������������");
						step = 2;

					} catch (NullPointerException e) {
						System.out.println("��id�Ų����ڣ�������");
						step = 2;
					} catch (Exception e) {
						System.out.println("������������������");
						step = 2;
					}
				}

			} else if (OPERATION_ADD.equals(textIn.toUpperCase())
					|| OPERATION_ADD.substring(0, 1).equals(textIn.toUpperCase()) || OPERATION_ADD.equals(memory)) {
				memory = OPERATION_ADD;
				if (1 == step) {
					System.out.println("������Ů��ġ�������");
					step = 2;
				} else if (2 == step) {
					godness.setUser_name(textIn);
					System.out.println("������Ů��ġ����䡿");
					step = 3;
				} else if (3 == step) {
					try {
						godness.setAge(Integer.valueOf(textIn));
						System.out.println("������Ů��ġ����ա�����ʽΪ��yyyy-MM-dd");
						step = 4;
					} catch (Exception e) {
						System.out.println("����ĸ�ʽ��������������");
						step = 3;
					}

				} else if (4 == step) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// ��ʽ�����ڸ�ʽ
					Date birthday = null;
					try {
						birthday = sdf.parse(textIn);
						godness.setBirthday(birthday);
						System.out.println("������Ů��ġ��绰��");
						step = 5;
					} catch (ParseException e) {
						System.out.println("����ĸ�ʽ��������������");
						step = 4;
					}

				} else if (5 == step) {
					try {
						godness.setMobile(Integer.valueOf(textIn));
						System.out.println("������Ů��ġ������ˡ�");
						step = 6;
					} catch (Exception e) {
						System.out.println("����ĸ�ʽ��������������");
						step = 5;
					}

				} else if (6 == step) {
					godness.setCreate_user(textIn);
					;
					System.out.println("������Ů��ġ������ˡ�");
					step = 7;
				} else if (7 == step) {
					try {
						godness.setUpdate_user(textIn);
						gsAction.addMode(godness);
						System.out.println("����Ů��ɹ�");
						memory = null;
						step = 1;
					} catch (Exception e) {
						System.out.println("����Ů��ʧ��");
						memory = null;
						step = 1;
					}

				}

			} else if (OPERATION_UPDATE.equals(textIn.toUpperCase())
					|| OPERATION_UPDATE.substring(0, 1).equals(textIn.toUpperCase())
					|| OPERATION_UPDATE.equals(memory)) {
				memory = OPERATION_UPDATE;
				if (1 == step) {
					System.out.println("����Ů����Ϣ,������Ů��id");
					step = 2;
				} else if (2 == step) {
					godness.setId(Integer.valueOf(textIn));
					System.out.println("���޸�Ů������");
					step = 3;
				} else if (3 == step) {
					godness.setUser_name(textIn);
					System.out.println("���޸�Ů��ġ����䡿");
					step = 4;
				} else if (4 == step) {
					try {
						godness.setAge(Integer.valueOf(textIn));
						System.out.println("���޸�Ů��ġ����ա�����ʽΪ��yyyy-MM-dd");
						step = 5;
					} catch (Exception e) {
						System.out.println("����ĸ�ʽ��������������");
						step = 4;
					}

				} else if (5 == step) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// ��ʽ�����ڸ�ʽ
					Date birthday = null;
					try {
						birthday = sdf.parse(textIn);
						godness.setBirthday(birthday);
						System.out.println("���޸�Ů��ġ��绰��");
						step = 6;
					} catch (ParseException e) {
						System.out.println("����ĸ�ʽ��������������");
						step = 5;
					}

				} else if (6 == step) {
					try {
						godness.setMobile(Integer.valueOf(textIn));
						System.out.println("���޸�Ů��ġ������ˡ�");
						step = 7;
					} catch (Exception e) {
						System.out.println("����ĸ�ʽ��������������");
						step = 6;
					}

				} else if (7 == step) {
					godness.setCreate_user(textIn);
					;
					System.out.println("���޸�Ů��ġ������ˡ�");
					step = 8;
				} else if (8 == step) {
					try {
						godness.setUpdate_user(textIn);
						gsAction.addMode(godness);
						System.out.println("�޸�Ů��ɹ�");
						memory = null;
						step = 1;
					} catch (Exception e) {
						System.out.println("�޸�Ů��ʧ��");
						memory = null;
						step = 1;
					}

				}
			} else if (OPERATION_DELETE.equals(textIn.toUpperCase())
					|| OPERATION_DELETE.substring(0, 1).equals(textIn.toUpperCase())
					|| OPERATION_DELETE.equals(memory)) {
				memory = OPERATION_DELETE;
				if (1 == step) {
					System.out.println("ɾ��Ů��������Ů��id");
					step = 2;
				} else if (2 == step) {
					try {
						gsAction.delMode(Integer.valueOf(textIn));
						System.out.println("Ů��ɾ���ɹ�");
						memory = null;
						step = 1;

					} catch (NumberFormatException e) {
						System.out.println("�����id��ʽ����ȷ������������");
						step = 2;
					} catch (NullPointerException e) {
						System.out.println("��id�Ų����ڣ�������");
						step = 2;
					} catch (Exception e) {
						System.out.println("������������������");
						step = 2;
					}
				}

			} else if (OPERATION_SEARCH.equals(textIn.toUpperCase())
					|| OPERATION_SEARCH.substring(0, 1).equals(textIn.toUpperCase())
					|| OPERATION_SEARCH.equals(memory)) {
				memory = OPERATION_SEARCH;
				if (1 == step) {
					System.out.println("��ѯŮ��������Ů������");
					step = 2;
				} else if (2 == step) {
					godness.setUser_name(textIn);
					System.out.println("������Ů�������");
					map.put("name", "user_name");
					map.put("relationship", "=");
					map.put("value", "'" + textIn + "'");
					params.add(map);
					step = 3;
				} else if (3 == step) {
					try {
						godness.setAge(Integer.valueOf(textIn));
						map1.put("name", "age");
						map1.put("relationship", "=");
						map1.put("value", textIn);
						params.add(map1);

						List<Godness> listGs = gsAction.queryMode(params);
						for (Godness godness2 : listGs) {
							if (listGs.size() <= 0) {
								System.out.println("�޲�ѯ���");
								memory = null;
								step = 1;
							} else {
								System.out.println(godness2.toString());
								memory = null;
								step = 1;
							}

						}

					} catch (Exception e) {
						System.out.println("�����ʽ��������������");
						step = 3;
					}
				}

			} else if (OPERATION_BREAK.equals(textIn.toUpperCase())
					|| OPERATION_BREAK.substring(0, 1).equals(textIn.toUpperCase())) {
				// �˹���ؽ������
				System.out.println("���޴˹���");

			}

		}

	}

}
