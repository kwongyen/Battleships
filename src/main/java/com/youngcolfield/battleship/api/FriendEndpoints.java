package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.FriendService;
import com.youngcolfield.battleship.misc.FriendVO;
import com.youngcolfield.battleship.misc.SimpleFriend;
import com.youngcolfield.battleship.misc.StatusVO;
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
@Path("/friend")
public class FriendEndpoints {

    @Autowired
    private FriendService friendService;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFriend(@Valid @NotNull FriendVO friendVO){
        try {
            friendService.addFriend(friendVO);
        }catch(Exception e){
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity(new StatusVO(e.toString())).build();
        }
        return Response.ok().build();
    }

    @Path("/get")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFriendList(@Valid @NotNull FriendVO friendVO){
        List<SimpleFriend> simpleFriendList = friendService.getFriendList(friendVO);

        return Response.ok(simpleFriendList).build();
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFriend(@Valid @NotNull FriendVO friendVO){
        try {
            friendService.deleteFriend(friendVO);
        }catch(Exception e){
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity(new StatusVO(e.toString())).build();
        }
        return Response.ok().build();
    }
}
