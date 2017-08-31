package Servlet;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import entity.FriendsInfo;
import impl.FriendsInfoServiceImpl;
import json.JackJsonUtils;
import json.ListObject;
import json.ResponseUtils;
@Controller
@RequestMapping(value = "/FriendsInfoServlet")
public class FriendsInfoServlet {
	
	public FriendsInfoServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }
	//添加朋友
		@RequestMapping(value = "/addFriend", method=RequestMethod.POST)
		public void addFriend(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, java.text.ParseException {
			request.setCharacterEncoding("UTF-8");
			String friend_name = request.getParameter("friendName");
			String friend_sex = request.getParameter("friendSex");
			String friend_birthday = request.getParameter("friendBirthday");
			String friend_appellation = request.getParameter("friendAppellation");
			String friend_phone = request.getParameter("friendPhone");
			String friend_address = request.getParameter("friendAddress");
			FriendsInfo friendsInfo = new FriendsInfo();
			friendsInfo.setFriend_name(friend_name);
			friendsInfo.setFriend_sex(friend_sex);
			friendsInfo.setFriend_birthday(friend_birthday);
			friendsInfo.setFriend_appellation(friend_appellation);
			friendsInfo.setFriend_phone(friend_phone);
			friendsInfo.setFriend_address(friend_address);
			Boolean results = new FriendsInfoServiceImpl().addFriend(friendsInfo);  
			 ListObject listObject=new ListObject();
		    if(results){
			    listObject.setMsg("添加朋友成功");
			    listObject.setCode(1);
		    }else{
			    listObject.setMsg("添加朋友失败");
			    listObject.setCode(0);
		    }
		    String responseText = JackJsonUtils.toJson(listObject);  
		    ResponseUtils.renderJson(response, responseText); 
		}

}
