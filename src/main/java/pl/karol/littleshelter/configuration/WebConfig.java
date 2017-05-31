package pl.karol.littleshelter.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import pl.karol.littleshelter.interceptor.NotificationInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	NotificationInterceptor notificationInterceptor;

	public WebConfig(NotificationInterceptor notificationInterceptor) {
		this.notificationInterceptor = notificationInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(notificationInterceptor);
	}

}
