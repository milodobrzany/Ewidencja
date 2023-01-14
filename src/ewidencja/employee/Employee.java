package ewidencja.employee;

import ewidencja.activity.Absence;
import ewidencja.entry.Report;

import java.io.Serial;
import java.io.Serializable;

public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String hierarchy_type;
    private Schedule schedule;
    private Report report;
    private Absence absences;

    public Employee (String name, String surname){
        this.name = name;
        this.surname = surname;
        report = new Report();
        schedule = new Schedule();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHierarchy_type(String hierarchy_type) {
        this.hierarchy_type = hierarchy_type;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Report getReport() {
        return report;
    }

}
