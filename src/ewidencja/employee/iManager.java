package ewidencja.employee;

import ewidencja.activity.Absence;

public interface iManager {
    void add_employee(Employee employee);
    void remove_employee();
    void set_personal_data();
    Employee choose_employee(String name, String surname);
    void process_leave_request(Employee emp, int number, String input); //dodane
}
