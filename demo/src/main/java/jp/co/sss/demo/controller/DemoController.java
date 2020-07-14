package jp.co.sss.demo.controller;

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
}