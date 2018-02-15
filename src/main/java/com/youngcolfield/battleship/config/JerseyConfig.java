package com.youngcolfield.battleship.config;

import com.youngcolfield.battleship.api.AccountEndpoints;
import com.youngcolfield.battleship.api.MessageEndpoints;
import com.youngcolfield.battleship.controller.AccountRepository;
import com.youngcolfield.battleship.controller.AccountService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(AccountEndpoints.class);
    register(MessageEndpoints.class);
  }

  @Bean(name="AccountService")
  public AccountService getAccountService() {
    return new AccountService();
  }
}