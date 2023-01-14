package ewidencja;

import ewidencja.employee.Employee;
import ewidencja.employee.Manager;

import java.util.Objects;
import java.util.Scanner;

public class LoginScreen implements iLoginScreen{
    private String username;
    private String password;

    public LoginScreen(){

    }
    @Override
    public void login(Manager manager){
        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("------------------------------------------------");
            System.out.println("Wprowadz nazwe uzytkownika: ");
            String user = scan.nextLine();
            System.out.println("Wprowadz haslo: ");
            String pass = scan.nextLine();

            this.username = user;
            this.password = pass;

            if(!check_if_exist(manager)){
                System.out.println("Nie znaleziono nazwy uzytkownika lub pole puste!");
            }
        }while(!check_if_exist(manager));
    }
    private boolean check_if_exist(Manager manager){
        for(Employee emp: manager.getEmployees()){
            if(Objects.equals(emp.getUsername(), username)) {
                return true;
            }
        }
        return false;
    }
    public Employee verify(Manager manager){
        for(Employee emp: manager.getEmployees()){
            if(Objects.equals(emp.getUsername(), username)) {
                if(Objects.equals(emp.getPassword(), password)){
                    System.out.println("Pomyslnie zalogowano! ");
                    return emp;
                }
            }
        }
        System.out.println("Bledne haslo!");
        return null;
    }
}
