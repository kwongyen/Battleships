package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.StatsService;
import com.youngcolfield.battleship.domain.Stats;
import com.youngcolfield.battleship.misc.StatsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    @Path("/sortByWins")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sortByWins(){
        List<Stats> ranking = statsService.sortByWins();
        return Response.ok(ranking).build();
    }

    @Path("/sortByWinsLosses")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sortByWinRatio(){
        List<Stats> ranking = statsService.sortByWinRatio();
        return Response.ok(ranking).build();
    }

    @Path("/getRankUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRankUser(@Valid @NotNull StatsVO statsVO){
        Stats statsUser = statsService.getRankUser(statsVO);
        return Response.ok(statsUser).build();
    }

}
