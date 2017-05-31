package pl.karol.littleshelter.object;

import lombok.Data;
import pl.karol.littleshelter.object.enumeration.NotificationMessageType;

@Data
public class NotificationMessage {
	
    private NotificationMessageType type;
    
    private String text;

    public NotificationMessage(NotificationMessageType type, String text) {
        this.type = type;
        this.text = text;
    }

}
