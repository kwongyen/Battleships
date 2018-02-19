package com.youngcolfield.battleship.config;

import com.youngcolfield.battleship.api.*;

import org.glassfish.jersey.server.ResourceConfig;


@org.springframework.context.annotation.Configuration
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(AccountEndpoints.class);
    register(MessageEndpoints.class);
    register(FriendEndpoints.class);
    register(StatsEndpoints.class);
    register(GameEndpoints.class);
    register(BoterKaasEierenEndpoints.class);
  }



}