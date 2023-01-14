package ewidencja;

import ewidencja.activity.Absence;
import ewidencja.activity.Leave;
import ewidencja.activity.Presence;
import ewidencja.employee.Employee;

import java.text.ParseException;
import java.util.Scanner;
import ewidencja.ObjectIO;
import ewidencja.employee.Manager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Worktime_record_system {
    private static Employee employee;
    private static LoginScreen login_screen;
    private static Presence presence;

    public Worktime_record_system(){
    }

    public static void main(String[] args) {

        login_screen = new LoginScreen();
        ObjectIO objectIO = new ObjectIO();

//        employee = new Employee("Michal", "Sikacki");
//        employee.setUsername("student");
//        employee.setPassword("debil");
//        objectIO.WriteObjectToFile(employee, employee.getName(), employee.getSurname());

        Manager manager= new Manager();
        wrs_login(manager);

//        employee= (Employee) objectIO.ReadObjectFromFile("Michal", "Sikacki"); // testowe logowanie
        presence = new Presence();

        while(true){
            System.out.println("------------------------------------------------");
            System.out.println(employee.getName() + " " + employee.getSurname());
            System.out.println("Wybierz opcje: ");
            System.out.println("2. Potwierdz obecnosc: ");
            System.out.println("4. Wygeneruj raport: ");
            System.out.println("5. Dodaj urlop: ");
            Scanner scan = new Scanner(System.in);
            String employeeInput = scan.nextLine();

            switch(employeeInput){
                case "2":
                    wrs_confirm_presence();
                    break;
                case "4":
                    wrs_generate_report();
                    break;
                case "5":
                    wrs_leave_request();
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

    public void wrs_show_schedule(){}
    public static void wrs_generate_report(){
        System.out.println("------------------------------------------------");
        System.out.println("Wygenerowany raport: \n");
        employee.getReport().generate_report();
    }
    public void wrs_show_entry_details(int id){}
    public static void wrs_leave_request(){
        Absence absence = new Leave();
        wrs_set_start_end_date(absence);
        absence.create_absence(employee);
    }
    public static void wrs_set_start_end_date(Absence absence){
        long left_days;
        int userInput;
        do{
            Scanner scan = new Scanner(System.in);
            boolean formatOK = true;

            System.out.println("------------------------------------------------");
            absence.setStart_date();
            absence.setEnd_date();
            String st = absence.getStart_date();
            String en = absence.getEnd_date();

            left_days = wrs_left_vacation_days(st, en, absence);
            userInput = employee.getSchedule().getLeft_vacation_days();

            if(userInput == 0){
                System.out.println("Informacja nie zostala znaleziona w systemie lub brak dostępnych dni urlopowych");
                return;
            }

            if(left_days > userInput){
                System.out.println("Wprowadzony urlop nie moze zostac dodany, jego dlugosc jest wieksza niz liczba pozostalych" +
                        " dni urlopowych!");
            }
        }while(left_days > userInput);
    }
    public static long wrs_left_vacation_days(String start, String end, Absence absence){
        return absence.left_vacation_days(start, end);
    }
    public void wrs_business_trip_request(){}
    public void wrs_sick_leave_request(){}
    public void wrs_add_employee(){}
    public void wrs_remove_employee(){}
    public Employee wrs_choose_employee(){return null;}
    public void wrs_set_personal_data(){}
    public void wrs_make_schedule(){}
    public void wrs_process_leave_request(){}
    public void wrs_confirm_employee_presence(){}
}
