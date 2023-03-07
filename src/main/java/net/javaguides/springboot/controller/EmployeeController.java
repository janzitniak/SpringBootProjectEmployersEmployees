package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Company;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.CompanyService;
import net.javaguides.springboot.service.EmployeeService;
import net.javaguides.springboot.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Musi byt anotacia Controller, aby sa vedel spustit
@Controller
public class EmployeeController {

    // premenna EmployeeService je interface, nie trieda
    // skusal som aj EmployeeServiceImpl a slo to
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyService companyService;

    // display list of employees
    // GetMapping odkazuje na hlavnu webovu stranku, teda /
    @GetMapping("/")
    public String viewHomePage(Model model) {
        // listEmployees je vlastne to, co sa zobrazi index.html v resources/templates
        // v prikaze <tr th:each="employee:${listEmployees}">
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        // return "index" sa odkazuje na subor index.html
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("companies", companyService.getAllCompanies());
        return "new_employee";
    }

    @GetMapping("/showNewCompanyForm")
    public String showNewCompanyForm(Model model) {
        // create model attribute to bind form data
        Company company = new Company();
        model.addAttribute("company", company);
        return "new_company";
    }

    @PostMapping("/saveEmployee")
    // koresponduje s <form action="#" th:action="@{/saveEmployee}" th:object="${employee}" v subore new_employee.html
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @PostMapping("/saveCompany")
    // koresponduje s <form action="#" th:action="@{/saveEmployee}" th:object="${employee}" v subore new_employee.html
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value="id") long userid, Model model) {
        // get employee from the service
        Employee employee = employeeService.getEmployeeById(userid);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        model.addAttribute("companies", companyService.getAllCompanies());
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value="id") long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
