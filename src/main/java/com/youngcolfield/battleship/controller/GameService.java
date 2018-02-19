package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Game;
import com.youngcolfield.battleship.exceptions.InvalidGameException;
import com.youngcolfield.battleship.exceptions.InvalidTurnException;
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

  public Long searchForGame(GameVO gameVO) {

    List<Game> gameList = gameRepository.findFreeGames();

    if (gameList.size() == 0){
      Game game = new Game();
      game.setPlayerone(accountService.getAccount(gameVO.getPlayerOneId()));
      game.setCurrentPlayer(gameVO.getPlayerOneId());

      gameRepository.save(game);

      return game.getId();
    }
    return gameList.get(0).getId();
  }

  public void playTurn(TurnVO turnVO) throws InvalidGameException, InvalidTurnException {

    Game currentGame = getGame(turnVO.getGameId());

    if (!currentGame.getCurrentPlayer().equals(turnVO.getPlayerId())){
      throw new InvalidTurnException("It's the turn of the other player");
    }

    // implement game logic

  }

  private Game getGame(Long gameId) throws InvalidGameException {
    Game game = gameRepository.findGameById(gameId);

    if (game == null) {
      throw new InvalidGameException("No game found with this Id");
    }
    return game;
  }

  public ShowGame showGame(Long gameId) throws InvalidGameException {
    Game game = getGame(gameId);

    ShowGame showGame = new ShowGame();
    showGame.setBoterKaasEieren(game.getBoterKaasEieren());



    return showGame;
  }

}
