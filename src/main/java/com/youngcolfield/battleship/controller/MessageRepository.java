package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
import com.youngcolfield.battleship.domain.Game;
import com.youngcolfield.battleship.domain.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query("select m from Message m where m.game = :id")
    List<Message> findMessagesByGameid(@Param("id") Game id);

    @Query("select m.message from Message m where m.receiver = :id")
    List<Message> findReceivedMessagesByEmail(@Param("id") Account id);

    @Query("select m from Message m where m.receiver =:receiverId and m.sender =:senderId")
    List<Message> findSentMessagesByEmail(@Param("receiverId") Account receiverId, @Param("senderId") Account senderId);
}
