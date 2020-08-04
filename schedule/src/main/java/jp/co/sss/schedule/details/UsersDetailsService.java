package jp.co.sss.schedule.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.sss.schedule.entity.Users;
import jp.co.sss.schedule.repository.UsersRepository;

@Service
public class UsersDetailsService implements UserDetailsService {

	@Autowired
	UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		//入力されたUserIDを条件にDBからデータを取得する
		Users users = usersRepository.findByUserId(userId);

		// 入力値（ユーザーID、パスワード）とインスタンス化したDemoUserDetailsクラスを
		// SpringSecurityの内部で比較することで、ログインチェックを行っている。
		return new UsersDetails(users);

	}

}