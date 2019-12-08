package org.light.spring;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.light.spring.DAO.AppDAOImplementation;
import org.light.spring.config.AppConfig;
import org.light.spring.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

		@RequestMapping("/")
		public ModelAndView homepage(){
			
			ModelAndView model = new ModelAndView("index");
			List<User> users = new ArrayList<User>();
			//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/org/light/spring/DAO/Spring-AppDAOConfig.xml");
			AnnotationConfigApplicationContext context=  new AnnotationConfigApplicationContext(AppConfig.class);
			AppDAOImplementation DAO= context.getBean("DAOBean",AppDAOImplementation.class);
			users= DAO.listUsers();
			System.out.println(users);
			model.addObject("users",users);
			context.close();
			return model;
		}
		@RequestMapping("/addUser")//This particular method will load the page and also handle it after submition!
		public String addUser(Model model, @Valid User user, BindingResult result){
			if(result.hasErrors()){//if there is an error we will load the form again!
			model.addAttribute("users",user);
			return "addUser";
			}else{//if there is no problem with the validation then we would be loading the home page again 
					//NOTE: If it's the first time being deployed then spite of the fact that there is no errors, the name and email will come null so "forward:/" will be executed . so the 
				//trick here will be joining a if to check if its coming null or not!
				if(user.getName()!=null && user.getEmail()!=null){
					AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
					AppDAOImplementation DAO = context.getBean("DAOBean",AppDAOImplementation.class);
					
					DAO.addUser(user);
					context.close();
					System.out.println(user);
					return "forward:/";
			
				
				}else{
					return "addUser";
				}
			}
				
			
		
		}
	
}
