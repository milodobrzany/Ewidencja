package ewidencja;

import ewidencja.activity.Presence;
import ewidencja.employee.Employee;
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
//        employee.setUsername("mic609");
//        employee.setPassword("samsunek");
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
            Scanner scan = new Scanner(System.in);
            String employeeInput = scan.nextLine();

            switch(employeeInput){
                case "2":
                    wrs_confirm_presence();
                    break;
                case "4":
                    wrs_generate_report();
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
    public void wrs_leave_request(){}
    public void wrs_set_start_end_date(String start_date, String end_date){}
    public int wrs_left_vacation_days(){return 1;}
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
