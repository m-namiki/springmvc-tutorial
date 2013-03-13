/**
 * 
 */
package jp.co.shantery.tutorial.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * JSONのレスポンスを表現するDTOクラスです。
 * 
 * @author m-namiki
 * 
 */
public class JsonResponseDto {

	/** 名前です。 */
	private String name;

	/** 年齢です。 */
	private Integer age;

	/** 所属部署名です。 */
	private String departmentName;

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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
