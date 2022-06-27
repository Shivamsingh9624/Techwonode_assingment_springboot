package com.techwondoe.services;

import com.techwondoe.dao.TeamDao;
import com.techwondoe.entites.Company;
import com.techwondoe.entites.Team;
import exceptions.CustomResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

  @Autowired
  private TeamDao repo;

  @Autowired
  private CompanyService companyService;

  public Team findById(final int teamId) {
    return repo.findById(teamId).orElseThrow(CustomResourceNotFoundException::new);
  }

    public Company addTeamToCompany(final int companyId, final Team team) {
      Company company = companyService.findById(companyId);
      company.addTeam(team);
      return companyService.createCompany(company);
    }

  @Transactional
  public Company createTeam(int companyId, Team team) {
    Team dbteam = repo.saveAndFlush(team);
    return addTeamToCompany(companyId, dbteam);
  }

  public List<Team> findAll() {
    return repo.findAll();
  }
}
