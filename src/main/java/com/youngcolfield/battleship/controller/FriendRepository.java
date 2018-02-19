package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Account;
import com.youngcolfield.battleship.domain.Friend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendRepository extends CrudRepository<Friend, Long> {

    @Query("select f from Friend f where f.user = :id")
    List<Friend> findFriendsById(@Param("id")Account id);

    @Query("select f from Friend f where f.user = :userId and f.friend = :friendId")
    Friend findFriendByUserAndFriend(@Param("userId")Account userId, @Param("friendId")Account friendId);
}
