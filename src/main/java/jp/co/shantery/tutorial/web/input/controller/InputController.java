/**
 * 
 */
package jp.co.shantery.tutorial.web.input.controller;

import javax.validation.Valid;

import jp.co.shantery.tutorial.service.InputService;
import jp.co.shantery.tutorial.util.Page;
import jp.co.shantery.tutorial.web.input.command.InputCommand;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 入力情報の受け取りを行うコントローラクラスです。
 * 
 * @author m-namiki
 * 
 */
@Controller
@RequestMapping(value = "/input")
public class InputController {

	/** コマンド名です。 */
	public static final String INPUT_COMMAND_NAME = "inputCommand";

	/** ロガーです。 */
	private static Logger logger = Logger.getLogger(InputController.class);

	/** サービスです。 */
	@Autowired
	private InputService service;

	/**
	 * コマンドの初期オブジェクトを作成します。<br>
	 * このメソッドを定義しなくてもコントローラとして動作しますが、バインドエラー時などに呼び出されるため存在しないとシステムエラーとなることがあります。
	 * 
	 * @return コマンド
	 */
	@ModelAttribute(INPUT_COMMAND_NAME)
	public InputCommand createInputCommand() {
		InputCommand command = new InputCommand();
		return command;
	}

	/**
	 * 初期表示の準備処理です。
	 * 
	 * @param model
	 *            画面モデル
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String init(Model model) {
		logger.info("init() Strat.");
		InputCommand command = createInputCommand();
		model.addAttribute(INPUT_COMMAND_NAME, command);
		logger.info("init() End.");

		return Page.PAGE_INPUT_INPUT;
	}

	/**
	 * 画面で入力された情報を受け取り、結果画面を表示します。
	 * 
	 * @param command
	 *            入力情報
	 * @param result
	 *            入力チェック結果
	 * @return hello_result.jspのパス
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView next(
			@ModelAttribute(INPUT_COMMAND_NAME) @Valid InputCommand command,
			BindingResult result) {
		logger.info("next() Strat.");

		ModelAndView view = new ModelAndView();

		// チェックエラーの場合は自画面遷移
		if (result.hasErrors()) {
			result.reject("errors.invalid");
			view.getModel().putAll(result.getModel());
			view.setViewName(Page.PAGE_INPUT_INPUT);
			return view;
		}

		view.setViewName(Page.PAGE_INPUT_RESULT);
		view.addObject("name", service.execute(command.getMailAddress()));
		logger.info("next() End.");
		return view;
	}
}
