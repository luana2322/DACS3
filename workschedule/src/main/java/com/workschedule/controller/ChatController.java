package com.workschedule.controller;

import com.workschedule.model.Message;
import com.workschedule.model.User_Project;
import com.workschedule.model.Users;
import com.workschedule.repository.MessageRepository;
import com.workschedule.repository.UserProjectRepository;
import com.workschedule.service.serviceImpl.MessageServiceImpl;
import com.workschedule.service.serviceImpl.UserProjectServiceimpl;
import com.workschedule.service.serviceImpl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class ChatController {
    @Autowired
    private MessageServiceImpl messageServiceImpl;
    @Autowired
    private UserProjectServiceimpl userProjectServiceimpl;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserProjectRepository userProjectRepository;

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public Message register(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSenderName());
        log.info("user disconnected: {}", "nhận dữ liệu tại đây"+chatMessage.getSenderName());

        return chatMessage;
    }

    /**
     * Sends a chat message to all connected users.
     *
     * param chatMessage The chat message to be sent.
     * return The sent chat message.
     */
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message chatMessage) {
        log.info("user disconnected: {}", "nhận dữ liệu tại đây"+chatMessage.getMessage());



        messageServiceImpl.save(chatMessage);

        return chatMessage;
    }

    @GetMapping("/getallmessage")
    public ResponseEntity<List<Message>> getallconversation(@RequestParam("projectId") String projectId
                                                             , @RequestParam("userId") Long userId) {

        User_Project uspr=userProjectRepository.findUserProjectByUserAndProject(userId,projectId).get();

        List<Message> messageList=messageRepository.getallmessage(uspr.getUser_project_id());

        for(Message message:messageList){
            message.setUserProject(null);
        }

        return ResponseEntity.ok(messageRepository.getallmessage(uspr.getUser_project_id()));
    }


}