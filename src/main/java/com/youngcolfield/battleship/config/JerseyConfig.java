package com.youngcolfield.battleship.config;

import com.youngcolfield.battleship.api.*;
import com.youngcolfield.battleship.controller.AccountService;
import com.youngcolfield.battleship.domain.BoterKaasEieren;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(AccountEndpoints.class);
    register(MessageEndpoints.class);
    register(FriendEndpoints.class);
    register(GameEndpoints.class);
    register(BoterKaasEierenEndpoints.class);
  }


}