package jp.co.sss.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//アクセス可能なURLの制限とログイン成功時の遷移先の指定をするメソッド
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
		//springsecurity無しで入れるとこ
		.mvcMatchers("/").permitAll()

		// それ以外はログインが必要
		.anyRequest().authenticated()

		// ログイン成功時には「/home」にGetリクエストをする
		.and()
		.formLogin()
		.defaultSuccessUrl("/home")

		// ログアウト成功時には「/」にGetリクエストをする
		.and()
		.logout()
		.logoutSuccessUrl("/");
	}
	private AbstractAuthenticationFilterConfigurer<HttpSecurity, FormLoginConfigurer<HttpSecurity>, UsernamePasswordAuthenticationFilter> formLogout() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	//入力されたパスワードをBCrypt方式でハッシュ化するメソッド
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}