/**
 * 
 */
package jp.co.shantery.tutorial.web.hello.controller;

import java.util.Date;

import jp.co.shantery.tutorial.util.Page;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HelloWorldを表示するコントローラです。
 * 
 * @author m-namiki
 * 
 */
@Controller
public class HelloWorldController {

	private static Logger logger = Logger.getLogger(HelloWorldController.class);

	/**
	 * hello.jspを表示します。
	 * 
	 * @return hello.jspのパス
	 */
	@RequestMapping("/hello")
	public ModelAndView index() {
		logger.info("index() Start.");

		ModelAndView view = new ModelAndView();
		view.setViewName(Page.PAGE_HELLO_HELLO);
		view.addObject("message", "Hello Spring MVC world.");
		view.addObject("currentDate", new Date());

		logger.info("index() End.");
		return view;
	}

}
