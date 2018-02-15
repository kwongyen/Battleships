package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.controller.MessageService;
import com.youngcolfield.battleship.domain.Game;
import com.youngcolfield.battleship.domain.Message;
import com.youngcolfield.battleship.misc.AccountLoginId;
import com.youngcolfield.battleship.misc.MessageVO;
import com.youngcolfield.battleship.misc.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.resources.Messages;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MessageEndpoints {

    @Autowired
    private MessageService messageService;
    //private Game game;

    @Path("/sendMessage")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void sendMessage(MessageVO messageVO) {
            messageService.sendMessage(messageVO);
    }

    @Path("/receiveMessages")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response receiveMessages() {
        Iterable<Message> listMessages = messageService.receiveMessage();
        return Response.ok(listMessages).build();
    }
}
