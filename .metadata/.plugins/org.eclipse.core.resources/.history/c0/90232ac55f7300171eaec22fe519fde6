package Servlet;

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
	@RequestMapping(value = "/getAllUserInfo", method=RequestMethod.POST)
	public void getAllUserInfo(HttpServletRequest request, HttpServletResponse response) {
		
		List<UserInfo> list = new UserInfoServiceImpl().getAllUserInfo();  
	    ListObject listObject=new ListObject();  
	    listObject.setItems(list);  
	    String responseText = JackJsonUtils.toJson(listObject);  
	    ResponseUtils.renderJson(response, responseText); 
	}
}
