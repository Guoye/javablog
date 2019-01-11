package com.zhangguoye.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhangguoye.model.Admin;
import com.zhangguoye.model.User;

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
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getJson", produces = { "application/JSON" })
	@ResponseBody
	public String toResponseJson() {
		return "{id: 123}";
	}

	/**
	 * 可以同时处理请求中的 JSON 和 XML 内容
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getJson2", consumes = { "text/plain", "application/*" })
	@ResponseBody
	public String toResponseJson2() {
		return "{id: 123}";
	}

	/**
	 * 处理指定的header请求，非指定则返回状态404
	 * 
	 * @return
	 */
//	方法就只会处理到 /helloworld/header 并且 content-typeheader 被指定为 text/plain 这个值的请求。
//	也可以多个类型：headers = {"content-type=text/plain","content-type=text/html"}
	@RequestMapping(value = "/header", headers = { "content-type=text/plain" })
	@ResponseBody
	public String toResponseHeader() {
		return "abc";
	}

	/**
	 * 处理restful风格动态URI
	 * 
	 * @return
	 */
//	http://localhost:8080/blog/helloworld/user/a/b
	@RequestMapping(value = "/user/{userId}/{accountId}")
	@ResponseBody
	public String toResponseRestfulParams(@PathVariable(value = "userId") String userId,
			@PathVariable(value = "accountId") String accountId) {
		return "{userId:" + userId + ", accountId: " + accountId + "}";
	}

	/**
	 * 绑定简单对象
	 * 处理URI的参数，返回对象字符串
	 * 
	 * @param user
	 * @return
	 */
//	http://localhost:8080/blog/helloworld/sendUser?id=1&name=zhangsan&age=2
	@RequestMapping(value = "/sendUser")
	@ResponseBody
	public String toResponseObj(User user) {
		return user.toString();
	}
	
	/**
	 * 绑定多层对象
	 * 处理URI的参数，返回对象字符串
	 * 
	 * @param user
	 * @return
	 */
//	http://localhost:8080/blog/helloworld/sendUser2?id=1&name=zhangsan&age=2&userContactInfo.phoneNo=123&userContactInfo.address=abc
	@RequestMapping(value = "/sendUser2")
	@ResponseBody
	public String toResponseObj2(User user) {
		return user.toString();
	}
	
	/**
	 * 绑定多个不同对象的相同属性
	 * 处理URI的参数，返回对象字符串
	 * @param user
	 * @param admin
	 * @return
	 */
//	http://localhost:8080/blog/helloworld/sendUser3?user.id=1&admin.id=121&name=zhangsan&age=2&userContactInfo.phoneNo=123&userContactInfo.address=abc
	@RequestMapping(value = "/sendUser3")
	@ResponseBody
	public String toResponseObj2(User user, Admin admin) {
		return user.toString() + " " + admin.toString();
	}
	
	@InitBinder("user")
	public void initBinderUser(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("user.");
	}
	
	@InitBinder("admin")
	public void initBinderAdmin(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("admin.");
	}
}
