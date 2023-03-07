package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Company;
import net.javaguides.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
