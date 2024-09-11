package com.talking_doctor.TalkingDoctor.service;

import com.talking_doctor.TalkingDoctor.dto.chatgpt.AssistantsCreateRequest;
import com.talking_doctor.TalkingDoctor.dto.chatgpt.CreateMessageRequest;
import com.talking_doctor.TalkingDoctor.dto.chatgpt.CreateRunsRequest;
import com.talking_doctor.TalkingDoctor.dto.chatgpt.AssistantsRequest;
import com.talking_doctor.TalkingDoctor.dto.chatgpt.MessageRequest;
import com.talking_doctor.TalkingDoctor.dto.chatgpt.RunsRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatgptService {

    private final RestTemplate restTemplate;
    private final String assistantModel = "gpt-4o-mini";
    private final String baseUrl = "https://api.openai.com/v1"; // Base URL for the API
    @Value("${openai.api.key}")
    private String apiKey; // Replace with your actual API key

    public ChatgptService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");
        return headers;
    }

    public ResponseEntity<?> createAssistant(AssistantsCreateRequest assistantCreateRequestDto) {
        try {
            AssistantsRequest requestDto = new AssistantsRequest(
                    assistantModel,
                    assistantCreateRequestDto.getName(),
                    assistantCreateRequestDto.getInstruction()
            );

            HttpEntity<AssistantsRequest> entity = new HttpEntity<>(requestDto, createHeaders());
            ResponseEntity<Object> res = restTemplate.exchange(
                    baseUrl + "/assistants",
                    HttpMethod.POST,
                    entity,
                    Object.class
            );
            return ResponseEntity.ok(res.getBody());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> createThreads() {
        try {
            HttpEntity<?> entity = new HttpEntity<>(createHeaders());
            ResponseEntity<Object> res = restTemplate.exchange(
                    baseUrl + "/threads",
                    HttpMethod.POST,
                    entity,
                    Object.class
            );
            return ResponseEntity.ok(res.getBody());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> deleteThreads(String threadId) {
        try {
            HttpEntity<?> entity = new HttpEntity<>(createHeaders());
            ResponseEntity<Object> res = restTemplate.exchange(
                    baseUrl + "/threads/" + threadId,
                    HttpMethod.DELETE,
                    entity,
                    Object.class
            );
            return ResponseEntity.ok(res.getBody());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> createMessages(String threadId, CreateMessageRequest createMessageRequestDto) {
        try {
            MessageRequest messagesRequestDto = new MessageRequest(
                    createMessageRequestDto.getRole(),
                    createMessageRequestDto.getContent()
            );

            HttpEntity<MessageRequest> entity = new HttpEntity<>(messagesRequestDto, createHeaders());
            ResponseEntity<Object> res = restTemplate.exchange(
                    baseUrl + "/threads/" + threadId + "/messages",
                    HttpMethod.POST,
                    entity,
                    Object.class
            );
            return ResponseEntity.ok(res.getBody());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getMessagesList(String threadId) {
        try {
            HttpEntity<?> entity = new HttpEntity<>(createHeaders());
            ResponseEntity<Object> res = restTemplate.exchange(
                    baseUrl + "/threads/" + threadId + "/messages",
                    HttpMethod.GET,
                    entity,
                    Object.class
            );
            return ResponseEntity.ok(res.getBody());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> createRuns(String threadId, CreateRunsRequest createRunsRequestDto) {
        try {
            RunsRequest runsRequestDto = new RunsRequest(createRunsRequestDto.getAssistantId());

            HttpEntity<RunsRequest> entity = new HttpEntity<>(runsRequestDto, createHeaders());
            ResponseEntity<Object> res = restTemplate.exchange(
                    baseUrl + "/threads/" + threadId + "/runs",
                    HttpMethod.POST,
                    entity,
                    Object.class
            );
            return ResponseEntity.ok(res.getBody());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}