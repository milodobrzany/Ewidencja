package ewidencja.employee;

import ewidencja.activity.Absence;
import ewidencja.entry.Report;

public class Employee {
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    /*public Schedule getSchedule() {
        return schedule;
    }*/

    /*public Report getReport() {
        return report;
    }*/

    /*public void add_absence(Absence absence){

    }*/

}
