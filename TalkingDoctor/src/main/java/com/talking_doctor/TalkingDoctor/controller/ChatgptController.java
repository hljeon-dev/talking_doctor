package com.talking_doctor.TalkingDoctor.controller;

import com.talking_doctor.TalkingDoctor.dto.chatgpt.AssistantsCreateRequest;
import com.talking_doctor.TalkingDoctor.dto.chatgpt.CreateMessageRequest;
import com.talking_doctor.TalkingDoctor.dto.chatgpt.CreateRunsRequest;
import com.talking_doctor.TalkingDoctor.service.ChatgptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatgptController {

    private final ChatgptService chatgptService;

    @Autowired
    public ChatgptController(ChatgptService chatgptService) {
        this.chatgptService = chatgptService;
    }

    @PostMapping("/assistant")
    public ResponseEntity<?> createAssistant(@RequestBody AssistantsCreateRequest assistantCreateRequest) {
        return chatgptService.createAssistant(assistantCreateRequest);
    }

    @PostMapping("/threads")
    public ResponseEntity<?> createThreads() {
        return chatgptService.createThreads();
    }

    @DeleteMapping("/threads/{threadId}")
    public ResponseEntity<?> deleteThreads(@PathVariable String threadId) {
        return chatgptService.deleteThreads(threadId);
    }

    @PostMapping("/messages/{threadId}")
    public ResponseEntity<?> createMessages(@PathVariable String threadId, @RequestBody CreateMessageRequest createMessageRequest) {
        return chatgptService.createMessages(threadId, createMessageRequest);
    }

    @GetMapping("/messages/list")
    public ResponseEntity<?> getMessagesList(@RequestParam String threadId) {
        return chatgptService.getMessagesList(threadId);
    }

    @PostMapping("/runs/{threadId}")
    public ResponseEntity<?> createRuns(@PathVariable String threadId, @RequestBody CreateRunsRequest createRunsRequest) {
        return chatgptService.createRuns(threadId, createRunsRequest);
    }
}
