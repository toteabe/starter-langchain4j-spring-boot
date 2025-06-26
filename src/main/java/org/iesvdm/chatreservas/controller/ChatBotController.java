package org.iesvdm.chatreservas.controller;

import org.iesvdm.chatreservas.ai.HairChatBotBookingSystem;
import org.iesvdm.chatreservas.dto.ChatBotRequest;
import org.iesvdm.chatreservas.dto.ChatBotResponse;
import dev.langchain4j.service.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatBotController {
    private final HairChatBotBookingSystem chatBotAgent;

    @PostMapping(value = "/chatbot/message", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ChatBotResponse> message(@RequestBody ChatBotRequest request) {
        Result<String> answer = chatBotAgent.answer(request.getMemoryId(), request.getMessage());
        return ResponseEntity.ok(new ChatBotResponse(request.getMemoryId(), answer.content()));
    }
}