package jp.co.sss.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.demo.form.PrimeForm;

@Controller
public class PrimeController {
	@RequestMapping("/prime")
	public String form(Model model){
		model.addAttribute("form", new PrimeForm());
		return "prime";
	}
	@RequestMapping(value="/result", method = RequestMethod.POST)
	public String result(@ModelAttribute PrimeForm form , Model model){
		form.hantei();
		model.addAttribute("form", form);
		return "result";
	}
}