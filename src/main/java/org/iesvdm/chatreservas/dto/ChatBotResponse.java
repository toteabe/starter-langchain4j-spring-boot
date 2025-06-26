package org.iesvdm.chatreservas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatBotResponse {
    private String memoryId;
    private String responseMessage;
}
