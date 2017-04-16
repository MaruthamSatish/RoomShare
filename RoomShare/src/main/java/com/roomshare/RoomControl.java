package com.roomshare;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.roomshare.dao.UserDao;
import com.roomshare.model.User;

@Controller
@EnableAutoConfiguration
public class RoomControl {
	@RequestMapping("/view")
	public String display(Model model){
		model.addAttribute("user",new User());
		return "landing";
	}
	
	@RequestMapping(value = "/user",method=RequestMethod.POST)
	
	@ResponseBody
	public String createUser(@RequestBody @RequestParam("username")String username,@RequestParam("password")String password){ 
	String userId = "";
	User user = new User();
	user.setPassword(password);
	user.setUserName(username);
	userId = String.valueOf(userDao.save(user));
	System.out.println(userId);
	return userId;
	
}
@RequestMapping(value = "/userTest",method=RequestMethod.POST)
public String viewUser(@RequestParam("username")String username,@RequestParam("password")String password){
	System.out.println(username);
	return "redirect:test";
}

@RequestMapping(value = "/userRegister",method=RequestMethod.POST)
public String roomRegister(@ModelAttribute User user){
	System.out.println(user.getFirstName());
	User userValues = new User();
	/*userValues.setFirstName(user.getFirstName());
	userValues.setLastName(user.getLastName());
	userValues.setPassword(user.getPassword());
	userValues.setUserName(user.getUserName());*/
	userDao.save(user);
	List<User> usrList =new ArrayList<User>();
	usrList= (List<User>) userDao.findAll();
	System.out.println(usrList.get(0).getFirstName());
	return "landing";
}
	
@Autowired
private UserDao userDao;
}
