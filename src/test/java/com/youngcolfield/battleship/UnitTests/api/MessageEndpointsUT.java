package com.youngcolfield.battleship.UnitTests.api;

import com.youngcolfield.battleship.api.AccountEndpoints;
import com.youngcolfield.battleship.api.MessageEndpoints;
import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.controller.MessageService;
import com.youngcolfield.battleship.domain.Message;
import com.youngcolfield.battleship.exceptions.InvalidMessageException;
import com.youngcolfield.battleship.misc.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageEndpointsUT {

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageEndpoints messageEndpoints;

    @Test
    public void testSend(){

        MessageVO messageVO = new MessageVO();
        Message testMessage = new Message();
        testMessage.setMessage("hello");

        Response response = messageEndpoints.sendMessage(messageVO);

        assertEquals(200, response.getStatus());

    }

    @Test
    public void testReceive(){
        ChatVO chatVO = new ChatVO();

        ArrayList<SimpleMessage> simpleMessageArrayList = new ArrayList<>();
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setText("hello receive");
        simpleMessageArrayList.add(simpleMessage);

        try {
            when(messageService.receiveMessage(chatVO)).thenReturn(simpleMessageArrayList);
        } catch (Exception e){
            fail();
        }
        Response response = messageEndpoints.receiveMessages(chatVO);

        assertEquals(200, response.getStatus());
    }
}
