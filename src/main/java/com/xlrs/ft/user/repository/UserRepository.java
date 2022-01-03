package com.xlrs.ft.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xlrs.ft.user.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	
}
