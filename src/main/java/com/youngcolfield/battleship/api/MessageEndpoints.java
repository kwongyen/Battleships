package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.MessageService;
import com.youngcolfield.battleship.misc.ChatVO;
import com.youngcolfield.battleship.misc.MessageVO;
import com.youngcolfield.battleship.misc.StatusVO;
import com.youngcolfield.battleship.misc.SimpleMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Slf4j
@Component
@Path("/message")
public class MessageEndpoints {

    @Autowired
    private MessageService messageService;

    @Path("/send")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendMessage(@Valid @NotNull MessageVO messageVO) {
        try {
            messageService.sendMessage(messageVO);
        } catch (Exception e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity(new StatusVO(e.toString())).build();
        }
        return Response.ok().build();
    }

    @Path("/receive")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response receiveMessages(@Valid @NotNull ChatVO chatVO) {
        List<SimpleMessage> simpleMessageList = messageService.receiveMessage(chatVO);
        return Response.ok(simpleMessageList).build();
    }
}
