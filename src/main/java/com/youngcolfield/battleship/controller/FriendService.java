package com.youngcolfield.battleship.controller;

import com.youngcolfield.battleship.domain.Friend;
import com.youngcolfield.battleship.exceptions.InvalidFriendException;
import com.youngcolfield.battleship.misc.FriendVO;
import com.youngcolfield.battleship.misc.SimpleFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FriendService {
    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    private AccountRepository accountRepository;

    public void addFriend(FriendVO friendVO) throws InvalidFriendException{
        List<Friend> friendList = friendRepository.findFriendsById(accountRepository.findAccountByUsername(friendVO.getUser()));
        for(Friend f : friendList) {
            if (f.getFriend().getUsername().equals(friendVO.getFriend())) {
                throw new InvalidFriendException("This person is already your friend");
            }
        }
        Friend friend = new Friend();
        friend.setUser(accountRepository.findAccountByUsername(friendVO.getUser()));
        friend.setFriend(accountRepository.findAccountByUsername(friendVO.getFriend()));
        friendRepository.save(friend);
    }

    public ArrayList<SimpleFriend> getFriendList(FriendVO friendVO){
       List<Friend> friendList = friendRepository.findFriendsById(accountRepository.findAccountByUsername(friendVO.getUser()));
       ArrayList<SimpleFriend> simpleFriendArrayList = new ArrayList<SimpleFriend>();
       for(Friend f : friendList){
           SimpleFriend simpleFriend = new SimpleFriend();
           simpleFriend.setFriendname((f.getFriend()).getUsername());
           simpleFriend.setFriendsince(f.getFriendsince());
           simpleFriend.setPlayedgames(f.getPlayedgames());

           simpleFriendArrayList.add(simpleFriend);
       }
       return simpleFriendArrayList;
    }
}
