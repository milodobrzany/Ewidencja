package ewidencja.employee;

import ewidencja.ObjectIO;
import java.util.*;

public class Manager implements iManager{
    List<Employee> employees;

    public Manager(){
        ObjectIO ObjectIO = new ObjectIO();
        employees = new ArrayList<>();
        ObjectIO.listFilesForFolder(employees);
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    @Override
    public void add_employee(){

    }

    @Override
    public void remove_employee(){

    }

    @Override
    public void set_personal_data(){

    }

    @Override
    public Employee choose_employee(String name, String surname) {
        return null;
    }
}
