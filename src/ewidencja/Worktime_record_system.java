package ewidencja;

import ewidencja.activity.Presence;
import ewidencja.employee.Employee;
import ewidencja.ObjectIO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Worktime_record_system {
    private static Employee employee;
    private LoginScreen login_screen;

    public Worktime_record_system(){}

    public static void main(String[] args) {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        Date date = new Date();
//        System.out.println(formatter.format(date));
//        System.out.println(java.time.LocalDate.now());
//        String data = java.time.LocalTime.now().toString();
//        System.out.println(data);
        ObjectIO objectIO = new ObjectIO();
//        employee = new Employee("Michal", "Sikacki");
//        objectIO.WriteObjectToFile(employee);
        employee = (Employee) objectIO.ReadObjectFromFile();
        System.out.println(employee.getName());
        employee.getReport().generate_report();
    }

    public void wrs_login(){
    }

    public void wrs_confirm_presence(String username, String password){
        Presence presence = new Presence();
        presence.create_presence(employee);

    }

    public void wrs_show_schedule(){}
    public void wrs_generate_report(){}
    public void wrs_show_entry_details(int id){}
    public void wrs_leave_request(){}
    public void wrs_set_start_end_date(String start_date, String end_date){}
    public int wrs_left_vacation_days(){return 1;}
    public void wrs_business_trip_request(){}
    public void wrs_sick_leave_request(){}
    public void wrs_add_employee(){}
    public void wrs_remove_employee(){}
//    public Employee wrs_choose_employee(){}
    public void wrs_set_personal_data(){}
    public void wrs_make_schedule(){}
    public void wrs_process_leave_request(){}
    public void wrs_confirm_employee_presence(){}
}
