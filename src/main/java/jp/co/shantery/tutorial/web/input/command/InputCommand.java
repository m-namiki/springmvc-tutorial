/**
 * 
 */
package jp.co.shantery.tutorial.web.input.command;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * hello_input.jspで入力された情報を受け取るコマンドクラスです。
 * 
 * @author m-namiki
 * 
 */
public class InputCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 名前です。 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
