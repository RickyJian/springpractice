package idv.rickyjian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import idv.rickyjian.bean.UserBean;
import idv.rickyjian.service.UserService;

// 設定 RouteController 為Controller
@Controller
public class RouteController {
	
	@Autowired
	private UserService userService;
	
//	設定 login URL
	@RequestMapping("/login")
	public ModelAndView login() {
//		導頁至 login.html
		return new ModelAndView("login","message","登入提示訊息。");
	}
	
//	設定 index URL
//	取出url參數
	@RequestMapping("/{userName}")
	public ModelAndView index(@PathVariable("userName") String userName) {
		return new ModelAndView("index","userName",userName);
	}
	
	
	
//	login 處理
//	submit + 指定參數
	@RequestMapping("/loginsubmit")
	public ModelAndView submit(@RequestParam String userName , String password) {
		boolean result = userService.isAccountValid(userName, password);
		ModelAndView mav = null;
		if(result) {
//		設定回傳頁面
//		導頁至 login.html
			mav =  new ModelAndView("index");
			mav.addObject("userName",userName);
		}else {
			mav =  new ModelAndView("login");
			mav.addObject("message","登入失敗");
		}
		return mav;
	}
	
//	login 處理
//	submit + 封裝成 bean
	@RequestMapping("/loginsubmitwithbean")
	public ModelAndView submit(UserBean userBean) {
		boolean result = userService.isAccountValid(userBean.getUserName(), userBean.getPassword());
		ModelAndView mav = null;
		if(result) {
//		設定回傳頁面
//		導頁至 login.html
			mav =  new ModelAndView("index");
			mav.addObject("userName",userBean.getUserName());
		}else {
			mav =  new ModelAndView("login");
			mav.addObject("message","登入失敗");
		}
		return mav;
	}
	
//	login 處理
//	AJAX + 封裝成 bean
	@RequestMapping("/dologinwithform")
	public @ResponseBody String dologin(UserBean userBean) throws JsonProcessingException {
//		回傳資料型態轉成 JSON 格式
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode objectNode= objectMapper.createObjectNode();
		boolean result = userService.isAccountValid(userBean.getUserName(), userBean.getPassword());
		if (result) {
			objectNode.put("success",true);
			objectNode.put("userName",userBean.getUserName());
		}else {
			objectNode.put("success",false);
			objectNode.put("message","登入失敗。");
		}
		return objectMapper.writeValueAsString(objectNode);
	}
	
//	login 處理
//	AJAX + 指定參數
	@RequestMapping("/dologin")
	public @ResponseBody String dologin(@RequestParam String userName , String password) throws JsonProcessingException {
//		回傳資料型態轉成 JSON 格式
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode objectNode= objectMapper.createObjectNode();
		boolean result = userService.isAccountValid(userName, password);
		if (result) {
			objectNode.put("success",true);
			objectNode.put("userName",userName);
		}else {
			objectNode.put("success",false);
			objectNode.put("message","登入失敗。");
		}
		return objectMapper.writeValueAsString(objectNode);
	}
	
}
