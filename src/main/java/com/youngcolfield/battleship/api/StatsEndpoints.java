package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.StatsService;
import com.youngcolfield.battleship.domain.Stats;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Slf4j
@Component
@Path("/stats")
public class StatsEndpoints {

    @Autowired
    private StatsService statsService;

    @Path("/getRanking")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRanking(){
        List<Stats> ranking = statsService.getRanking();
        return Response.ok(ranking).build();
    }

}
