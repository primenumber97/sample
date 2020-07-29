package jp.co.sss.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.sss.demo.entity.UserTable;

@Repository
public interface UserTableRepository extends JpaRepository<UserTable, Integer> {

    public UserTable findByUserId(String userId);

//    public Optional<UserTable> findById(Integer id);

}