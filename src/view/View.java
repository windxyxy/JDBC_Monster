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
 * @author 作者 : Monster
 * @version 创建时间：2016年11月9日 上午9:47:12 类说明 :视图层
 */
public class View {
	private static final String CONTEXT = "欢迎来到女神禁区：\n" + "下面是女神禁区的功能列表：\n" + "[MAIN/M]:主菜单\n" + "[QUERY/Q]:查看全部女神的信息\n"
			+ "[GET/G]:查看某位女神的详细信息\n" + "[ADD/A]:添加女神信息\n" + "[UPDATE/U]:更新女神信息\n" + "[DELETE/D]:删除女神信息\n"
			+ "[SEARCH/S]:查询女神信息（根据姓名、年龄来查询）\n" + "[EXIT/E]:退出女神禁区\n" + "[BREAK/B]:退出当前功能，返回主菜单\n";

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
		Scanner scan = new Scanner(System.in);// 控制台输入

		GodnessAction gsAction = new GodnessAction();
		Godness godness = new Godness();
		String memory = null;// 记忆变量，目的是保存住某个进度
		int step = 1;// 步骤，标记输入进行到哪一步

		List<Map<String, Object>> params = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> map1 = new HashMap<>();

		while (scan.hasNext()) {// 有输入值就循环，没有输入值就不循环
			String textIn = scan.next().toString();
			if (OPERATION_EXIT.equals(textIn.toUpperCase())
					|| OPERATION_EXIT.substring(0, 1).equals(textIn.toUpperCase())) {
				System.out.println("你已成功退出女神禁区！");
				break;

			} else if (OPERATION_MAIN.equals(textIn.toUpperCase())
					|| OPERATION_MAIN.substring(0, 1).equals(textIn.toUpperCase())) {
				System.out.println(CONTEXT);

			} else if (OPERATION_QUERY.equals(textIn.toUpperCase())
					|| OPERATION_QUERY.substring(0, 1).equals(textIn.toUpperCase())) {
				try {
					List<Godness> listGod = gsAction.queryMode();
					for (Godness godness2 : listGod) {
						System.out.println("女神id：" + godness2.getId() + "  女神姓名：" + godness2.getUser_name() + "  女神年龄："
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
					System.out.println("请输入女神id号");
					step = 2;
				} else if (2 == step) {
					try {
						godness = gsAction.queryOneMode(Integer.valueOf(textIn));
						System.out.println("女神的信息：\n" + godness.toString() + "\n查询完成并返回主菜单");
						memory = null;
						step = 1;
					} catch (NumberFormatException e) {
						System.out.println("输入的id格式不正确，请重新输入");
						step = 2;

					} catch (NullPointerException e) {
						System.out.println("此id号不存在，请重新");
						step = 2;
					} catch (Exception e) {
						System.out.println("输入有误，请重新输入");
						step = 2;
					}
				}

			} else if (OPERATION_ADD.equals(textIn.toUpperCase())
					|| OPERATION_ADD.substring(0, 1).equals(textIn.toUpperCase()) || OPERATION_ADD.equals(memory)) {
				memory = OPERATION_ADD;
				if (1 == step) {
					System.out.println("请输入女神的【姓名】");
					step = 2;
				} else if (2 == step) {
					godness.setUser_name(textIn);
					System.out.println("请输入女神的【年龄】");
					step = 3;
				} else if (3 == step) {
					try {
						godness.setAge(Integer.valueOf(textIn));
						System.out.println("请输入女神的【生日】，格式为：yyyy-MM-dd");
						step = 4;
					} catch (Exception e) {
						System.out.println("输入的格式有误，请重新输入");
						step = 3;
					}

				} else if (4 == step) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化日期格式
					Date birthday = null;
					try {
						birthday = sdf.parse(textIn);
						godness.setBirthday(birthday);
						System.out.println("请输入女神的【电话】");
						step = 5;
					} catch (ParseException e) {
						System.out.println("输入的格式有误，请重新输入");
						step = 4;
					}

				} else if (5 == step) {
					try {
						godness.setMobile(Integer.valueOf(textIn));
						System.out.println("请输入女神的【创建人】");
						step = 6;
					} catch (Exception e) {
						System.out.println("输入的格式有误，请重新输入");
						step = 5;
					}

				} else if (6 == step) {
					godness.setCreate_user(textIn);
					;
					System.out.println("请输入女神的【更新人】");
					step = 7;
				} else if (7 == step) {
					try {
						godness.setUpdate_user(textIn);
						gsAction.addMode(godness);
						System.out.println("新增女神成功");
						memory = null;
						step = 1;
					} catch (Exception e) {
						System.out.println("新增女神失败");
						memory = null;
						step = 1;
					}

				}

			} else if (OPERATION_UPDATE.equals(textIn.toUpperCase())
					|| OPERATION_UPDATE.substring(0, 1).equals(textIn.toUpperCase())
					|| OPERATION_UPDATE.equals(memory)) {
				memory = OPERATION_UPDATE;
				if (1 == step) {
					System.out.println("更新女神信息,请输入女神id");
					step = 2;
				} else if (2 == step) {
					godness.setId(Integer.valueOf(textIn));
					System.out.println("请修改女神姓名");
					step = 3;
				} else if (3 == step) {
					godness.setUser_name(textIn);
					System.out.println("请修改女神的【年龄】");
					step = 4;
				} else if (4 == step) {
					try {
						godness.setAge(Integer.valueOf(textIn));
						System.out.println("请修改女神的【生日】，格式为：yyyy-MM-dd");
						step = 5;
					} catch (Exception e) {
						System.out.println("输入的格式有误，请重新输入");
						step = 4;
					}

				} else if (5 == step) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化日期格式
					Date birthday = null;
					try {
						birthday = sdf.parse(textIn);
						godness.setBirthday(birthday);
						System.out.println("请修改女神的【电话】");
						step = 6;
					} catch (ParseException e) {
						System.out.println("输入的格式有误，请重新输入");
						step = 5;
					}

				} else if (6 == step) {
					try {
						godness.setMobile(Integer.valueOf(textIn));
						System.out.println("请修改女神的【创建人】");
						step = 7;
					} catch (Exception e) {
						System.out.println("输入的格式有误，请重新输入");
						step = 6;
					}

				} else if (7 == step) {
					godness.setCreate_user(textIn);
					;
					System.out.println("请修改女神的【更新人】");
					step = 8;
				} else if (8 == step) {
					try {
						godness.setUpdate_user(textIn);
						gsAction.addMode(godness);
						System.out.println("修改女神成功");
						memory = null;
						step = 1;
					} catch (Exception e) {
						System.out.println("修改女神失败");
						memory = null;
						step = 1;
					}

				}
			} else if (OPERATION_DELETE.equals(textIn.toUpperCase())
					|| OPERATION_DELETE.substring(0, 1).equals(textIn.toUpperCase())
					|| OPERATION_DELETE.equals(memory)) {
				memory = OPERATION_DELETE;
				if (1 == step) {
					System.out.println("删除女神，请输入女神id");
					step = 2;
				} else if (2 == step) {
					try {
						gsAction.delMode(Integer.valueOf(textIn));
						System.out.println("女神删除成功");
						memory = null;
						step = 1;

					} catch (NumberFormatException e) {
						System.out.println("输入的id格式不正确，请重新输入");
						step = 2;
					} catch (NullPointerException e) {
						System.out.println("此id号不存在，请重新");
						step = 2;
					} catch (Exception e) {
						System.out.println("输入有误，请重新输入");
						step = 2;
					}
				}

			} else if (OPERATION_SEARCH.equals(textIn.toUpperCase())
					|| OPERATION_SEARCH.substring(0, 1).equals(textIn.toUpperCase())
					|| OPERATION_SEARCH.equals(memory)) {
				memory = OPERATION_SEARCH;
				if (1 == step) {
					System.out.println("查询女神，请输入女神姓名");
					step = 2;
				} else if (2 == step) {
					godness.setUser_name(textIn);
					System.out.println("请输入女神的年龄");
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
								System.out.println("无查询结果");
								memory = null;
								step = 1;
							} else {
								System.out.println(godness2.toString());
								memory = null;
								step = 1;
							}

						}

					} catch (Exception e) {
						System.out.println("年龄格式有误，请重新输入");
						step = 3;
					}
				}

			} else if (OPERATION_BREAK.equals(textIn.toUpperCase())
					|| OPERATION_BREAK.substring(0, 1).equals(textIn.toUpperCase())) {
				// 此功能亟待完善
				System.out.println("暂无此功能");

			}

		}

	}

}
