package jp.co.sss.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.sss.schedule.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	public Users findByUserId(String userId);
}