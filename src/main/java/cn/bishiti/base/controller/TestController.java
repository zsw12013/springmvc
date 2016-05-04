package cn.bishiti.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.bishiti.base.commons.page.Page;
import cn.bishiti.base.model.TUser;
import cn.bishiti.base.model.Users;
import cn.bishiti.base.service.TUserService;
import cn.bishiti.base.service.TestService;


@Controller
@RequestMapping("/test")
public class TestController {
	private static final Logger LOGGER = Logger.getLogger(TestController.class);

	 @Autowired
	 private TestService  testService;
	
	@RequestMapping("/index")
	public String index(){		
		return "/test/index";
	}
	

	 @RequestMapping("/users")
	 @ResponseBody
	public Object getUsers(@RequestParam(required = false, defaultValue = "1")Integer page,
						   @RequestParam(required = false, defaultValue = "10") Integer rows){
 		Page pages = Page.newBuilder(page, rows, "users");
 		pages.getParams().put("name", null); 
 		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", pages);
		List<Users> users= testService.selectPageByParam(map, pages);
		map.put("total", pages.getTotalRecord());
		map.put("rows", users);
		return map;
	} 
	 @RequestMapping("/insert")
	 @ResponseBody
	 public Object   insert(Users users){
	     LOGGER.info(JSON.toJSON("添加用户："+users));
		int i= testService.insert(users);
		Map<String,Object> map=new HashMap<String,Object>();
		if(i>0){
			 map.put("success", "true");
		}
		 return map;
	 }
	 
    @RequestMapping("/del")
	@ResponseBody
	public Object del(Model model,Integer id){
	   testService.deleteByPrimaryKey(id);
		LOGGER.info(JSON.toJSON("删除用户:"+id));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("success", "true");
		return map;
	}
    
	@RequestMapping("/update")
	@ResponseBody
	public Object update(Model model,Users user){
		testService.updateByPrimaryKeySelective(user);
		LOGGER.info(JSON.toJSON("更新用户："+user));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("success", "true");;
		return map;
	}
}
