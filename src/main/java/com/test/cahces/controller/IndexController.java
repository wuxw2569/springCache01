package com.test.cahces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.cahces.common.util.bean.ResponseBean;
import com.test.cahces.common.util.bean.ResponseStatusEnum;
import com.test.cahces.data.User;
import com.test.cahces.service.IUserService;
import com.test.cahces.service.IUserService2;
@RestController
public class IndexController {
	@Autowired
	IUserService userService;

	@Autowired
	IUserService2 userService2;
	

	@RequestMapping("/")
	@ResponseBody
	public ResponseBean index(){
		ResponseBean rb = new ResponseBean();
		rb.setData(userService.getList());
		return rb;
	}
	
	@RequestMapping("/getList2")
	@ResponseBody
	public ResponseBean getList2(){
		ResponseBean rb = new ResponseBean();
		rb.setData(userService.getList2());
		return rb;
	}
	
	

	@RequestMapping("/2.0/getList")
	@ResponseBody
	public ResponseBean getList22(){
		ResponseBean rb = new ResponseBean();
		rb.setData(userService2.getList());
		return rb;
	}
	
	
	@RequestMapping("/add")
	@ResponseBody
	public ResponseBean add(String name,Integer age){
		ResponseBean rb = new ResponseBean();
		if(userService.add(name,age) !=null){
			rb.setCode(ResponseStatusEnum.OK.getValue());
		}
		return rb;
	}
	

	@RequestMapping("/upd")
	@ResponseBody
	public ResponseBean upd(String name,Long id){
		ResponseBean rb = new ResponseBean();
		if(userService.upd(name,id)){
			rb.setCode(ResponseStatusEnum.OK.getValue());
		}
		return rb;
	}
	
	
	@RequestMapping("/getDetail")
	@ResponseBody
	public ResponseBean getDetail(long id){
		ResponseBean rb = new ResponseBean();
		User user = userService.getDetail(id);
		if(user!=null){
			rb.setData(user);
			rb.setCode(ResponseStatusEnum.OK.getValue());
		}
		return rb;
	}
}
