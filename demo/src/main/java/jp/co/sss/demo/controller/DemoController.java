package jp.co.sss.demo.controller;
/**
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.sss.demo.details.DemoUserDetails;

@RestController
public class DemoController {


    @GetMapping("/success")
    public DemoUserDetails loginSuccess() {
        // ログイン中のユーザ情報を取得
        DemoUserDetails demoUserDetails =
                (DemoUserDetails) SecurityContextHolder
                                    .getContext().getAuthentication().getPrincipal();

        return demoUserDetails;
    }
}**/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController{
	@RequestMapping(path="/success",method = RequestMethod.GET)
	public String success() {
		return "success";
	}
}