package com.techwondoe.dtos;

import com.techwondoe.entites.Company;
import com.techwondoe.entites.Team;
import lombok.Data;

public class TeamDto {

  private int UUID;
  private String teamLead;
  private String name;
  
  

  public int getUUID() {
	return UUID;
}



public void setUUID(int uUID) {
	UUID = uUID;
}



public String getTeamLead() {
	return teamLead;
}



public void setTeamLead(String teamLead) {
	this.teamLead = teamLead;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public static TeamDto from(Team team) {
    TeamDto teamDto = new TeamDto();
    teamDto.setTeamLead(team.getTeamLead());
    teamDto.setUUID(team.getUUID());
    teamDto.setName(team.getName());
    return teamDto;
  }
}
