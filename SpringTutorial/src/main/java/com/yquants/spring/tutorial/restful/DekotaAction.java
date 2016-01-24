package com.yquants.spring.tutorial.restful;


import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * ����Restful���ܹ�����
 * 
 * @author Winson
 * @since JDK1.7
 * @version V1.0
 * @history 2016-1-23
 */
@Controller
public class DekotaAction {

	/** ��־ʵ�� */
	private static final Logger logger = Logger.getLogger(DekotaAction.class);

	@RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String hello() {
		return "��ã�hello";
	}

	@RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String say(@PathVariable(value = "msg") String msg) {
		return "{\"msg\":\"you say:'" + msg + "'\"}";
	}

	@RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.GET)
	public @ResponseBody
	Person getPerson(@PathVariable("id") int id) {
		logger.info("��ȡ��Ա��Ϣid=" + id);
		Person person = new Person();
		person.setName("����");
		person.setSex("��");
		person.setAge(30);
		person.setId(id);
		return person;
	}

	@RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.DELETE)
	public @ResponseBody
	Object deletePerson(@PathVariable("id") int id) {
		logger.info("ɾ����Ա��Ϣid=" + id);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "ɾ����Ա��Ϣ�ɹ�");
		return jsonObject;
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public @ResponseBody
	Object addPerson(Person person) {
		logger.info("ע����Ա��Ϣ�ɹ�id=" + person.getId());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "ע����Ա��Ϣ�ɹ�");
		return jsonObject;
	}

	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public @ResponseBody
	Object updatePerson(Person person) {
		logger.info("������Ա��Ϣid=" + person.getId());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "������Ա��Ϣ�ɹ�");
		return jsonObject;
	}

	@RequestMapping(value = "/person", method = RequestMethod.PATCH)
	public @ResponseBody
	List<Person> listPerson(@RequestParam(value = "name", required = false, defaultValue = "") String name) {

		logger.info("��ѯ��Աname like " + name);
		List<Person> lstPersons = new ArrayList<Person>();

		Person person = new Person();
		person.setName("����");
		person.setSex("��");
		person.setAge(25);
		person.setId(101);
		lstPersons.add(person);

		Person person2 = new Person();
		person2.setName("����");
		person2.setSex("Ů");
		person2.setAge(23);
		person2.setId(102);
		lstPersons.add(person2);

		Person person3 = new Person();
		person3.setName("����");
		person3.setSex("��");
		person3.setAge(27);
		person3.setId(103);
		lstPersons.add(person3);

		return lstPersons;
	}

	private class Person{
		private int id;
		private int age;
		private String sex;
		private String name;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}
