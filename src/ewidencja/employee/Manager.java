package ewidencja.employee;

import ewidencja.ObjectIO;
import ewidencja.activity.Absence;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public void add_employee(Employee employee){
        ObjectIO objectIO = new ObjectIO();
        employees.add(employee);
        objectIO.WriteObjectToFile(employee, employee.getName(), employee.getSurname());
    }

    @Override
    public void remove_employee(){

    }

    @Override
    public void set_personal_data(){

    }

    @Override
    public void process_leave_request(Employee chosenEmployee, int number, String input){
        ObjectIO objectIO= new ObjectIO();

        if(Objects.equals(input, "1")){
            Absence empAbsence = chosenEmployee.getReport().choose_absence(number);
            empAbsence.setIsConfirmed(true);
            objectIO.WriteObjectToFile(chosenEmployee, chosenEmployee.getName(), chosenEmployee.getSurname());
        }
        else{
            chosenEmployee.getReport().deleteAbsence(number);
            objectIO.WriteObjectToFile(chosenEmployee, chosenEmployee.getName(), chosenEmployee.getSurname());
        }
    }

    public boolean isGood(String text, String fieldType){
        if(Objects.equals(fieldType, "username")) {
            for (Employee emp : employees) {
                if (Objects.equals(emp.getUsername(), text))
                    return false;
            }
            return true;
        }
        else if(Objects.equals(fieldType, "password")) {
            int passLength = text.length();
            if(passLength >= 10){
                Pattern letter = Pattern.compile("[a-zA-Z]");
                Pattern digit = Pattern.compile("[0-9]");
                Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

                Matcher hasLetter = letter.matcher(text);
                Matcher hasDigit = digit.matcher(text);
                Matcher hasSpecial = special.matcher(text);

                return hasLetter.find() && hasDigit.find() && hasSpecial.find();
            }
            else
                return false;

        }
        else if(Objects.equals(fieldType, "email")){
            Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
            Matcher mat = pattern.matcher(text);

            if(mat.matches()){
                return true;
            }else{
                return false;
            }
        }
        return true; // domyslnie
    }

    @Override
    public Employee choose_employee(String name, String surname) {
        for(Employee emp: employees){
            if(Objects.equals(emp.getName(), name) && Objects.equals(emp.getSurname(), surname))
                return emp;
        }
        System.out.println("Podany pracownik nie istnieje w systemie!");
        return null;
    }
    public void showEmployees() {
        int i = 1;
        for(Employee emp: employees){
            System.out.println(Integer.toString(i) + ". " + emp.getName() + " " + emp.getSurname());
            i++;
        }
    }
}
