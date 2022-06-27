package com.techwondoe.Controller;

import com.techwondoe.dtos.CompanyDto;
import com.techwondoe.services.CompanyService;
import java.text.ParseException;
import java.util.List;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwondoe.entites.Company;

@RestController
public class CompanyController {

  @Autowired
  private CompanyService companyService;

  //	Create CompanyDto
  @PostMapping("/company")
  public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto)
      throws ParseException {
    Company company = companyService.createCompany(Company.from(companyDto));
    return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);
  }

  //	GET CompanyDto by ID
  @GetMapping("/company/id/{companyId}")
  public ResponseEntity<CompanyDto> getCompanyById(@PathVariable int companyId) {
    final Company company = companyService.findById(companyId);
    return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);
  }

  //  Search company by the name
  @GetMapping("/company/name/{companyName}")
  public ResponseEntity<List<CompanyDto>> getCompanyByName(@PathVariable String companyName) {
    List<CompanyDto> companyDtos =
        companyService.findByName(companyName).stream().map(CompanyDto::from)
            .collect(Collectors.toList());
    return new ResponseEntity<>(companyDtos, HttpStatus.OK);
  }

  @GetMapping("/company/all")
  public ResponseEntity<List<CompanyDto>> getAllCompany() {
    List<CompanyDto> companyDtos =
        companyService.findAll().stream().map(CompanyDto::from).collect(Collectors.toList());
    return new ResponseEntity<>(companyDtos, HttpStatus.OK);
  }

}
