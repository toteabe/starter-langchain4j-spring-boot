package org.iesvdm.chatreservas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatBotRequest {
    private String memoryId;
    private String message;
}
