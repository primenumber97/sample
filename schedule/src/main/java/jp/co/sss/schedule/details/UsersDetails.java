package jp.co.sss.schedule.details;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import jp.co.sss.schedule.entity.Users;

public class UsersDetails extends User{

	@Autowired
	Users users;

	public UsersDetails(Users users) {
		// 「Collections.emptySet()」は本来は権限名のコレクションとなる。今回は空。
		super(users.getUserId(), users.getPassword(), Collections.emptySet());
		this.users=users;
	}
	// セッション情報から独自の項目を取得するためのGetter
	public String getUser_Name() {
		return this.users.getUserName();
	}
}