package com.github.spring.web;

import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

@Service
public class PlayerService {

    private List<Player> players = new LinkedList<>();

    public List<Player> findAll() {
        return players;
    }

    public void add(Player player) {
        argumentValidation(player);
        players.add(player);
    }

    public void remove(Player player) {
        argumentValidation(player);
        players.remove(player);
    }

    private void argumentValidation(Player player) {
        checkArgument(player.getName() != null && !player.getName().equals(""), "Name can not be null or empty");
        checkArgument(player.getSurname() != null && !player.getSurname().equals(""), "Surname can not be null or empty");
    }
}