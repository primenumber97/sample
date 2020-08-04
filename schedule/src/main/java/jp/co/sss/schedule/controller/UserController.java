package jp.co.sss.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.schedule.repository.UsersRepository;

@Controller
public class UserController {
	@Autowired
	UsersRepository repository;

	@RequestMapping("/users/findAll")
	public String showUserList(Model model) {
		model.addAttribute("users", repository.findAll());
		return "/user_list";
	}
}