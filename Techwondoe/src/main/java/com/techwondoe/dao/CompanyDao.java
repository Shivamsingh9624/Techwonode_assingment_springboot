package com.techwondoe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techwondoe.entites.Company;

public interface CompanyDao extends JpaRepository<Company, Integer> {
  List<Company> findByName(String companyName);
}
