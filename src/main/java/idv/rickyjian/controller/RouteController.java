package idv.rickyjian.controller;

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
//	取出url參數
	@RequestMapping("/{userName}")
	public ModelAndView index(@PathVariable("userName") String userName) {
		return new ModelAndView("index","userName",userName);
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
	
//	login 處理
//	AJAX + 封裝成 bean
	@RequestMapping("/dologinwithform")
	public @ResponseBody String dologin(UserBean userbean) throws JsonProcessingException {
//		回傳資料型態轉成 JSON 格式
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode objectNode= objectMapper.createObjectNode();
		objectNode.put("success",true);
		objectNode.put("userName",userbean.getUserName());
		return objectMapper.writeValueAsString(objectNode);
	}
	
//	login 處理
//	AJAX + 指定參數
	@RequestMapping("/dologin")
	public @ResponseBody String dologin(@RequestParam String userName , String password) throws JsonProcessingException {
//		回傳資料型態轉成 JSON 格式
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode objectNode= objectMapper.createObjectNode();
		objectNode.put("success",true);
		objectNode.put("userName",userName);
		return objectMapper.writeValueAsString(objectNode);
	}
	
}
