package com.techwondoe.services;

import com.techwondoe.dao.CompanyDao;
import com.techwondoe.entites.Company;
import com.techwondoe.entites.Team;
import exceptions.CustomResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

  @Autowired
  private CompanyDao repo;


  public Company findById(final int companyId) {
    return repo.findById(companyId).orElseThrow(
        CustomResourceNotFoundException::new);
  }

  public Company createCompany(Company company) {
    return repo.saveAndFlush(company);
  }

  public List<Company> findByName(final String companyName) {
    return repo.findByName(companyName);
  }

  public List<Company> findAll() {
    return repo.findAll();
  }
}
