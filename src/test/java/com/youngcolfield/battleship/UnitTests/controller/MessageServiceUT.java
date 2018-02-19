package com.youngcolfield.battleship.UnitTests.controller;

import com.youngcolfield.battleship.controller.AccountRepository;
import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.controller.MessageRepository;
import com.youngcolfield.battleship.controller.MessageService;
import com.youngcolfield.battleship.domain.Account;
import com.youngcolfield.battleship.domain.Message;
import com.youngcolfield.battleship.exceptions.InvalidRegistrationException;
import com.youngcolfield.battleship.misc.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceUT {

    @Mock
    private MessageRepository messageRepository;
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private MessageService messageService;
    @InjectMocks
    private AccountService accountService;

    @Test
    public void testReceive(){

        String testReceiverId = "you";
        String testSenderId = "me";
        String testMessageText = "hello";
        ArrayList<SimpleMessage> testSimpleMessageArrayList = new ArrayList<>();

        ChatVO testChatVO = new ChatVO();
        testChatVO.setReceiverId(testReceiverId);
        testChatVO.setSenderId(testSenderId);

        List<Message> messageList = messageRepository.findSentMessagesByEmail(accountRepository.findAccountByEmail(testChatVO.getReceiverId()), accountRepository.findAccountByEmail(testChatVO.getSenderId()));

        for (Message m : messageList){
            SimpleMessage simpleMessage = new SimpleMessage();
            simpleMessage.setDate(m.getDate());
            simpleMessage.setMessage(m.getMessage());

            testSimpleMessageArrayList.add(simpleMessage);
        }

        when(messageRepository.findAll()).thenReturn(messageList);

        ArrayList<SimpleMessage> simpleMessageArrayList;

        try {
            simpleMessageArrayList = messageService.receiveMessage(testChatVO);
        } catch (Exception e) {

            System.out.println(e);

            fail();
            return;
        }

        assertEquals(simpleMessageArrayList, testSimpleMessageArrayList);
    }


    @Test
    public void testSend(){
        String testReceiverId = "you";
        String testSenderId = "me";
        String testMessageText = "hello";

        MessageVO messageVO = new MessageVO();
        messageVO.setMessage(testMessageText);
        messageVO.setReceiver(testReceiverId);
        messageVO.setSender(testSenderId);

        Message message = new Message();
        message.setMessage(testMessageText);

        Account receiverAccount = new Account();
        receiverAccount.setEmail("you");
        message.setReceiver(receiverAccount);

        Account senderAccount = new Account();
        senderAccount.setEmail("me");
        message.setSender(senderAccount);

        when(messageRepository.save(any(Message.class))).thenReturn(message);

        String messageText;

        try {
            messageText = messageService.sendMessage(messageVO).getMessage();
        } catch (Exception e) {
            fail();
            return;
        }
        assertEquals(messageText, testMessageText);
    }
}
