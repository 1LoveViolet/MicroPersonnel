package com.group.microPersonnel.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TestController
 * @Author JiangHu
 * @Date 2023/2/13 16:39
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

	/**
	 * 127.0.0.1/api/test/helloWorld ---- get
	 */
	@GetMapping(value = "/helloWorld")
	public String helloWorldTest() {
		return "Hello Worl1!";
	}
}
