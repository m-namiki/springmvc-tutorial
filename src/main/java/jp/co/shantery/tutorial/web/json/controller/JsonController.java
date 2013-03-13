/**
 * 
 */
package jp.co.shantery.tutorial.web.json.controller;

import jp.co.shantery.tutorial.dto.JsonResponseDto;
import jp.co.shantery.tutorial.web.json.command.JsonCommand;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * JSONの受け取り及び出力を行うコントローラクラスです。
 * 
 * @author m-namiki
 * 
 */
@Controller
@RequestMapping(value = "/json")
public class JsonController {
	/** コマンド名です。 */
	public static final String COMMAND_NAME = "jsonCommand";

	/** 入力画面のパスです。 */
	private static final String PAGE_INPUT = "json/input";

	/** ロガーです。 */
	private static Logger logger = Logger.getLogger(JsonController.class);

	/**
	 * コマンドの初期オブジェクトを作成します。<br>
	 * このメソッドを定義しなくてもコントローラとして動作しますが、バインドエラー時などに呼び出されるため存在しないとシステムエラーとなることがあります。
	 * 
	 * @return コマンド
	 */
	@ModelAttribute(COMMAND_NAME)
	public JsonCommand createCommand() {
		JsonCommand command = new JsonCommand();
		return command;
	}

	/**
	 * 初期表示の準備処理です。
	 * 
	 * @param model
	 *            画面モデル
	 * @return 入力画面のパス
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String init(Model model) {
		logger.info("init() Start.");
		model.addAttribute(COMMAND_NAME, createCommand());
		logger.info("init() End.");
		return PAGE_INPUT;
	}

	/**
	 * JSONを受け取り、JSONを返却します。
	 * 
	 * @param command
	 *            コマンド
	 */
	@RequestMapping(produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponseDto execute(@RequestBody JsonCommand command) {
		logger.info("execute() Start.");

		if (logger.isDebugEnabled()) {
			logger.debug(command);
		}

		JsonResponseDto dto = new JsonResponseDto();
		dto.setName(command.getName());
		dto.setAge(command.getAge());
		dto.setDepartmentName("開発部");

		if (logger.isDebugEnabled()) {
			logger.debug(dto);
		}

		logger.info("execute() End.");
		return dto;
	}

}
