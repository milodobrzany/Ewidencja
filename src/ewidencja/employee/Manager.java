package ewidencja.employee;

import ewidencja.ObjectIO;

import java.util.*;

public class Manager {
    List<Employee> employees;

    public Manager(){
        ObjectIO ObjectIO = new ObjectIO();
        employees = new ArrayList<>();
        ObjectIO.listFilesForFolder(employees);
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    public void add_employee(){

    }

    public void remove_employee(){

    }

    public void set_personal_data(){

    }

/*    public Employee choose_employee(String name, String surname){

    }

 */
}
