package model;

import java.util.Date;

/**
 * @author 作者 : Monster
 * @version 创建时间：2016年11月7日 下午2:12:12
 * 类说明：实体类
 */
public class Godness {
	private Integer id;
	private String user_name;
	private Integer age;
	private Integer sex;
	private Integer mobile;
	private Date birthday;
	private String create_user;
	private Date create_date;
	private String update_user;
	private Date update_date;
	private Integer isdel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Integer getIsdel() {
		return isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

	@Override
	public String toString() {
		return "Godness [id=" + id + ", user_name=" + user_name + ", age=" + age + ", sex=" + sex + ", mobile=" + mobile
				+ ", birthday=" + birthday + ", create_user=" + create_user + ", create_date=" + create_date
				+ ", update_user=" + update_user + ", update_date=" + update_date + ", isdel=" + isdel + "]";
	}
	
}
