package org.iesvdm.chatreservas.dto;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageType;
import dev.langchain4j.data.message.UserMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

import static dev.langchain4j.data.message.ChatMessageDeserializer.messagesFromJson;

@Getter
@Setter
@AllArgsConstructor
public class ChatBotMessage {
    private String memoryId;
    private String message;
    private boolean isUser;

    public static List<ChatBotMessage> fromJson(String memoryId, String messages) {
        final List<ChatBotMessage> chatBotMessages = new LinkedList<>();
        List<ChatMessage> chatMessages = messagesFromJson(messages);
        chatMessages.forEach(chatMessage -> chatBotMessages
                .add(new ChatBotMessage(memoryId, ((UserMessage)chatMessage).singleText(), chatMessage.type().equals(ChatMessageType.USER))));
        return chatBotMessages;
    }
}
