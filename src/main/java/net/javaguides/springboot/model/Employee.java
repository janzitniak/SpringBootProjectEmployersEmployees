package net.javaguides.springboot.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="birthday_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdayDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;


    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
        /*
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = (Date)formatter.parse(this.birthdayDate.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
         */
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
