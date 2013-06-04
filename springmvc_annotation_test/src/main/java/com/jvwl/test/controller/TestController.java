package com.jvwl.test.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jvwl.test.model.User;

@Controller
@RequestMapping("test")
// 也可以写成@RequestMapping("/test")
// 类路径是加在下面的路径上的
public class TestController {

	@RequestMapping("start")
	// 也可以写成@RequestMapping("/start")
	// 完整请求路径为：.../test/start.do
	public String start() {
		System.out.println("controller start method");
		return "start";
	}

	@RequestMapping("param/{name}")
	// 接收传过来的参数
	// 完整请求路径为：.../test/start/传过来的参数.do 如：.../test/start/aaa.do
	public String param(@PathVariable String name) {// 此处变量名name要与{name}中的一致
		// @PathVariable只能用于编译模式为debug,
		// 如果编译模式为release则要用@PathVariable("name")这种模式，此处变量名可以不一致
		System.out.println(name);
		return "start";
	}
 // <—— ② 如果URL请求中包括"method=listAllBoard"的参数，由本方法进行处理
    @RequestMapping(params = "method=listAllBoard") 
    public String listAllBoard() {
        bbtForumService.getAllBoard();
        System.out.println("call listAllBoard method.");
        return "listBoard";
    }

    // <—— ③ 如果URL请求中包括"method=listBoardTopic"的参数，由本方法进行处理
    @RequestMapping(params = "method=listBoardTopic")
    public String listBoardTopic(int topicId) {
        bbtForumService.getBoardTopics(topicId);
        System.out.println("call listBoardTopic method.");
        return "listTopic";
    }

	// 接收两个参数
	@RequestMapping("params/{name}/{age}")
	public String params(@PathVariable String name, @PathVariable int age) {
		System.out.println(name);
		System.out.println(age);
		return "start";
	}

	// 处理Get请求
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public String methodGet() {
		System.out.println("methodGet");
		return "start";
	}

	// 处理Post请求
	@RequestMapping(value = "post", method = RequestMethod.POST)
	public String methodPost() {
		System.out.println("methodPost");
		return "start";
	}

	// 处理Date类型数据
	@RequestMapping(value = "date/{date}", method = RequestMethod.GET)
	public String testDate(@PathVariable Date date) {
		System.out.println(date);
		return "start";
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyyMMdd"), false));
	}

	@RequestMapping("xxx")
	public String testAllArgument(HttpServletRequest request,
			HttpServletResponse response,
			// 取Session时注意Session是否可用，
			// 如果初次调用，可能Session不能用，会报异常
			HttpSession session,
			// 可以.../aa/{name}.do中的name值
			@PathVariable String name,// 可把String改成其它任意类型
			// 可以取.../aa/kk.do?id=123中的id值
			@RequestParam String id) {// 可把String改成其它任意类型
		// @CookieValue String cookieName 取出名为cookieName的值//可把String改成其它任意类型
		// @RequestHeader("user-Agent") String abc
		// 取出头中名为user-Agent的值//可把String改成其它任意类型

		return "start";
	}

	@RequestMapping("xxx")
	public String testAllArguments(PrintWriter out, Map model) {
		out.print("anything");
		model.put("key", "value");
		return "viewName";
	}

	@RequestMapping("xxx")
	public String testAllArguments1(User user,// 接收传入的模型数据
			// 如果绑定或类型转换出错了，就会放到result里
			BindingResult result) {
		return "viewName";
	}

	// 返回值类型有：1.void,
	//2.String(代表viewName) 也可以放入model对象
	//3.可返回实体对象
	//4.可返回List集合
	//5.可返回任意类型
	//6.可返回模型model(map（视图名按默认解析）或ModelAndView)
	@RequestMapping("xxx")
	public void testVoid() {
		//生成隐含的viewName--按请求路径 ${appName}/test/xxx.do -->test/xxx --> /WEB-INF/content/test/xxx.jsp
	}
	
	@RequestMapping("xxx")
	public User testModel() {
		User user;
		//model("user",user) key为类名并首字母小写
		return null;
	}
	@RequestMapping("xxx")
	public List<User> queryUsers() {
		List<User> users;
		//model("userList",users) key为所装实体类名并首字母小写+"List"
		//在页面取：${userList}或者request.getAttribute("userList")
		return null;
	}
	
	@RequestMapping(value="addUser",method=RequestMethod.POST)
	public String addUser(User user){
		//重定向视图,需要视图解析器支持，Internal解析器支持重定向
		return "redirect:addUserSuccess";//return "redirect:/addUserSuccess";
	}
	
	//数据验证
	@RequestMapping("xxx")
	public String testValid(@Valid User user,//用的java标准,验证出错的信息将放入BindingResult
			BindingResult result) {
		if(result.hasErrors()){
			return "formView";
		}
		return "viewSuccess";
	}
}
