package ewidencja;

import ewidencja.activity.Absence;
import ewidencja.activity.Leave;
import ewidencja.activity.Presence;
import ewidencja.employee.Employee;

import java.text.ParseException;
import java.util.Objects;
import java.util.Scanner;
import ewidencja.ObjectIO;
import ewidencja.employee.Manager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Worktime_record_system {
    private static Employee employee;
    private static LoginScreen login_screen;
    private static Manager manager;
    private static Presence presence;

    public Worktime_record_system(){
    }

    public static void main(String[] args) {

        login_screen = new LoginScreen();
        ObjectIO objectIO = new ObjectIO();

//        employee = new Employee("Michal", "Sikacki");
//        employee.setUsername("student");
//        employee.setPassword("Student123#");
//        employee.setEmail("234567@student.pwr.edu.pl");
//        employee.setHierarchy_type("Kierownik");
//        objectIO.WriteObjectToFile(employee, employee.getName(), employee.getSurname());

        manager= new Manager();
        wrs_login(manager);

//        employee= (Employee) objectIO.ReadObjectFromFile("Michal", "Sikacki"); // testowe logowanie
        presence = new Presence();

        System.out.println(employee.getHierarchy_type());

        while(true){
            System.out.println("------------------------------------------------");
            System.out.println(employee.getName() + " " + employee.getSurname());
            System.out.println("Wybierz opcje: ");
            System.out.println("1. Potwierdz obecnosc: ");
            System.out.println("2. Wygeneruj raport: ");
            System.out.println("3. Dodaj urlop: ");
            System.out.println("4. Potwierdz obecnosc pracownika: ");
            System.out.println("5. Rozpatrz wniosek: ");
            System.out.println("6. Dodaj pracownika: ");
            System.out.println("7. Wyjdz z programu: ");
            Scanner scan = new Scanner(System.in);
            String employeeInput = scan.nextLine();

            switch(employeeInput){
                case "1":
                    wrs_confirm_presence();
                    break;
                case "2":
                    wrs_generate_report();
                    break;
                case "3":
                    wrs_leave_request();
                    break;
                case "4":
                    if(Objects.equals(employee.getHierarchy_type(), "Kierownik")) {
                        wrs_confirm_employee_presence();
                    }
                    else {
                        System.out.println("Odmowa dostepu!");
                    }
                    break;
                case "5":
                    if(Objects.equals(employee.getHierarchy_type(), "Kierownik")) {
                        wrs_process_leave_request();
                    }
                    else {
                        System.out.println("Odmowa dostepu!");
                    }
                    break;
                case "6":
                    if(Objects.equals(employee.getHierarchy_type(), "Kierownik")) {
                        wrs_add_employee();
                    }
                    else {
                        System.out.println("Odmowa dostepu!");
                    }
                    break;
                case "7":
                    System.exit(0);
                    break;
            }
        }
    }

    public static void wrs_login(Manager manager){
        login_screen.login(manager);
        employee = login_screen.verify(manager);
        if(employee == null)
            System.exit(0);
    }

    public static void wrs_confirm_presence(){
        if(!presence.getPresenceFinished())
            presence.create_presence(employee);
        else{
            presence = new Presence();
            presence.create_presence(employee);
        }
    }

    public static void wrs_show_schedule(){}
    public static void wrs_generate_report(){
        System.out.println("------------------------------------------------");
        System.out.println("Wygenerowany raport: \n");
        employee.getReport().generate_report();
    }
    public static void wrs_show_entry_details(int id){}
    public static void wrs_leave_request(){
        Absence absence = new Leave();
        wrs_set_start_end_date(absence);
        absence.create_absence(employee);
    }

    public static void wrs_set_start_end_date(Absence absence){
        long left_days;
        int userInput;
        do{
            System.out.println("------------------------------------------------");
            absence.setStart_date();
            absence.setEnd_date();
            String st = absence.getStart_date();
            String en = absence.getEnd_date();

            left_days = wrs_left_vacation_days(st, en, absence);////////////
            userInput = employee.getSchedule().getLeft_vacation_days();

            if(userInput == 0){
                System.out.println("Informacja nie zostala znaleziona w systemie lub brak dostępnych dni urlopowych");
                return;
            }

            if(left_days < userInput){
                System.out.println("Wprowadzony urlop nie moze zostac dodany, jego dlugosc jest wieksza niz liczba pozostalych" +
                        " dni urlopowych!");
            }
        }while(left_days < userInput);
    }

    public static long wrs_left_vacation_days(String start, String end, Absence absence){
        return absence.left_vacation_days(start, end);/////////////////
    }
    public static void wrs_business_trip_request(){}
    public static void wrs_sick_leave_request(){}
    public static void wrs_add_employee(){
        Employee addedEmployee = new Employee("", "");
        wrs_set_personal_data(addedEmployee);
        manager.add_employee(addedEmployee);
    }
    public static void wrs_remove_employee(){}
    public static Employee wrs_choose_employee(){
        manager.showEmployees();
        System.out.println("\n");
        Scanner scan = new Scanner(System.in);
        String empName, empSurname;
        System.out.println("Podaj imie: ");
        empName = scan.nextLine();
        System.out.println("Podaj nazwisko: ");
        empSurname = scan.nextLine();
        return manager.choose_employee(empName, empSurname);
    }
    public static void wrs_set_personal_data(Employee addedEmployee){
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.println("Wprowadz imie: \n");
        input = scan.nextLine();
        addedEmployee.setName(input);

        System.out.println("Wprowadz nazwisko: \n");
        input = scan.nextLine();
        addedEmployee.setSurname(input);

        boolean statement;
        do{
            System.out.println("Wprowadz nazwe uzytkownika: \n");
            input = scan.nextLine();
            statement = manager.isGood(input, "username");
            if(!statement)
                System.out.println("Nazwa uzytkownika zajeta!");
            else
                addedEmployee.setUsername(input);

        }while(!statement);

        do{
            System.out.println("Wprowadz haslo: \n");
            input = scan.nextLine();
            statement = manager.isGood(input, "password");
            if(!statement)
                System.out.println("Haslo musi zawierac co najmniej 10 znakow, cyfre, litere oraz znak specjalny!");
            else
                addedEmployee.setPassword(input);

        }while(!statement);

        do{
            System.out.println("Wprowadz email: \n");
            input = scan.nextLine();
            statement = manager.isGood(input, "email");
            if(!statement)
                System.out.println("Nieprawidlowy format!");
            else
                addedEmployee.setEmail(input);

        }while(!statement);

        System.out.println("Wprowadz typ stanowiska- (Kierownik/Pracownik)");  // nie ma kontroli wejscia
        input = scan.nextLine();
        addedEmployee.setHierarchy_type(input);

        System.out.println("Dodano pracownika!");
    }
    public static void wrs_make_schedule(){}

    public static void wrs_process_leave_request(){  ///////process_leave_request
        Scanner scan = new Scanner(System.in);

        Employee chosenEmployee = new Employee("", "");
        chosenEmployee = wrs_choose_employee();
        chosenEmployee.getReport().generate_report();
        System.out.println("Wybierz absencje (Id): ");
        String input = scan.nextLine();

        try{
            int number = Integer.parseInt(input);
            Absence empAbsence = chosenEmployee.getReport().choose_absence(number);

            if(empAbsence == null)
                return;

            System.out.println("Zatwierdzic? (0- nie, 1- tak): ");
            input = scan.nextLine();
            manager.process_leave_request(chosenEmployee, number, input); //dodane
        }
        catch (NumberFormatException ex){
            System.out.println("Niewlasciwy format danych");
        }
        System.out.println("Wniosek rozpatrzony!");
    }

    public static void wrs_confirm_employee_presence(){
        Scanner scan = new Scanner(System.in);

        Employee chosenEmployee = new Employee("", "");
        chosenEmployee = wrs_choose_employee();

        Presence empPresence = new Presence();
        empPresence.create_subordinate_presence(chosenEmployee);
    }
}
