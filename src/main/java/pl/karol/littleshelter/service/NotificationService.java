package pl.karol.littleshelter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.karol.littleshelter.object.NotificationMessage;
import pl.karol.littleshelter.object.enumeration.NotificationMessageType;

@Service
public class NotificationService {

    public static final String NOTIFICATION_MESSAGE_SESSION_KEY = "siteNotificationMessages";

    private HttpSession httpSession;
    
    @Autowired
    public NotificationService(HttpSession httpSession) {
		this.httpSession = httpSession;
	}


    public void addInfoMessage(String message) {
        addNotificationMessage(NotificationMessageType.INFO, message);
    }

    public void addErrorMessage(String message) {
        addNotificationMessage(NotificationMessageType.ERROR, message);
    }
    

	public void clearMessages() {
        List<NotificationMessage> notificationMessages = getNotificationMessagesList();
        notificationMessages.clear();
        httpSession.setAttribute(NOTIFICATION_MESSAGE_SESSION_KEY, notificationMessages);
		
	}

   
    private void addNotificationMessage(NotificationMessageType type, String message) {
        List<NotificationMessage> notificationMessages = getNotificationMessagesList();
        notificationMessages.add(new NotificationMessage(type, message));
        notificationMessages.sort((m1, m2) -> m1.getText().compareTo(m2.getText()));
        httpSession.setAttribute(NOTIFICATION_MESSAGE_SESSION_KEY, notificationMessages);
    }

    @SuppressWarnings("unchecked")
	private List<NotificationMessage> getNotificationMessagesList() {
		List<NotificationMessage> notificationMessages = ((List<NotificationMessage>) httpSession.getAttribute(NOTIFICATION_MESSAGE_SESSION_KEY));
        notificationMessages = Optional.ofNullable(notificationMessages).orElse(new ArrayList<NotificationMessage>());
		return notificationMessages;
	}


}
