package jp.co.sss.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	//アクセス可能なURLの制限とログイン成功時の遷移先の指定をするメソッド
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
		//springsecurity無しで入れるとこ
		.mvcMatchers("/").permitAll()
		.mvcMatchers("/index").permitAll()
		.mvcMatchers("/list").permitAll()
		.mvcMatchers("/create_input").permitAll()
		.mvcMatchers("/create/complete").permitAll()

		// それ以外はログインが必要
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.defaultSuccessUrl("/success"); // ログイン成功時には「/success」にGetリクエストをする
	}

	//入力されたパスワードをBCrypt方式でハッシュ化するメソッド
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}