package com.workschedule.service.serviceImpl;

import com.workschedule.Exception.ResourceNotFoundException;
import com.workschedule.model.Message;
import com.workschedule.repository.MessageRepository;
import com.workschedule.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    List<Message> messageList;


    @Override
    public List<Message> findAll() {
        this.messageList = this.messageRepository.findAll();
        return this.messageList;
    }

    @Override
    public Message findById(Long id) {
        if (this.messageRepository.findById(id) != null) {
            Message message = (Message)this.messageRepository.findById(id).get();
            return message;
        } else {
            throw new ResourceNotFoundException("Cannot find message with id:"+id);
        }
    }

    @Override
    public void deteleById(Long id) {
    }

    @Override
    public Message save(Message message) {
        return null;
    }

    @Override
    public Message update(Message message) {
        return null;
    }
}
