package com.techwondoe.Controller;

import com.techwondoe.dtos.CompanyDto;
import com.techwondoe.dtos.TeamDto;
import com.techwondoe.entites.Company;
import com.techwondoe.services.TeamService;
import java.util.List;

import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.techwondoe.entites.Team;

@Controller
public class TeamController {

  @Autowired
  private TeamService teamService;

  //	Create Team
  @PostMapping("/team/{companyId}")
  public ResponseEntity<CompanyDto> addTeam(@PathVariable int companyId, @RequestBody TeamDto teamDto) {
    Company company = teamService.createTeam(companyId, Team.from(teamDto));
    return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);
  }

  //	Get All Teams
  @GetMapping("/team")
  public ResponseEntity<List<TeamDto>> getAllTeam() {
    List<TeamDto> teamDtos =
        teamService.findAll().stream().map(TeamDto::from).collect(Collectors.toList());
    return new ResponseEntity<>(teamDtos, HttpStatus.OK);
  }

  //	GET CompanyDto by ID
  @GetMapping("/team/id/{teamId}")
  public ResponseEntity<TeamDto> getTeamById(@PathVariable int teamId) {
    final Team team = teamService.findById(teamId);
    return new ResponseEntity<>(TeamDto.from(team), HttpStatus.OK);
  }
}
