package com.manuel.company.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }
    public Company getCompanyById(Long id){
        return companyRepository.findById(id).orElse(null);
    }
    public void createCompany(Company company){
        companyRepository.save(company);
    }
    public Boolean deleteCompany(Long id){
        try {
            companyRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public Boolean updateCompany(Long id, Company updatedComp){
        Optional<Company> actualCompany = companyRepository.findById(id);
        if (actualCompany.isPresent()){
            Company company = actualCompany.get();
            company.setName(updatedComp.getName());
            company.setDescription(updatedComp.getName());
            companyRepository.save(company);
            return true;
        }
        return false;
    }
}
