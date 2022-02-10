package com.example.expensetracker.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.expensetracker.entity.User;

public interface UserRepository extends JpaRepository <User, Long> {

	@Query("FROM User as u WHERE u.id IS NOT NULL")
	List<User> getAllUsersByID();

}
