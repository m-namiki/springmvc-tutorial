/**
 * 
 */
package jp.co.shantery.tutorial.web.json.command;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * JSON形式で受け取った情報を保持するコマンドクラスです。
 * 
 * @author m-namiki
 * 
 */
public class JsonCommand implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 名前です。 */
	private String name;

	/** 年齢です。 */
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
