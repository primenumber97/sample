package jp.co.sss.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	//indexに飛ぶ
	@RequestMapping(path="/",method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	//indexに飛ぶ
		@RequestMapping(path="/index",method = RequestMethod.GET)
		public String returnindex() {
			return "index";
		}
}