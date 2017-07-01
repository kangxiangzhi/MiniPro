package com.spring.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dao.imple.UserDao;
import com.spring.entity.User;
import com.spring.service.HellowService;
@Controller	
@RequestMapping(value="/hellow")
public class HellowController {
	@Autowired
	private UserDao userDao;
	
	
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(@RequestParam(value = "id", required = true)String id){
		User u=new User();
		u.setId(id);
		u.setName("kang");
		u.setPassword("xiang");
		userDao.save(u);
		return "success";
	}
	
	
}
