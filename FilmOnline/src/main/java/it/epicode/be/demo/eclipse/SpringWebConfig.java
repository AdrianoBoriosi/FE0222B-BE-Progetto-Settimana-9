package it.epicode.be.demo.eclipse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
@ComponentScan({ "com.filmonline" })
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	/*
	 * By default, this handler serves static content from any of the /static,
	 * /public, /resources, and /META-INF/resources directories that are on the
	 * classpath.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
