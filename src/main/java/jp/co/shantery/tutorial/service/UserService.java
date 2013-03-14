/**
 * 
 */
package jp.co.shantery.tutorial.service;

/**
 * ユーザー情報を操作するサービスインターフェースです。
 * 
 * @author m-namiki
 * 
 */
public interface UserService {

	/**
	 * 指定された名前を持つユーザーの所属部署名を返却します。
	 * 
	 * @param name
	 *            名前
	 * @return 所属部署名
	 */
	String getDeptName(String name);

}
