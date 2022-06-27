package com.techwondoe.dtos;

import com.techwondoe.entites.Company;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;


public class CompanyDto {

  private int uuid;
  private String name;
  private String ceo;
  private String address;
  private List<TeamDto> teams = new ArrayList<>();
  private String inception;

  public CompanyDto() {
  }
  


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




public List<TeamDto> getTeams() {
	return teams;
}




public void setTeams(List<TeamDto> teams) {
	this.teams = teams;
}




public String getInception() {
	return inception;
}




public void setInception(String inception) {
	this.inception = inception;
}




public static CompanyDto from(Company company) {
    CompanyDto companyDto = new CompanyDto();
    companyDto.setAddress(company.getAddress());
    companyDto.setCeo(company.getCeo());
    companyDto.setName(company.getName());
    companyDto.setUuid(company.getUuid());
    companyDto.setInception(company.getInception().toString());
    companyDto.setTeams(company.getTeams().stream().map(TeamDto::from).collect(Collectors.toList()));
    return companyDto;
  }
}
