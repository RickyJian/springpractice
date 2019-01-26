package idv.rickyjian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import idv.rickyjian.bean.UserBean;

// 設定 RouteController 為Controller
@Controller
public class RouteController {
	
//	設定 login URL
	@RequestMapping("/login")
	public ModelAndView login() {
//		導頁至 login.html
		return new ModelAndView("login");
	}
	
//	設定 index URL
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	
	
//	login 處理
//	submit + 指定參數
	@RequestMapping("/loginsubmit")
	public ModelAndView submit(@RequestParam String userName , String password) {
//		設定回傳頁面
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("userName",userName);
//		導頁至 login.html
		return mav;
	}
	
//	login 處理
//	submit + 封裝成 bean
	@RequestMapping("/loginsubmitwithbean")
	public ModelAndView submit(UserBean userbean) {
//		設定回傳頁面
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("userName",userbean.getUserName());
//		導頁至 login.html
		return mav;
	}
	
}
