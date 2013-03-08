/**
 * 
 */
package jp.co.shantery.config;

import java.util.EnumSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * SpringのContext設定を行うクラスです。<br>
 * Spring3.2より従来はweb.xmlで記述していた内容をJavaで記述できるようになりました。
 * 
 * @author m-namiki
 * 
 */
public class TutorialWebApplicationInitializer implements
		WebApplicationInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet
	 * .ServletContext)
	 */
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("jp.co.shantery.config");

		// spring-securityの設定
		FilterRegistration.Dynamic securityFilter = servletContext.addFilter(
				"securityFilter", new DelegatingFilterProxy(
						"springSecurityFilterChain"));
		securityFilter.addMappingForUrlPatterns(
				EnumSet.allOf(DispatcherType.class), true, "/*");

		// DispatcherServletの設定
		FilterRegistration.Dynamic characterEncodingFilter = servletContext
				.addFilter("characterEncodingFilter",
						new CharacterEncodingFilter());
		characterEncodingFilter.addMappingForUrlPatterns(
				EnumSet.allOf(DispatcherType.class), true, "/*");
		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
		characterEncodingFilter.setInitParameter("forceEncoding", "true");

		servletContext.addListener(new ContextLoaderListener(context));
		servletContext.setInitParameter("defaultHtmlEscape", "true");

		DispatcherServlet servlet = new DispatcherServlet();
		servlet.setContextConfigLocation("");

		ServletRegistration.Dynamic appServlet = servletContext.addServlet(
				"appServlet", servlet);
		appServlet.setLoadOnStartup(1);
		appServlet.setAsyncSupported(true);

		Set<String> mappingConflicts = appServlet.addMapping("/");
		if (!mappingConflicts.isEmpty()) {
			throw new IllegalStateException(
					"'appServlet' cannot be mapped to '/' under Tomcat versions <= 7.0.14");
		}
	}

}
