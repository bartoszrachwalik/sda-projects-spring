package com.github.spring.player.service;

import com.github.spring.player.entity.PlayerEntity;
import com.github.spring.player.model.Player;
import com.github.spring.player.repository.PlayerRepository;
import com.github.spring.team.entity.TeamEntity;
import com.github.spring.team.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public List<Player> findAll() {
        return toPlayersList(playerRepository.findAll());
    }

    public void add(Player player) {
        argumentValidation(player);
        playerRepository.save(toEntity(player));
    }

    public Optional<Player> findOne(Integer id) {
        return playerRepository.findById(id).map(this::toPlayer);
    }

    public void remove(Player player) {
        argumentValidation(player);
        playerRepository.delete(toEntity(player));
    }

    public void edit(Player player) {
        argumentValidation(player);
        checkArgument(player.getId() != null, "Player needs id to be edited!");

        Optional<TeamEntity> team = teamRepository.findByName(player.getTeamName());
        PlayerEntity playerEntity = toEntity(player);
        team.ifPresent(playerEntity::setTeam);

        if (!team.isPresent()) {
            TeamEntity teamEntity = new TeamEntity(player.getTeamName());
            teamRepository.save(teamEntity);
        }
        playerRepository.save(playerEntity);
    }

    private void argumentValidation(Player player) {
        checkArgument(player.getName() != null && !player.getName().equals(""), "Name can not be null or empty");
        checkArgument(player.getSurname() != null && !player.getSurname().equals(""), "Surname can not be null or empty");
    }

    private PlayerEntity toEntity(Player player) {
        return new PlayerEntity(player.getName(), player.getSurname());
    }

    private Player toPlayer(PlayerEntity entity) {
        return new Player(entity.getName(), entity.getSurname());
    }

    private List<Player> toPlayersList(List<PlayerEntity> entities) {
        return entities.stream().map(this::toPlayer).collect(Collectors.toList());
    }
}
