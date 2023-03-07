package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Company;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

}
