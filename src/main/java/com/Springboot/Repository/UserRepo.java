package com.Springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Springboot.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{
	@Query("select u from User u where emailid =:n")
	public List<User> findByEmail(@Param("n") String emailid);

}
