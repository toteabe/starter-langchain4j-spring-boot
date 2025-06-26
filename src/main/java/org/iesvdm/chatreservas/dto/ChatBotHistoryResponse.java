package org.iesvdm.chatreservas.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChatBotHistoryResponse {
    private String memoryId;
    private List<ChatBotMessage> messages;
}
