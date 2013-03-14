/**
 * 
 */
package jp.co.shantery.tutorial.service.impl;

import jp.co.shantery.tutorial.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * {@link UserService}の実装クラスです。
 * 
 * @author m-namiki
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.co.shantery.tutorial.service.UserService#getDeptName(java.lang.String)
	 */
	@Override
	public String getDeptName(String name) {
		logger.info("getDeptName() Start.");
		if (logger.isDebugEnabled()) {
			logger.debug("name = [" + name + "]");
		}
		String deptName = "システム開発部";
		logger.info("getDeptName() End.");

		return deptName;
	}

}
