package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query("select m from Message m where m.sender = :id")
    Message findMessagesByGameid(@Param("id") Long id);

    @Query("select m.message from Message m where m.receiver = :id")
    List<String> findReceivedMessagesByEmail(@Param("id") String id);

    @Query("select m.message from Message m where m.sender = :id")
    List<String> findSentMessagesByEmail(@Param("id") String id);
}
