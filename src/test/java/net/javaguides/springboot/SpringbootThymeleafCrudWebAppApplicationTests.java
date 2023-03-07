package net.javaguides.springboot;

import net.javaguides.springboot.model.Company;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.CompanyRepository;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootThymeleafCrudWebAppApplicationTests {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Test
	void contextLoads() {
		Company company = new Company();
		company.setName("Google");


		Employee employee1 = new Employee();
		employee1.setFirstName("Peter");
		employee1.setLastName("Dvorský");
		employee1.setEmail("peter.dvorsky@gmail.com");
		employee1.setCompany(company);

		Employee employee2 = new Employee();
		employee2.setFirstName("Ivana");
		employee2.setLastName("Krásna");
		employee2.setEmail("ivana.krasna@gmail.com");
		employee2.setCompany(company);

		companyRepository.save(company);
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);

	}

}
