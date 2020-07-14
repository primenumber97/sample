package jp.co.sss.demo.details;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import jp.co.sss.demo.entity.UserTable;

public class DemoUserDetails extends User {

    @Autowired
    UserTable userTable;

    public DemoUserDetails(UserTable userTable) {
        // 「Collections.emptySet()」は本来は権限名のコレクションとなる。今回は空。
        super(userTable.getUserId(), userTable.getPassword(),Collections.emptySet());
        this.userTable = userTable;
    }

    // セッション情報から独自の項目を取得するためのGetter

    public String getFirstName() {
        return this.userTable.getFirstName();
    }

    public String getFamilyName() {
        return this.userTable.getFamilyName();
    }

}