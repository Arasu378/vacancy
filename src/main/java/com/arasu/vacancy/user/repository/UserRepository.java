package com.arasu.vacancy.user.repository;

import com.arasu.vacancy.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends org.springframework.data.repository.Repository<User, Integer>{
	
	User findByEmail(String email);
	User save(User user);
	User findById(Integer id);
	User findByEmailAndPassword(String email, String password);

}
