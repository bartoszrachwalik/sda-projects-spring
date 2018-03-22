package com.github.spring.player.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Player {

    private Integer id;
    @NotBlank
    @Size(max = 16)
    private String name;
    @NotBlank
    @Size(max = 16)
    private String surname;

    private String teamName;

    public Player() {
    }

    public Player(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Player(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Player(Integer id, String name, String surname, String teamName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.teamName = teamName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        return surname != null ? surname.equals(player.surname) : player.surname == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
