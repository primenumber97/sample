package jp.co.sss.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.demo.entity.UserTable;
import jp.co.sss.demo.repository.UserTableRepository;


@Controller
public class ListController {
	@Autowired
	UserTableRepository repository;

	//listに飛ぶ
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(Model model) {
		List<UserTable> list=repository.findAll();
		model.addAttribute("list", list);
		return "list";
	}
}
