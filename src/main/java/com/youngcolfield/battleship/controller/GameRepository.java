package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GameRepository extends CrudRepository<Game, Long>{

  @Query("select g from Game g where g.playerone = null or g.playertwo = null")
  List<Game> findFreeGames();

  @Query("select g from Game g where g.id = :id")
  Game findGameById(@Param("id") Long id);


}
