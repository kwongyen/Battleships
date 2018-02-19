package com.youngcolfield.battleship.misc;

import com.youngcolfield.battleship.domain.BoterKaasEieren;
import lombok.Data;

@Data
public class ShowGame {
  private BoterKaasEieren boterKaasEieren;
  private Boolean yourTurn;

}
