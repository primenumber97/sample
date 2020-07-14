package jp.co.sss.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.sss.demo.entity.UserTable;

@Repository
public interface UserTableRepository extends JpaRepository<UserTable, String> {

    public UserTable findByUserId(String userId);

}