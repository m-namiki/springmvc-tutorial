/**
 * 
 */
package jp.co.shantery.tutorial.web.json.controller;

import jp.co.shantery.tutorial.dto.JsonResponseDto;
import jp.co.shantery.tutorial.service.UserService;
import jp.co.shantery.tutorial.util.Page;
import jp.co.shantery.tutorial.web.json.command.JsonCommand;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	// ロガーです。
	private static final Logger logger = LoggerFactory
			.getLogger(JsonController.class);

	/** コマンド名です。 */
	public static final String COMMAND_NAME = "jsonCommand";

	/** ユーザー情報サービスです。 */
	@Autowired
	private UserService userService;

	@Autowired
	private Configuration configuration;

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
		return Page.PAGE_JSON_INPUT;
	}

	/**
	 * JSONを受け取り、JSONを返却します。
	 * 
	 * @param command
	 *            コマンド
	 */
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public JsonResponseDto execute(@RequestBody JsonCommand command) {
		logger.info("execute() Start.");

		logger.debug(configuration.getString("app.name"));

		if (logger.isDebugEnabled()) {
			logger.debug(command.toString());
		}

		JsonResponseDto dto = new JsonResponseDto();
		BeanUtils.copyProperties(command, dto,
				new String[] { "departmentName" });
		dto.setDepartmentName(userService.getDeptName(dto.getName()));

		if (logger.isDebugEnabled()) {
			logger.debug(dto.toString());
		}

		logger.info("execute() End.");
		return dto;
	}
}
