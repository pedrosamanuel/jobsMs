package com.manuel.company.company;

import com.manuel.company.company.clients.ReviewClient;
import com.manuel.company.company.dto.ReviewMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    ReviewClient reviewClient;

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

    public void updateCompany(ReviewMessage reviewMessage) {
        Double average = reviewClient.getAverageRating(reviewMessage.getCompanyId());
        Optional<Company> companyOptional = companyRepository.findById(reviewMessage.getCompanyId());
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setAverage(average);
            companyRepository.save(company);
        }
    }
}
