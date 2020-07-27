package jp.co.sss.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.demo.entity.UserTable;
import jp.co.sss.demo.form.DemoForm;
import jp.co.sss.demo.repository.UserTableRepository;

@Controller
public class UserComtroller {

	@RequestMapping(path="/create_input",method = RequestMethod.GET)
	public String createInput() {
		return "create_input";
	}

	@Autowired
	UserTableRepository repository;

	@RequestMapping(path="/create/complete",method=RequestMethod.POST)
	public String createComplete(DemoForm form) {
		UserTable user=new UserTable();
		user.setUserId(form.getUserId());
		user.setFamilyName(form.getFamilyName());
		user.setFirstName(form.getFirstName());
		user.setPassword(form.getPassword());
		repository.save(user);
		return "redirect:/getOne/"+user.getUserId();
	}

	@RequestMapping("/getOne/{id}")
	public String showUser(@PathVariable String userId,Model model) {
		model.addAttribute("userTable",repository.getOne(userId));
		return "/list";
	}

	@RequestMapping(path="/update_input",method = RequestMethod.GET)
	public String updateInput() {
		return "update_input";
	}
	@RequestMapping(path="/update/complete",method=RequestMethod.POST)
	public String updateComplete(DemoForm form) {
		UserTable user=new UserTable();
		user.setUserId(form.getUserId());
		user.setFamilyName(form.getFamilyName());
		user.setFirstName(form.getFirstName());
		user.setPassword(form.getPassword());
		repository.save(user);
		return "redirect:/getOne/"+user.getUserId();
	}
}
