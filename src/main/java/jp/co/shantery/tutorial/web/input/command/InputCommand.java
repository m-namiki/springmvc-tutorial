/**
 * 
 */
package jp.co.shantery.tutorial.web.input.command;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * input.jspで入力された情報を受け取るコマンドクラスです。
 * 
 * @author m-namiki
 * 
 */
public class InputCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	/** メールアドレスです。 */
	private String mailAddress;

	/** パスワードです。 */
	private String password;

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
