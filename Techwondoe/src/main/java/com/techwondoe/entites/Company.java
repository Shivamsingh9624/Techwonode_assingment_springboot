package com.techwondoe.entites;

import com.techwondoe.dtos.CompanyDto;
import com.techwondoe.dtos.TeamDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.Data;

@Entity
@Table(name = "company")
public class Company {

  @Id
  @GeneratedValue
  private int uuid;

  private String name;
  private String ceo;
  private String address;
  @OneToMany(
      cascade = CascadeType.ALL
  )
  @JoinColumn(name = "company_id")
  private List<Team> teams = new ArrayList<>();

  @JsonFormat(pattern = "yyyy/mm/dd", shape = Shape.STRING)
  private Date inception;
  
  
  

  public int getUuid() {
	return uuid;
}

public void setUuid(int uuid) {
	this.uuid = uuid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCeo() {
	return ceo;
}

public void setCeo(String ceo) {
	this.ceo = ceo;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public List<Team> getTeams() {
	return teams;
}

public void setTeams(List<Team> teams) {
	this.teams = teams;
}

public Date getInception() {
	return inception;
}

public void setInception(Date inception) {
	this.inception = inception;
}

public Company() {
  }

  public void addTeam(Team team) {
    teams.add(team);
  }

  public void removeTeam(Team team) {
    teams.remove(team);
  }

  public static Company from(CompanyDto companyDto) throws ParseException {
    Company company = new Company();
    company.setAddress(companyDto.getAddress());
    company.setCeo(companyDto.getCeo());
    company.setName(companyDto.getName());
    company.setUuid(companyDto.getUuid());
    company.setTeams(companyDto.getTeams().stream().map(Team::from).collect(Collectors.toList()));
    company.setInception(new SimpleDateFormat("yyyy/mm/dd").parse(companyDto.getInception()));
    return company;
  }

  public static void from(Company thisCompany, Company otherCompany) {
    thisCompany.setAddress(otherCompany.getAddress());
    thisCompany.setCeo(otherCompany.getCeo());
    thisCompany.setName(otherCompany.getName());
    thisCompany.setUuid(otherCompany.getUuid());
    thisCompany.setInception(otherCompany.getInception());
  }

}
