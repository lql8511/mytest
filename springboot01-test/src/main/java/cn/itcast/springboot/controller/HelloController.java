package cn.itcast.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.springboot.service.UserService;

/**
 * HelloController
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年11月19日 上午9:23:25
 * @version 1.0
 */
@RestController
public class HelloController {
	
	@Autowired
	private UserService userService;
	/** 注入属性文件中的属性(一次性全部注入) */
	@Autowired
	private Environment environment;
	/** 注入属性文件中的属性(获取单个属性) */
	@Value("${name}")
	private String name1;
	@Value("${url}")
	private String url1;
	
	@GetMapping("/hello")
	public String hello(){
		System.out.println("name:" + environment.getProperty("name"));
		System.out.println("url:" + environment.getProperty("url"));
		
		System.out.println(name1 + "---->" + url1);
		userService.save();
		return "Hello Spring Boot! xxxxx";
	}
	
}
