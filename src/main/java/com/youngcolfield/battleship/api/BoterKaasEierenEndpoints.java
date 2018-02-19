package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.BoterKaasEierenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Component
@Path("/bke")
public class BoterKaasEierenEndpoints {

    @Autowired
    private BoterKaasEierenService boterKaasEierenService;

    @Path("/start")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBoterKaasEieren(){
        boterKaasEierenService.createBoterKaasEieren();
        return Response.ok().build();
    }

}
