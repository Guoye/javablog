package com.zhangguoye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * helloworld 数据绑定 示例
 * 
 * @author zhangguoye
 *
 */

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

	public HelloWorldController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 路由到模板主页
	 * 
	 * @return
	 */
//	http://localhost:8080/blog/helloworld
//	http://localhost:8080/blog/helloworld/
	@RequestMapping("")
	public String toIndex() {
		return "helloworld/helloworld-index";
	}

	/**
	 * 路由匹配访问
	 * 
	 * @return
	 */
//	http://localhost:8080/blog/helloworld/route
//	http://localhost:8080/blog/helloworld/routeabc
//	http://localhost:8080/blog/helloworld/route/abc
	@RequestMapping(value = { "/route", "/route*", "/route/*" }, method = RequestMethod.GET)
	public String toRoute() {
		return "helloworld/helloworld-index";
	}

	/**
	 * 获取url的queryParmas多个参数
	 * 
	 * @param id
	 * @param ids
	 * @param no
	 * @return
	 */
//	http://localhost:8080/blog/helloworld/query?id=123&ids=abc&ids=def
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String toQueryParams(@RequestParam(value = "id") String id,
			@RequestParam(value = "ids", required = false, defaultValue = "nothings") String[] ids,
			@RequestParam(value = "no", required = false) Integer no) {
		return "helloworld/helloworld-index";
	}

	/**
	 * 直接返回字符串
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getString")
	@ResponseBody
	public String toResponseString() {
		return "this is a Response String words!";
	}

	/**
	 * 产生一个 JSON 响应
	 * @return
	 */
	@RequestMapping(value = "/getJson", produces = { "application/JSON"})
	@ResponseBody
	public String toResponseJson() {
		return "{id: 123}";
	}
	
	/**
	 * 可以同时处理请求中的 JSON 和 XML 内容
	 * @return
	 */
	@RequestMapping(value = "/getJson2", consumes = {"text/plain", "application/*"})
	@ResponseBody
	public String toResponseJson2() {
		return "{id: 123}";
	}

}
