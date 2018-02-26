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
        List<Friend> friendList = friendRepository.findFriendsById(accountRepository.findAccountByEmail(friendVO.getUser()));

        if (accountRepository.findUsernameByEmail(friendVO.getUser())==null){
            throw new InvalidFriendException("User does not exist");
        }

        if (accountRepository.findUsernameByEmail(friendVO.getFriend())==null){
            throw new InvalidFriendException("This person does not exist in our database");
        }

        for(Friend f : friendList) {
            if (f.getFriend().getEmail().equals(friendVO.getFriend())) {
                throw new InvalidFriendException("This person is already your friend");
            }
        }
        Friend friend = new Friend();
        friend.setUser(accountRepository.findAccountByEmail(friendVO.getUser()));
        friend.setFriend(accountRepository.findAccountByEmail(friendVO.getFriend()));
        friendRepository.save(friend);
    }

    public ArrayList<SimpleFriend> getFriendList(FriendVO friendVO) throws InvalidFriendException{

        try {
            List<Friend> friendList = friendRepository.findFriendsById(accountRepository.findAccountByEmail(friendVO.getUser()));
            ArrayList<SimpleFriend> simpleFriendArrayList = new ArrayList<SimpleFriend>();
            for (Friend f : friendList) {
                SimpleFriend simpleFriend = new SimpleFriend(f);
                simpleFriendArrayList.add(simpleFriend);
            }
            return simpleFriendArrayList;
        } catch (Exception e) {
            throw new InvalidFriendException("wrong");
        }
    }

    public void deleteFriend(FriendVO friendVO) throws InvalidFriendException{

        Friend friend = friendRepository.findFriendByUserAndFriend(accountRepository.findAccountByEmail(friendVO.getUser()),accountRepository.findAccountByEmail(friendVO.getFriend()));
        if(friend == null){
            throw new InvalidFriendException("This person is not in your friend list");
        }else {
            friendRepository.delete(friend);
        }
    }
}
