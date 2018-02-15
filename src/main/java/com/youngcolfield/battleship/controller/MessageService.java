package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Message;
import com.youngcolfield.battleship.exceptions.InvalidMessageException;
import com.youngcolfield.battleship.misc.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.LocalGregorianCalendar;

import java.time.LocalDateTime;
import java.util.Date;

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

        messageRepository.save(message);
    }

    public Iterable<Message> receiveMessage(){
        return messageRepository.findAll();
    }

}
