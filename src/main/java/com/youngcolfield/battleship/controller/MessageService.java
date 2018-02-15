package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Message;
import com.youngcolfield.battleship.misc.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;


    public void sendMessage(MessageVO messageVO){

        Message message = new Message();

        message.setDate(messageVO.getDate());
        message.setMessage(messageVO.getMessage());
        message.setReceiver(messageVO.getReceiver());
        message.setSender(message.getSender());

        messageRepository.save(message);
    }

    public Iterable<Message> receiveMessage(){
        return messageRepository.findAll();
    }

}
