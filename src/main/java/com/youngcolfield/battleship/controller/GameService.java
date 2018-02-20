package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.BoterKaasEieren;
import com.youngcolfield.battleship.domain.Game;
import com.youngcolfield.battleship.exceptions.InvalidGameException;
import com.youngcolfield.battleship.exceptions.InvalidTurnException;
import com.youngcolfield.battleship.misc.GameIdVO;
import com.youngcolfield.battleship.misc.GameVO;
import com.youngcolfield.battleship.misc.ShowGame;
import com.youngcolfield.battleship.misc.TurnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GameService {

  @Autowired
  private GameRepository gameRepository;

  @Autowired
  private AccountService accountService;

  @Autowired
  private BoterKaasEierenService boterKaasEierenService;

  public Long searchForGame(GameVO gameVO) {

    List<Game> gameList = gameRepository.findFreeGames();

    if (gameList.size() == 0){
      Game game = new Game();
      BoterKaasEieren bke = boterKaasEierenService.createBoterKaasEieren();
      game.setPlayerone(accountService.getAccount(gameVO.getPlayerId()));
      game.setCurrentPlayer(gameVO.getPlayerId());
      game.setBoterKaasEieren(bke);

      gameRepository.save(game);

      return game.getId();
    }
    joinGame(gameList.get(0), gameVO);
    return gameList.get(0).getId();
  }

  public void joinGame(Game game, GameVO gameVO){
    game.setPlayertwo(accountService.getAccount(gameVO.getPlayerId()));
  }

  public void playTurn(TurnVO turnVO) throws InvalidGameException, InvalidTurnException {

    Game currentGame = getGame(turnVO.getGameId());
    String player = turnVO.getPlayerId();

    if (!currentGame.getCurrentPlayer().equals(player)){
      throw new InvalidTurnException("It's the turn of the other player");
    }
    if(currentGame.getPlayertwo() == null){
      throw new InvalidTurnException("You don't have an opponent yet");
    }

    boterKaasEierenService.updateCellsById(turnVO.getGameId(), turnVO.getMove());
    if(currentGame.getPlayerone().getEmail().equals(player)){
      currentGame.setCurrentPlayer(currentGame.getPlayertwo().getEmail());
    }else{
      currentGame.setCurrentPlayer(currentGame.getPlayerone().getEmail());
    }
  }

  private Game getGame(Long gameId) throws InvalidGameException {
    Game game = gameRepository.findGameById(gameId);

    if (game == null) {
      throw new InvalidGameException("No game found with this Id");
    }
    return game;
  }

  public ShowGame showGame(GameIdVO gameIdVO) throws InvalidGameException {
    Game game = getGame(gameIdVO.getGameId());

    ShowGame showGame = new ShowGame();
    showGame.setBoterKaasEieren(game.getBoterKaasEieren());

    if(game.getCurrentPlayer().equals(gameIdVO.getPlayerId())){
      showGame.setYourTurn(true);
    }else{
      showGame.setYourTurn(false);
    }

    return showGame;
  }

}
