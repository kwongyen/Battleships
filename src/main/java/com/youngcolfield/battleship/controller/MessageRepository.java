package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query("select m from Message m where m.sender = :id")
    Message findMessagesByGameid(@Param("id") Long id);

    @Query("select m from Message m where m.receiver = :id")
    Message findReceivedMessagesByEmail(@Param("id") String id);

    @Query("select m from Message m where m.sender = :id")
    Message findSentMessagesByEmail(@Param("id") String id);
}
