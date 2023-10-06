package com.litap.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.litap.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService; 
	
		
	@Autowired
	SessionFactory factory;
	
		
	@RequestMapping("login")
	public ModelAndView login() {
		
		ModelAndView modelAndView =  new ModelAndView();
		
		modelAndView.setViewName("login");
		
		return modelAndView;
		
	}
	@RequestMapping("validate")
	public ModelAndView validate(String username, String password, HttpServletRequest request) {
		
		
		String ans = loginService.validateService(username, password);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(ans.equalsIgnoreCase("INVALID")) {
			modelAndView.setViewName("login");
			modelAndView.addObject("message", "INVALID CREDENTIALS");		
		}
		else {
			if(ans.equalsIgnoreCase("Admin")) {
				modelAndView.setViewName("admin");
				modelAndView.addObject("message", "Welcome "+username);
			}
			else if(ans.equalsIgnoreCase("Customer")) {
				
			}
			else if(ans.equalsIgnoreCase("Marketing")) {
				
			}
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("username", username);
		}
		
		return modelAndView;
	}
	
//	@RequestMapping("startExam")
//	public ModelAndView startExam(String selectedSubject, HttpServletRequest request) {
//		
//		
//		ModelAndView modelAndView = new ModelAndView();
//		
//		if(selectedSubject == null) {
//			modelAndView.setViewName("login");
//		}
//		else {
//			
//			Session session = factory.openSession();
//			
//			HttpSession httpSession = request.getSession();
//			httpSession.setAttribute("qno", 0);
//			httpSession.setAttribute("timeremaining", 121);
//			
//			
////			Query query = session.createQuery("from Questions where subject=:subject ");//"from Questions where subject=:subject order by rand()"
////			query.setParameter("subject", selectedSubject);
////			List<Questions> listOfQuestions = query.list();
//			
//			List<Questions> listOfQuestions = loginService.getQuestionsList(selectedSubject);
//			
//			modelAndView.setViewName("question");
//			modelAndView.addObject("listOfQuestions", listOfQuestions);
//			modelAndView.addObject("question", listOfQuestions.get(0));
//			
//			httpSession.setAttribute("currentQuestion", listOfQuestions.get(0));
//			httpSession.setAttribute("allquestions", listOfQuestions);
//			
//			
//			HashMap<Integer, Answer> hashmap = new HashMap<Integer, Answer>();
//			httpSession.setAttribute("submittedDetils", hashmap);
//			
//			httpSession.setAttribute("score", 0);
//			httpSession.setAttribute("selectedSubject", selectedSubject);
//			
//		}
//		
//		
//		return modelAndView;
//	}
//	
//	
//	@RequestMapping("next")
//	public ModelAndView next(HttpServletRequest request) {
//		
//		ModelAndView modelAndView = new ModelAndView();		
//		
//		HttpSession httpSession = request.getSession();			
//		
//		List<Questions> listOfQuestions= (List<Questions>) httpSession.getAttribute("allquestions");		
//		
//		int qno= (int) httpSession.getAttribute("qno");
//		
//		if(qno < listOfQuestions.size()-1) {
//			int nextQno = (int) httpSession.getAttribute("qno")+1;
//			httpSession.setAttribute("qno",nextQno);
//			httpSession.setAttribute("currentQuestion", listOfQuestions.get(nextQno));
//			
//			modelAndView.setViewName("question");
//			modelAndView.addObject("question", listOfQuestions.get(nextQno));
//		}
//		else {
//			modelAndView.addObject("question", listOfQuestions.get(listOfQuestions.size()-1));
//			modelAndView.addObject("message", "Questions are over");
//			modelAndView.setViewName("question");
//		}		
//		return modelAndView;
//	}
//	
//	
//	
//	@RequestMapping("previous")
//	public ModelAndView previous(HttpServletRequest request) {
//		
//		ModelAndView modelAndView = new ModelAndView();		
//		
//		HttpSession httpSession = request.getSession();		
//		
//		List<Questions> listOfQuestions= (List<Questions>) httpSession.getAttribute("allquestions");		
//		
//		int qno= (int) httpSession.getAttribute("qno");
//		
//		if(qno > 0) {
//			int prevQno = (int) httpSession.getAttribute("qno")-1;
//			httpSession.setAttribute("qno",prevQno);
//			httpSession.setAttribute("currentQuestion", listOfQuestions.get(prevQno));
//
//			modelAndView.setViewName("question");
//			modelAndView.addObject("question", listOfQuestions.get(prevQno));
//		}
//		else {
//			modelAndView.addObject("question", listOfQuestions.get(0));
//			modelAndView.addObject("message", "This is start of Question list");
//			modelAndView.setViewName("question");
//		}	
//		
//		return modelAndView;
//	}
	

}
