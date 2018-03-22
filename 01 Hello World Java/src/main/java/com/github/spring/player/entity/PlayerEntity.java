package com.github.spring.player.entity;

import com.github.spring.team.entity.TeamEntity;

import javax.persistence.*;

@Entity
@Table(name = "player", catalog = "league")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    @ManyToOne
    private TeamEntity team;

    public PlayerEntity() {
    }

    public PlayerEntity(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public PlayerEntity(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
