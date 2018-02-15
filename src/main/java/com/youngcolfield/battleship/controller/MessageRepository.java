package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MessageRepository extends CrudRepository<Message, String> {

}
