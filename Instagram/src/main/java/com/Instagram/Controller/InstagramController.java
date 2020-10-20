
package com.Instagram.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Instagram.Dao.InstagramDao;
import com.Instagram.Entity.InstagramUser;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class InstagramController {
	@Autowired
    InstagramDao idao;

	
	@GetMapping("/view")
	public List<InstagramUser> ll(){
		return idao.viewallProfileDao();
			
	}
	
	@PostMapping("/view")
	 public InstagramUser createProfile( @RequestBody InstagramUser newUser) {
        return idao.createProfileDao(newUser);
    }
	
	@PutMapping("/view")
	public InstagramUser editProfile(@RequestBody InstagramUser editingUser) {
		
		return idao.editProfileDao(editingUser);
		
	}
	
	@DeleteMapping("/view/{name}")
	public void deleteUser(@PathVariable("name") String name) 
	{
		idao.deleteProfileDao(name);
	
	}
	
	

}
