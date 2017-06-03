package pl.karol.littleshelter.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import pl.karol.littleshelter.service.NotificationService;

@Component
public class NotificationInterceptor extends HandlerInterceptorAdapter {
	
	NotificationService notificationService;
	
	@Autowired
	public NotificationInterceptor(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		notificationService.clearMessages();
		return true;
	}

}
