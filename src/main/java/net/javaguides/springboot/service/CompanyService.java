package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Company;
import net.javaguides.springboot.model.Employee;

import java.util.List;

public interface CompanyService {
        List<Company> getAllCompanies();
        void saveCompany(Company company);
}
