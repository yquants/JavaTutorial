package com.yquants.spring.tutorial.restful;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @���� Winson
 * @�ʼ� laxsong@hotmail.com
 * @���� 2016-1-23
 */
@Controller
@RequestMapping("/user")
public class UserController {
	public List<User> list = null;

	/**
	 * user·����Ĭ����ʾ�û��б�
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		if (list == null) {
			list = getUserList();
		}
		ModelMap model = new ModelMap();
		model.addAttribute("list", list);
		return new ModelAndView("user/index", model);
	}

	/**
	 * ��ת������û�ҳ�棬Լ���������ã�Ĭ��ƥ���ļ�/WEB-INF/views/user/add.jsp
	 */
	@RequestMapping("add")
	public void add() {
	}

	/**
	 * ���������û�
	 * 
	 * @param user
	 * @return ModelAndView
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addUser(User user) {
		if (list == null) {
			list = getUserList();
		}
		list.add(user);
		ModelMap model = new ModelMap();
		model.addAttribute("list", list);
		return new ModelAndView("user/index", model);
	}

	/**
	 * �鿴�û���ϸ��Ϣ
	 * 
	 * @param id
	 * @return ModelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ModelAndView viewUser(@PathVariable("id") String id) {
		User user = findUserById(id);
		ModelMap model = new ModelMap();
		model.addAttribute("user", user);
		return new ModelAndView("user/view", model);
	}

	/**
	 * ɾ���û�
	 * 
	 * @param id
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public String deleteUser(@PathVariable("id") String id) {
		if (list == null) {
			list = getUserList();
		}
		removeUserByUserId(id);
		return "suc";
	}

	/**
	 * ��ת���༭ҳ��
	 * 
	 * @param id
	 * @return ModelAndView
	 */
	@RequestMapping("{id}/edit")
	public ModelAndView toEdit(@PathVariable("id") String id) {
		User user = findUserById(id);
		ModelMap model = new ModelMap();
		model.addAttribute("user", user);
		return new ModelAndView("user/edit", model);
	}

	/**
	 * �����û�����ת���û��б�ҳ��
	 * 
	 * @param user
	 * @return ModelAndView
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ModelAndView edit(User user) {
		updateUser(user);
		return new ModelAndView("redirect:/user/");
	}

	/******************** ���淽���ǲ������ݵ� *********************/
	/**
	 * ��10���û�
	 * 
	 * @return List<User>
	 */
	private List<User> getUserList() {
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			list.add(new User((i + 1) + "", "����" + (i + 1)));
		}
		return list;
	}

	/**
	 * ɾ���û�
	 * 
	 * @param id
	 * @return List<User>
	 */
	private List<User> removeUserByUserId(String id) {
		if (list == null)
			return null;
		for (User user : list) {
			if (user.getUserId().equals(id)) {
				list.remove(user);
				break;
			}
		}
		return list;
	}

	/**
	 * �����û�
	 * 
	 * @param id
	 * @return User
	 */
	private User findUserById(String id) {
		User user = null;
		if (list == null)
			return null;
		for (User _user : list) {
			if (_user.getUserId().equals(id)) {
				user = _user;
				break;
			}
		}
		return user;
	}

	/**
	 * �����û�
	 * 
	 * @param user
	 */
	private void updateUser(User user) {
		for (User _user : list) {
			if (_user.getUserId().equals(user.getUserId())) {
				_user.setUserName(user.getUserName());
				break;
			}
		}
	}
}