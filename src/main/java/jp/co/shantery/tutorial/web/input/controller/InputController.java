/**
 * 
 */
package jp.co.shantery.tutorial.web.input.controller;

import jp.co.shantery.tutorial.web.input.command.InputCommand;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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

	/** 入力画面のパスです。 */
	private static final String PAGE_INPUT = "input/input";

	/** 結果画面のパスです。 */
	private static final String PAGE_RESULT = "input/result";

	/** ロガーです。 */
	private static Logger logger = Logger.getLogger(InputController.class);

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

		return PAGE_INPUT;
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
			@ModelAttribute(INPUT_COMMAND_NAME) InputCommand command,
			BindingResult result) {
		logger.info("next() Strat.");

		// 入力チェック
		if (StringUtils.isEmpty(command.getMailAddress())) {
			result.rejectValue("mailAddress", "errors.required");
		}
		if (StringUtils.isEmpty(command.getPassword())) {
			result.rejectValue("password", "errors.required");
		}

		ModelAndView view = new ModelAndView();

		// チェックエラーの場合は自画面遷移
		if (result.hasErrors()) {
			view.getModel().putAll(result.getModel());
			view.setViewName(PAGE_INPUT);
			return view;
		}

		view.setViewName(PAGE_RESULT);
		view.addObject("name", command.getMailAddress());
		logger.info("next() End.");
		return view;
	}
}
