package com.youngcolfield.battleship.api;

import com.youngcolfield.battleship.controller.GameService;
import com.youngcolfield.battleship.domain.Game;
import com.youngcolfield.battleship.misc.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Component
@Path("/game")
public class GameEndpoints {

  @Autowired
  private GameService gameService;

  @Path("/search")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response searchForGame(@Valid @NotNull GameVO gameVO){
    Long gameId;
    try {
      gameId = gameService.searchForGame(gameVO);
    } catch (Exception e) {
      return Response.status(500).entity(new StatusVO("Error in creating a new game, please try again")).build();
    }
    return Response.ok(gameId).build();
  }

  @Path("/turn")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response playTurn(TurnVO turnVO){
    try {
      gameService.playTurn(turnVO);
    } catch (Exception e) {
      return Response.status(400).entity(new StatusVO(e.toString())).build();
    }
    return Response.ok().build();
  }

  @Path("/show")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response showGame(GameIdVO gameIdVO){
    ShowGame showGame;
    try {
      showGame = gameService.showGame(gameIdVO);
    } catch (Exception e) {
      return Response.status(400).entity(new StatusVO(e.toString())).build();
    }
    return Response.ok(showGame).build();
  }
}
