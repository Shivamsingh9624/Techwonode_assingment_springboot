package com.techwondoe.entites;

import com.techwondoe.dtos.TeamDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;

@Data
@Entity
@Table(name = "team")
public class Team {

  @Id
  @GeneratedValue
  private int UUID;

  @Column(name = "team_lead")
  private String teamLead;

  @Column
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

public Team() {
  }

  public static Team from(TeamDto teamDto) {
    Team team = new Team();
    team.setTeamLead(teamDto.getTeamLead());
    team.setUUID(teamDto.getUUID());
    team.setName(teamDto.getName());
    return team;
  }

}
