
package cn.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;

@Controller
@RequestMapping(value = "/main")
public class MainController {
	@Autowired
	private UserService service;

	@RequestMapping(value = "/index")
	public String index() {
		User user = new User();
		user.setPassword("xifan");
		user.setUsername("xifan");
		service.insertUser(user);
		return "index";
	}

}
