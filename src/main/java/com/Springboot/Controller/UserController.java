package com.Springboot.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Springboot.Repository.UserRepo;
import com.Springboot.Service.UserService;
import com.Springboot.entity.User;


@RestController
public class UserController 
{
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepo userrepo;
	
	@PostMapping("/register")
	public String adduser(@RequestBody User user)
	{
      
		
		service.adduser(user);
		return "successfully...";
		
	}
	
	
	@PostMapping("/login")
    public String loginUser(@RequestBody User user) 
	{  
	        List<User>user1= service.findByEmail(user.getEmailid());
	        System.out.println(user1);
	        for(User u:user1)
	        {
	        	if(u.getEmailid().equals(user.getEmailid()) && (u.getPassword().equals(user.getPassword())))
	        	{
	        		
	        		
	        			return "login successfully...";
	        		
	        		
       	        }
	        	 
	        	
	        	if(!(u.getEmailid().equals(user.getEmailid())))
	        			{
	        		    return "incorrect email id....";
	        			}
	        	
	        	
	        	 
	        if(!(u.getPassword().equals(user.getPassword())))
   	         
	         return "password incorrect...";
	        }
	        return "check your email id and password....";
    }
	
	
	@GetMapping("/user")
	public List<User> getuser()
	{
		List<User> u = this.service.finduser();
		return u;
	}

}
