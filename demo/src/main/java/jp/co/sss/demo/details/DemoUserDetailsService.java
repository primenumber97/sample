package jp.co.sss.demo.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.sss.demo.entity.UserTable;
import jp.co.sss.demo.repository.UserTableRepository;

@Service
public class DemoUserDetailsService implements UserDetailsService {

    @Autowired
    UserTableRepository userTableRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        //入力されたUserIDを条件にDBからデータを取得する
        UserTable userTable = userTableRepository.findByUserId(userId);

        // 入力値（ユーザーID、パスワード）とインスタンス化したDemoUserDetailsクラスを
        // SpringSecurityの内部で比較することで、ログインチェックを行っている。
        return new DemoUserDetails(userTable);

    }

}