package com.Springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.Repository.UserRepo;
import com.Springboot.entity.User;

@Service
public class UserService 
{
    
	@Autowired
	private UserRepo userrepo; 
	
	@Autowired
	public UserService(UserRepo userrepo)
	{
		this.userrepo=userrepo;
	}


	public void adduser(User user) 
	{
		
	    userrepo.save(user);
	
		
	}


	public List<User> finduser() 
	{
	List<User> user= userrepo.findAll();
		
		return user;
	}


	public List<User> findByEmail(String emailid)
	{
	    List<User>u= userrepo.findByEmail(emailid);
		return u;
	}


}
