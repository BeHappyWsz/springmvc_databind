package databind.controller;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import databind.domain.Container;
import databind.domain.Role;
import databind.domain.User;
import databind.domain.UserList;
import databind.domain.UserMap;
import databind.domain.UserSet;
import databind.domain.XMLObject;
/**
 * 数据绑定
 * @author wsz
 * @date 2018年4月2日
 */
@Controller
public class DataBindController {

	@ResponseBody
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	/**
	 * 基础数据类型
	 * @param username
	 * @param age
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/basetype")
	public String basetype(@RequestParam("username")String username, @RequestParam("age")int age) {
		return "username:"+username+" age:"+age;
	}
	
	/**
	 * 包装类类型
	 * @param age
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/objtype")
	public String objtype(@RequestParam("age")Integer age) {
		return "Integer age:"+age;
	}
	
	/**
	 * http://localhost:8080/springmvc_databind/obj?id=123&name=asdsa&price=12.222
	 * 简单对象实体类型
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/obj")
	public String obj(User user) {
		return user.toString();
	}
	
	/**
	 * http://localhost:8080/springmvc_databind/objContainer?id=11&user.id=22&user.name=sad&user.price=12.5
	 * 嵌套的对象实体类型
	 * @param con
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/objContainer")
	public String objContainer(Container con) {
		return con.toString();
	}
	
	/**
	 * http://localhost:8080/springmvc_databind/multiObj?user.id=1&user.name=abc&user.price=12&role.id=231&role.name=haha
	 * 同时接受多组实体对象
	 * @param user
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/multiObj")
	public String multiObj(User user, Role role) {
		return user.toString() + role.toString();
	}
	
	@InitBinder("user")
	public void initUser(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("user.");
	}
	
	@InitBinder("role")
	public void initAdmin(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("role.");
	}
	
	/**
	 * http://localhost:8080/springmvc_databind/userList?users[0].id=123&users[1].id=111&users[5].id=555
	 * 跨序号中间对象属性为默认值
	 * 获取list对象
	 * @param userList
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/userList")
	public String userList(UserList userList) {
		return userList.toString();
	}
	
	/**
	 * http://localhost:8080/springmvc_databind/userSet?users[0].id=123&users[1].id=111
	 * 需要实例化具体数量的user对象，且参数序号(0开始)不能大于数量，否则出错
	 * 获取set对象
	 * @param userSet
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/userSet")
	public String userSet(UserSet userSet) {
		return userSet.toString();
	}
	
	/**
	 * http://localhost:8080/springmvc_databind/userMap?users['a'].id=100&users['b'].price=1100
	 * @param userMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/userMap")
	public String userMap(UserMap userMap) {
		return userMap.toString();
	}
	
	/**
	 * http://localhost:8080/springmvc_databind/array?array=a&array=b
	 * 接受数组
	 * @param array
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/array")
	public String array(String[] array) {
		return array.toString();
	}
	
	/**
	 * 接受list
	 * @param list
	 * @return
	 */
//	@ResponseBody
//	@RequestMapping("/list")
//	public String list(ArrayList<String> list) {
//		System.out.println(list);
//		return list.toString();
//	}
	
	/**
	 * map形式接受参数
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/map")
	public String map(@RequestParam Map<String,Object> map) {
		return map.toString();
	}
	
	/**
	 * http://localhost:8080/springmvc_databind/json
	 	{
			"id": "12",
			"name": "haha",
			"price": "12.11"
		}
	 * 接受json格式的user对象信息
	 * 需要jackson-databind包
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/json")
	public String json(@RequestBody User user) {
		return user.toString();
	}
	
	/**
	 * http://localhost:8080/springmvc_databind/xml
	 * 
	  	<user>
  			<id>123</id>
  			<name>haha</name>
		</user>
	 * 接受xml格式的user对象信息
	 * 1.需要spring-oxm包
	 * 2.接受实体对象添加注解,类对应root元素,set属性对应元素节点
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/xml", consumes="application/xml")
	public String xml(@RequestBody XMLObject obj) {
		System.out.println(obj);
		return obj.toString();
	}
}
