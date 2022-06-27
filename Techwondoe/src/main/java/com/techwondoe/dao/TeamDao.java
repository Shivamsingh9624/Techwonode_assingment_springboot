package com.techwondoe.dao;

import com.techwondoe.entites.Company;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techwondoe.entites.Team;

public interface TeamDao extends JpaRepository<Team, Integer> {
}
