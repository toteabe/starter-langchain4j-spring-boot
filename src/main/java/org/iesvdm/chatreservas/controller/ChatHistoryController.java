package org.iesvdm.chatreservas.controller;

import org.iesvdm.chatreservas.dto.ChatBotHistoryResponse;
import org.iesvdm.chatreservas.dto.ChatBotMessage;
import org.iesvdm.chatreservas.model.Message;
import org.iesvdm.chatreservas.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ChatHistoryController {
    private final MessageRepository messageRepository;

    @GetMapping(value = "/message/history", produces = "application/json")
    public ResponseEntity<ChatBotHistoryResponse> message(@RequestParam String memoryId) {
        Optional<Message> messages = messageRepository.findByMemoryId(memoryId);
        if (messages.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ChatBotHistoryResponse response = new ChatBotHistoryResponse();
        response.setMemoryId(memoryId);
        
        messages.ifPresent(message -> {
            List<ChatBotMessage> chatBotMessages = ChatBotMessage.fromJson(memoryId, message.getMessages());
            response.setMessages(chatBotMessages);
        });

        return ResponseEntity.ok(response);
    }
}
