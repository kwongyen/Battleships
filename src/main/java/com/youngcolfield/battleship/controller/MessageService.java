package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Message;
import com.youngcolfield.battleship.exceptions.InvalidMessageException;
import com.youngcolfield.battleship.misc.ChatVO;
import com.youngcolfield.battleship.misc.MessageVO;
import com.youngcolfield.battleship.misc.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private AccountRepository accountRepository;

    public void sendMessage(MessageVO messageVO) throws InvalidMessageException{

        Message message = new Message();

        if (accountRepository.findAccountByEmail(messageVO.getReceiver()) == null || accountRepository.findAccountByEmail(messageVO.getSender()) == null) {
            throw new InvalidMessageException("Either receiver or sender is not a known user");
        }

        message.setMessage(messageVO.getMessage());
        message.setReceiver(accountRepository.findAccountByEmail(messageVO.getReceiver()));
        message.setSender(accountRepository.findAccountByEmail(messageVO.getSender()));
        message.setDate(LocalDateTime.now());

        messageRepository.save(message);
    }

    public ArrayList<SimpleMessage> receiveMessage(ChatVO chatVO) {
        List<Message> messageList = messageRepository.findSentMessagesByEmail(accountRepository.findAccountByEmail(chatVO.getReceiverId()), accountRepository.findAccountByEmail(chatVO.getSenderId()));

        ArrayList<SimpleMessage> simpleMessageArrayList = new ArrayList<>();

        for (Message m : messageList){
          SimpleMessage simpleMessage = new SimpleMessage();
          simpleMessage.setDate(m.getDate());
          simpleMessage.setMessage(m.getMessage());

          simpleMessageArrayList.add(simpleMessage);

        }
        return simpleMessageArrayList;
    }
}
