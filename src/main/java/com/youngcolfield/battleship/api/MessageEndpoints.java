package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.controller.MessageService;
import com.youngcolfield.battleship.domain.Game;
import com.youngcolfield.battleship.domain.Message;
import com.youngcolfield.battleship.misc.AccountLoginId;
import com.youngcolfield.battleship.misc.MessageVO;
import com.youngcolfield.battleship.misc.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.resources.Messages;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/message")
public class MessageEndpoints {

    @Autowired
    private MessageService messageService;
    //private Game game;

    @Path("/send")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendMessage(MessageVO messageVO) {
            messageService.sendMessage(messageVO);
            return Response.ok().build();
    }

    @Path("/receive")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response receiveMessages() {
        Iterable<Message> listMessages = messageService.receiveMessage();
        return Response.ok(listMessages).build();
    }
}
