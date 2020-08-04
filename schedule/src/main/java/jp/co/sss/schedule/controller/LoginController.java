package jp.co.sss.schedule.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.sss.schedule.details.UsersDetails;

@RestController
public class LoginController {

	@GetMapping("/home")
	public UsersDetails loginHome() {
		// ログイン中のユーザ情報を取得
		UsersDetails usersDetails=
				(UsersDetails) SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal();
		return usersDetails;
	}
}