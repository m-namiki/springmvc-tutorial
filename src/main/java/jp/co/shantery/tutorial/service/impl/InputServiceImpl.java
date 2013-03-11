/**
 * 
 */
package jp.co.shantery.tutorial.service.impl;

import jp.co.shantery.tutorial.service.InputService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * {@link InputService}の実装クラスです。
 * 
 * @author m-namiki
 * 
 */
@Service
public class InputServiceImpl implements InputService {

	/** ロガーです。 */
	private static Logger logger = Logger.getLogger(InputServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.co.shantery.tutorial.service.InputService#execute(java.lang.String)
	 */
	@Override
	public String execute(String mailAddress) {
		logger.info("execute() : " + mailAddress);
		return mailAddress;
	}

}
