package com.example.expensetracker.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.example.expensetracker.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User getUserByEmailIdAndMobileNo(String email,String mobileNo);


}
