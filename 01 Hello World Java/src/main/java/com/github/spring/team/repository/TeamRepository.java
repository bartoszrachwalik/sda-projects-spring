package com.github.spring.team.repository;

import com.github.spring.team.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Integer> {

    Optional<TeamEntity> findByName(String name);
}
