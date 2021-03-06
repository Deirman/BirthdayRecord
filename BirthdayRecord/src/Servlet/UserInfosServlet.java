package Servlet;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.UserInfo;
import impl.UserInfoServiceImpl;
import json.JackJsonUtils;
import json.ListObject;
import json.ResponseUtils;

@Controller
@RequestMapping(value = "/UserInfosServlet")
public class UserInfosServlet {
	public UserInfosServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }
	
	//查询用户
	@RequestMapping(value = "/getAllUserInfo", method=RequestMethod.GET)
	public void getAllUserInfo(HttpServletRequest request, HttpServletResponse response) {
		
		List<UserInfo> list = new UserInfoServiceImpl().getAllUserInfo();  
	    ListObject listObject=new ListObject();  
	    listObject.setItems(list);  
	    listObject.setMsg("获取用户信息成功");
	    listObject.setCode(1);
	    String responseText = JackJsonUtils.toJson(listObject);  
	    ResponseUtils.renderJson(response, responseText); 
	}
	
	//登录
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public void login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");  
	    String password = request.getParameter("password");
	    
	    UserInfo userInfo = new UserInfoServiceImpl().login(username,password);
	    ListObject listObject=new ListObject();
	    List<UserInfo> list = new ArrayList<UserInfo>();
	    if(userInfo.getId_phone_number() != null){
		    listObject.setMsg("登录成功");
		    listObject.setCode(1);
		    list.add(userInfo);
		    listObject.setItems(list);  
	    }else{
		    listObject.setMsg("用户名或密码错误");
		    listObject.setCode(0);
	    }
	    String responseText = JackJsonUtils.toJson(listObject);  
	    ResponseUtils.renderJson(response, responseText); 
	}
	
	//注册
	@RequestMapping(value = "/registered", method=RequestMethod.POST)
	public void registered(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String id_phone_number = request.getParameter("phone");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		UserInfo userInfo = new UserInfo();
		userInfo.setId_phone_number(Long.parseLong(id_phone_number));
		userInfo.setName(name);
		userInfo.setPhone(phone);
		userInfo.setEmail(email);
		userInfo.setNickname(nickname);
		userInfo.setPassword(password);
		Boolean results = new UserInfoServiceImpl().registered(userInfo);  
		 ListObject listObject=new ListObject();
	    if(results){
		    listObject.setMsg("注册成功");
		    listObject.setCode(1);
	    }else{
		    listObject.setMsg("注册失败");
		    listObject.setCode(0);
	    }
	    String responseText = JackJsonUtils.toJson(listObject);  
	    ResponseUtils.renderJson(response, responseText); 
	}
	
	
	
}
